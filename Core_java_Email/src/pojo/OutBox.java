package pojo;

public class OutBox {
	
	private String to;
	private String message;
	
	public OutBox(String to, String message) {
		super();
		this.to = to;
		this.message = message;
	}



	@Override
	public String toString() {
		return "OutBox [to=" + to + ", message=" + message + "]";
	}
	
	
}
