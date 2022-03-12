package vo;

import java.util.Date;

public class tb_poseVO {
   
    // 자세 순번 
    private int pose_seq;

    // 자세 유형 
    private String pose_type;

    // 자세 유지시간 
    private long pose_time;

    // 등록 일자
    private String reg_date;

    // 등록자 제품번호 
 private String product_num;

public int getPose_seq() {
   return pose_seq;
}

public void setPose_seq(int pose_seq) {
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

public String getReg_date() {
   return reg_date;
}

public void setReg_date(String reg_date) {
   this.reg_date = reg_date;
}

public String getProduct_num() {
   return product_num;
}

public void setProduct_num(String product_num) {
   this.product_num = product_num;
}

public tb_poseVO(int pose_seq, String pose_type, long pose_time, String reg_date, String product_num) {
   super();
   this.pose_seq = pose_seq;
   this.pose_type = pose_type;
   this.pose_time = pose_time;
   this.reg_date = reg_date;
   this.product_num = product_num;
}

    
}