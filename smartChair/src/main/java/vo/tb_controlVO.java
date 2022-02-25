package vo;

import java.util.Date;

public class tb_controlVO {
	 
	// 제어 순번 
    private Double control_seq;

    // 사용자 설정 높이 
    private Double user_height;

    // 사용자 이전 높이 
    private Double user_prev_height;

    // 자세 상태 
    private String pose_status;

    // 사용자 아이디 
    private String user_id;

    // 등록 시간 
    private Date reg_date;

	public Double getControl_seq() {
		return control_seq;
	}

	public void setControl_seq(Double control_seq) {
		this.control_seq = control_seq;
	}

	public Double getUser_height() {
		return user_height;
	}

	public void setUser_height(Double user_height) {
		this.user_height = user_height;
	}

	public Double getUser_prev_height() {
		return user_prev_height;
	}

	public void setUser_prev_height(Double user_prev_height) {
		this.user_prev_height = user_prev_height;
	}

	public String getPose_status() {
		return pose_status;
	}

	public void setPose_status(String pose_status) {
		this.pose_status = pose_status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
    
    
    
}
