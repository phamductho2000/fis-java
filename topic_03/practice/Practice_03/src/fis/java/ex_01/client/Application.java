package fis.java.ex_01.client;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatClient cc = new ChatClient("localhost", 8004);
//		WriteThread wt = new WriteThread(null, null)
		cc.execute();
	}

}