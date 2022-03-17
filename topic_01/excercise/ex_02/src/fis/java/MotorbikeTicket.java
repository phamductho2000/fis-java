package fis.java;


public class MotorbikeTicket extends Ticket {
	
	private String vehicleNumber;

	public MotorbikeTicket(int ticketNumber, String vehicleNumber) {
		super(ticketNumber);
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	

}
