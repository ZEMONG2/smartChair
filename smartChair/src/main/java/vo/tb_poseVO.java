package vo;

import java.util.Date;

public class tb_poseVO {
	
	 // 자세 순번 
    private Double pose_seq;

    // 자세 유형 
    private String pose_type;

    // 자세 유지시간 
    private long pose_time;

       // 등록자 아이디 
    private String pose_system;

    private String date;

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

	public long getPose_time() {
		return pose_time;
	}

	public void setPose_time(long pose_time) {
		this.pose_time = pose_time;
	}

	public String getPose_system() {
		return pose_system;
	}

	public void setPose_system(String pose_system) {
		this.pose_system = pose_system;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
    
    
    
}
