package vo;

import java.util.Date;

public class tb_commentVO {

    // ��� ���� 
    private Double comment_seq;

    // ���� ���� 
    private Double article_seq;

    // ��� ���� 
    private String comment_content;

    // ��� �ۼ����� 
    private Date comment_date;

    // ��� �ۼ��� 
    private String user_id;

	public Double getComment_seq() {
		return comment_seq;
	}

	public void setComment_seq(Double comment_seq) {
		this.comment_seq = comment_seq;
	}

	public Double getArticle_seq() {
		return article_seq;
	}

	public void setArticle_seq(Double article_seq) {
		this.article_seq = article_seq;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
    
    

}
