package vo;

import java.util.Date;

public class tb_commentVO {

    // 댓글 순번 
    private int comment_seq;

    // 원글 순번 
    private int article_seq;

    // 댓글 내용 
    private String comment_content;

    // 댓글 작성일자 
    private Date comment_date;

    // 댓글 작성자 
    private String user_id;

	public int getComment_seq() {
		return comment_seq;
	}

	public void setComment_seq(int comment_seq) {
		this.comment_seq = comment_seq;
	}

	public int getArticle_seq() {
		return article_seq;
	}

	public void setArticle_seq(int article_seq) {
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

	public tb_commentVO(int comment_seq, int article_seq, String comment_content, Date comment_date, String user_id) {
		super();
		this.comment_seq = comment_seq;
		this.article_seq = article_seq;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
		this.user_id = user_id;
	}
    
    

}
