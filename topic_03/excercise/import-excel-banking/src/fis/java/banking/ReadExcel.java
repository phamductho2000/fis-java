package fis.java.banking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static List<TransactionHistory> transactionHistories = new ArrayList<TransactionHistory>();

	public static final int COLUMN_INDEX_DATE = 1;
	public static final int COLUMN_INDEX_AMOUNT = 2;
	public static final int COLUMN_INDEX_BALANCE = 3;
	public static final int COLUMN_INDEX_DETAIL = 4;

	public void read(String excelFilePath) throws IOException {
		// Get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));

		// Get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);

		// Get sheet
		Sheet sheet = workbook.getSheetAt(0);

		// Get all rows
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				// Ignore header
				continue;
			}

			// Get all cells
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			// Read cells and set value for book object
			TransactionHistory transactionHistory = new TransactionHistory();
			while (cellIterator.hasNext()) {
				// Read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}
				// Set value for object
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case COLUMN_INDEX_DATE:
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					try {
						transactionHistory.setDate(formatter.parse(getCellValue(cell).toString()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case COLUMN_INDEX_AMOUNT:
					transactionHistory.setAmount(Double.valueOf(getCellValue(cell).toString().replace(",", "")));
					break;
				case COLUMN_INDEX_BALANCE:
					transactionHistory.setBalance(
							Double.valueOf(getCellValue(cell).toString().replace(",", "").replace("VND", "").trim()));
					break;
				case COLUMN_INDEX_DETAIL:
					transactionHistory.setAccountNumber(getAccountNumberFromDetail(getCellValue(cell).toString()));
					transactionHistory.setDetail(getCellValue(cell).toString());
					break;
				default:
					break;
				}
			}
			transactionHistories.add(transactionHistory);
		}
		workbook.close();
		inputStream.close();
		TransactionManagement.setTransactionHistories(transactionHistories);
	}

	// Get Workbook
	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

	// Get cell value
	private static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
		case BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case FORMULA:
			Workbook workbook = cell.getSheet().getWorkbook();
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			cellValue = evaluator.evaluate(cell).getNumberValue();
			break;
		case NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case _NONE:
		case BLANK:
		case ERROR:
			break;
		default:
			break;
		}

		return cellValue;
	}

	private static long getAccountNumberFromDetail(String detail) {
		if (detail.startsWith("TKThe :")) {
			int indexFrom = detail.indexOf(':');
			int indexTo = detail.indexOf(',');
			return Long.parseLong(detail.substring(indexFrom + 1, indexTo).trim());
		} else if (detail.startsWith("Tfr Ac: ")) {
			int indexFrom = detail.indexOf(':');
			int indexTo = detail.indexOf(" ", detail.indexOf(':') + 2);
			return Long.parseLong(detail.substring(indexFrom + 1, indexTo).trim());
		}
		return -1;
	}
}
