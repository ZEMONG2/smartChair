package vo;

import java.util.Date;

public class tb_communityVO {

    // �� ���� 
    private Double article_seq;

    // �� ���� 
    private String article_title;

    // �� ���� 
    private String article_content;

    // �� ÷������ 
    private String article_file;

    // �� �ۼ����� 
    private Date article_date;

    // �� �ۼ��� 
    private String user_id;

    // �� ��ȸ�� 
    private Double article_cnt;

    // �� ���ƿ�� 
    private Double article_likes;

	public Double getArticle_seq() {
		return article_seq;
	}

	public void setArticle_seq(Double article_seq) {
		this.article_seq = article_seq;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getArticle_file() {
		return article_file;
	}

	public void setArticle_file(String article_file) {
		this.article_file = article_file;
	}

	public Date getArticle_date() {
		return article_date;
	}

	public void setArticle_date(Date article_date) {
		this.article_date = article_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Double getArticle_cnt() {
		return article_cnt;
	}

	public void setArticle_cnt(Double article_cnt) {
		this.article_cnt = article_cnt;
	}

	public Double getArticle_likes() {
		return article_likes;
	}

	public void setArticle_likes(Double article_likes) {
		this.article_likes = article_likes;
	}

    
    
}
