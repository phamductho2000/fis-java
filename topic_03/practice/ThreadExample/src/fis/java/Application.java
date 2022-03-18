package fis.java;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multi t1= new Multi();
		t1.start();
		Multi2 t2 = new Multi2();
		Thread tr2 = new Thread(t2);
		tr2.start();
		try {
			tr2.join();
			t1.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
