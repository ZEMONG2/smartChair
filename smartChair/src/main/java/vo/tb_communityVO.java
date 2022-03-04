package vo;

import java.util.Date;

public class tb_communityVO {

    // 글 순번 
    private int article_seq;

    // 글 제목 
    private String article_title;

    // 글 내용 
    private String article_content;

    // 글 첨부파일 
    private String article_file;

    // 글 작성일자 
    private Date article_date;

    // 글 작성자 
    private String user_id;

    // 글 조회수 
    private int article_cnt;

    // 글 좋아요수 
    private int article_likes;
    
    // 작성자 아이피
    private String user_ip;

	public int getArticle_seq() {
		return article_seq;
	}

	public void setArticle_seq(int article_seq) {
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

	public int getArticle_cnt() {
		return article_cnt;
	}

	public void setArticle_cnt(int article_cnt) {
		this.article_cnt = article_cnt;
	}

	public int getArticle_likes() {
		return article_likes;
	}

	public void setArticle_likes(int article_likes) {
		this.article_likes = article_likes;
	}
	
	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public tb_communityVO(int article_seq, String article_title, String article_content, String article_file,
			Date article_date, String user_id, int article_cnt, int article_likes, String user_ip) {
		super();
		this.article_seq = article_seq;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_file = article_file;
		this.article_date = article_date;
		this.user_id = user_id;
		this.article_cnt = article_cnt;
		this.article_likes = article_likes;
		this.user_ip = user_ip;
	}

    
    
}
