package fis.java.ex_01.sever;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatServer cs = new ChatServer(8004);
		cs.execute();
	}

}
