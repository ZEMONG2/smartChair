package vo;

import java.util.Date;

public class tb_poseVO {
   
    // 자세 순번 
    private int pose_seq;

    // 자세 유형 
    private String pose_type;

    // 등록 일자
    private String reg_date;

    // 등록자 제품번호 
 private String product_num;
 
 private String pose_date;

 private int chartMonth;
 
//포즈별 횟수
private int count;



public int getChartMonth() {
	return chartMonth;
}

public void setChartMonth(int chartMonth) {
	this.chartMonth = chartMonth;
}

public String getPose_date() {
	return pose_date;
}

public void setPose_date(String pose_date) {
	this.pose_date = pose_date;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

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


public tb_poseVO(int pose_seq, String pose_type, String reg_date, String product_num) {
   super();
   this.pose_seq = pose_seq;
   this.pose_type = pose_type;
   this.reg_date = reg_date;
   this.product_num = product_num;
}

public tb_poseVO(String pose_type, int count) {
	super();
	this.pose_type = pose_type;
	this.count = count;
}

public tb_poseVO(int count, String pose_date) {
	super();
	this.count = count;
	this.pose_date = pose_date;
}

public tb_poseVO(int count, int chartMonth) {
	super();
	this.count = count;
	this.chartMonth = chartMonth;
}


    
}