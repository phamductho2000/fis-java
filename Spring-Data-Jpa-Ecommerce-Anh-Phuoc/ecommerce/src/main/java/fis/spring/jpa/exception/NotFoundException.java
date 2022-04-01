package fis.spring.jpa.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 4884234633358383697L;

	public NotFoundException(String message) {
		super(message);
	}

}
