
public class Main {

	public static void main(String[] args) {
		System.out.println(getStr("Hello", new StringProcessor() {
			
			@Override
			public String process(String input) {
				// TODO Auto-generated method stub
				return null;
			}
		}));
	}

	public static String getStr(String input, StringProcessor processor){
	    return processor.process(input);
	}
}
