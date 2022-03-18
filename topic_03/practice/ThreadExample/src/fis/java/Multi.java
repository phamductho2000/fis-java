package fis.java;

import java.util.Iterator;

public class Multi extends Thread {
	public void run() {
		System.out.println("thread1 is running...");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		System.out.println("thread1 is exiting");
	}

	public static void main(String args[]) {
		Multi t1 = new Multi();
		t1.start();
	}
}
