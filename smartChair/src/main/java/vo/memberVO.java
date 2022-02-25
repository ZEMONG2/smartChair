package vo;

public class memberVO {
	String email;
	String pw;
	String name;
	String nick;
	
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public memberVO(String email, String name, String nick) {
		super();
		this.email = email;
		this.name = name;
		this.nick = nick;
	}
	
	

}
