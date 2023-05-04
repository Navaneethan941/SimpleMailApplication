package pojo;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private String email;
	private String password; 
	private List<InBox> inBox = new ArrayList<>();
	private List<OutBox> outBox = new ArrayList<>();
	public Account(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public List<InBox> getInBox() {
		return inBox;
	}

	public List<OutBox> getOutBox() {
		return outBox;
	}

	public void setInBox(InBox inBox) {
		this.inBox.add(inBox);
	}

	public void setOutBox(OutBox outBox) {
		this.outBox.add(outBox);
	}

	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", inBox=" + inBox + ", outBox=" + outBox + "]";
	}

//	@Override
//	public String toString() {
//		return "Account [email=" + email + "]";
//	}
	
	
	
	
	
	
	
	
}
