package fis.java;


import java.util.Date;
import java.util.List;

public class Summary {
	
	private final int PRICE_BICYCLE_TICKET = 500;
	private final int PRICE_MOTORBIKE_TICKET = 1000;
	private final int LABOR_COSTS = 100;
	private final int TAX_PERCENT = 10;
	
	private List<Ticket> tickets;
	

	public Summary(List<Ticket> tickets) {
		super();
		this.tickets = tickets;
	}

	//Dem tong so ve xe
	public int countTotalTicket() {
		return tickets.size();
	}
	
	//Tinh tong gia gui xe
	public int totalParkingFee() {
		int total = 0;
		for (Ticket ticket : tickets) {
			if(ticket instanceof BicycleTicket) {
				total += PRICE_BICYCLE_TICKET;
			} else {
				total += PRICE_MOTORBIKE_TICKET;
			}
		}
		return total;
	}
	
	//Tinh tong tien thue
	public double totaTaxAmount() {
		return totalParkingFee() * TAX_PERCENT / 100.0;
	}

	//Tinh loi nhuan
	public double profit() {
		return totalParkingFee() - (totaTaxAmount() + LABOR_COSTS * countTotalTicket());
	}
	
	
}
