package vo;

import java.util.Date;

// ����� ���̺� 
public class tb_userVO {

    // ����� ���̵� 
    private String user_id;

    // ����� ��й�ȣ 
    private String user_pw;

    // ����� �̸� 
    private String user_name;

    // ����� �г��� 
    private String user_nick;

    // ����� �������� 
    private Date user_joindate;

    // ������ ���� 
    private String admin_yesno;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public Date getUser_joindate() {
		return user_joindate;
	}

	public void setUser_joindate(Date user_joindate) {
		this.user_joindate = user_joindate;
	}

	public String getAdmin_yesno() {
		return admin_yesno;
	}

	public void setAdmin_yesno(String admin_yesno) {
		this.admin_yesno = admin_yesno;
	}

	public tb_userVO(String user_id, String user_pw, String user_name, String user_nick, Date user_joindate) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_nick = user_nick;
		this.user_joindate = user_joindate;
	}

	public tb_userVO(String user_id, String user_name, String user_nick) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_nick = user_nick;
	}

    
	
}