package vo;

public class memberVO {
	String email;
	String pw;
	String name;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public memberVO(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	
	

}
