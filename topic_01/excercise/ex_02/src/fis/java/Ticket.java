package fis.java;

public abstract class Ticket {
	
	private int ticketNumber;
	

	public Ticket(int ticketNumber) {
		super();
		this.ticketNumber = ticketNumber;
	}

	public int getTicketCode() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	

}
