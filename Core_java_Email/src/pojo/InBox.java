package pojo;

public class InBox {
	
	private String from;
	private String message;
	
	public InBox(String from, String message) {
		super();
		this.from = from;
		this.message = message;
	}



	@Override
	public String toString() {
		return "InBox [from=" + from + ", message=" + message + "]";
	}
	
	
}
