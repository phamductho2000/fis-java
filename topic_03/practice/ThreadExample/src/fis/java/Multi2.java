package fis.java;

public class Multi2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread2 is running...");
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println("thread2 is exiting");
	}

	public static void main(String args[]) {
        Multi2 m1 = new Multi2();
        Thread t1 = new Thread(m1);
        System.out.println(t1.getPriority());
        t1.start();
    }
}
