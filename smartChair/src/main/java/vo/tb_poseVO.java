package vo;

import java.util.Date;

public class tb_poseVO {
	
	 // �ڼ� ���� 
    private Double pose_seq;

    // �ڼ� ���� 
    private String pose_type;

    // �ڼ� ���۽ð� 
    private Date pose_start_dt;

    // �ڼ� ����ð� 
    private Date pose_end_dt;

    // ��� �ð� 
    private Date reg_date;

    // ����� ���̵� 
    private String user_id;

	public Double getPose_seq() {
		return pose_seq;
	}

	public void setPose_seq(Double pose_seq) {
		this.pose_seq = pose_seq;
	}

	public String getPose_type() {
		return pose_type;
	}

	public void setPose_type(String pose_type) {
		this.pose_type = pose_type;
	}

	public Date getPose_start_dt() {
		return pose_start_dt;
	}

	public void setPose_start_dt(Date pose_start_dt) {
		this.pose_start_dt = pose_start_dt;
	}

	public Date getPose_end_dt() {
		return pose_end_dt;
	}

	public void setPose_end_dt(Date pose_end_dt) {
		this.pose_end_dt = pose_end_dt;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
    
    
    
}
