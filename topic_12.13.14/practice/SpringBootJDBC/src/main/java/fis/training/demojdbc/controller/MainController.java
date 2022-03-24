package fis.training.demojdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fis.training.demojdbc.dao.BankAccountDAO;
import fis.training.demojdbc.dao.BankAccountDaoImpl;
import fis.training.demojdbc.exception.BankTransactionException;
import fis.training.demojdbc.form.SendMoneyForm;
import fis.training.demojdbc.model.BankAccountInfo;

@Controller
public class MainController {

	@Autowired
	private BankAccountDaoImpl bankAccountDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showBankAccounts(Model model) {
		List<BankAccountInfo> list = bankAccountDAO.findAll();

		model.addAttribute("accountInfos", list);

		return "accountsPage";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String showInsertBankAccounts(Model model) {

		model.addAttribute("bankAccount", new BankAccountInfo(3L, "Tho", 2000D));

		return "insertAccountsPage";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertAccount(Model model, BankAccountInfo bankAccountInfo) {
		
		try {
			bankAccountDAO.save(bankAccountInfo);
		} catch (BankTransactionException e) {
			model.addAttribute("errorMessage", "Error: " + e.getMessage());
			model.addAttribute("bankAccount", new BankAccountInfo(3L, "Tho", 2000D));
			return "/insertAccountsPage";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String showUpdateBankAccounts(@RequestParam(name = "id") Long id, Model model) {

		model.addAttribute("bankAccount",bankAccountDAO.findById(id));

		return "updateAccountsPage";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateAccount(Model model, BankAccountInfo bankAccountInfo) {
		
		try {
			bankAccountDAO.save(bankAccountInfo);
		} catch (BankTransactionException e) {
			model.addAttribute("errorMessage", "Error: " + e.getMessage());
			model.addAttribute("bankAccount", new BankAccountInfo(3L, "Tho", 2000D));
			return "/insertAccountsPage";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAccount(@RequestParam(name = "id") Long id, Model model) {

		try {
			bankAccountDAO.deleteById(id);
		} catch (BankTransactionException e) {
			model.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "/accountsPage";
		}

		return "redirect:/";
	}
	
	@RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
	public String viewSendMoneyPage(Model model) {

		SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);

		model.addAttribute("sendMoneyForm", form);

		return "sendMoneyPage";
	}

	@RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
	public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {

		System.out.println("Send Money::" + sendMoneyForm.getAmount());

		try {
			bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), //
					sendMoneyForm.getToAccountId(), //
					sendMoneyForm.getAmount());
		} catch (BankTransactionException e) {
			model.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "/sendMoneyPage";
		}
		return "redirect:/";
	}
}
