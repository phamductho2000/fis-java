package fis.java;


import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = new ArrayList<Ticket>();
		for(int i = 1; i <= 4; i++) {
			BicycleTicket bicycleTicket = new BicycleTicket(i);
			MotorbikeTicket motorbikeTicket = new MotorbikeTicket(i, "30P-012"+i);
			tickets.add(bicycleTicket);
			tickets.add(motorbikeTicket);
		}
		Summary summary = new Summary(tickets);
		System.out.println(summary.profit());
		
	
	}

}
