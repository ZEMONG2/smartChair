INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('1@1.1', '1', '1', '1', '111-1111-1111', 'men', '1992/01/20', sysdate, 'Y');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('2@2.2', '2', '2', '2', '222-2222-2222', 'men', '1993/02/12', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('3@3.3', '3', '3', '3', '333-3333-3333', 'men', '1992/08/23', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('4@4.4', '4', '4', '4', '444-4444-4444', 'women', '1999/12/10', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('5@5.5', '5', '5', '5', '555-5555-5555', 'men', '2003/09/10', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('6@6.6', '6', '6', '6', '666-6666-6666', 'women', '1989/03/13', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('7@7.7', '7', '7', '7', '777-7777-7777', 'men', '1992/01/16', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('8@8.8', '8', '8', '8', '888-8888-8888', 'women', '1998/04/06', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno) VALUES ('9@9.9', '9', '9', '9', '999-9999-9999', 'women', '1993/07/05', sysdate, 'N');

select * from tb_user;

alter table tb_user modify user_gender varchar2(20);

DROP TABLE TB_USER CASCADE CONSTRAINTS;
DROP TABLE TB_COMMUNITY CASCADE CONSTRAINTS;
DROP TABLE TB_POSE CASCADE CONSTRAINTS;
DROP TABLE TB_CONTROL CASCADE CONSTRAINTS;
DROP TABLE TB_COMMENT CASCADE CONSTRAINTS;

DROP SEQUENCE TB_COMMENT_SEQ ;
DROP SEQUENCE TB_COMMUNITY_SEQ ;
DROP SEQUENCE TB_CONTROL_SEQ ;
DROP SEQUENCE TB_POSE_SEQ ;

INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 01', 'article_content 01', 'article_file 01', sysdate, '4@4.4', 01, 01);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 02', 'article_content 02', 'article_file 02', sysdate, '4@4.4', 02, 02);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 03', 'article_content 03', 'article_file 03', sysdate, '4@4.4', 03, 03);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 04', 'article_content 04', 'article_file 04', sysdate, '4@4.4', 04, 04);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 05', 'article_content 05', 'article_file 05', sysdate, '4@4.4', 05, 05);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 06', 'article_content 06', 'article_file 06', sysdate, '4@4.4', 06, 06);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 07', 'article_content 07', 'article_file 07', sysdate, '4@4.4', 07, 07);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 08', 'article_content 08', 'article_file 08', sysdate, '4@4.4', 08, 08);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 09', 'article_content 09', 'article_file 09', sysdate, '4@4.4', 09, 09);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 10', 'article_content 10', 'article_file 10', sysdate, '4@4.4', 10, 10);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 11', 'article_content 11', 'article_file 11', sysdate, '4@4.4', 11, 11);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 12', 'article_content 12', 'article_file 12', sysdate, '4@4.4', 12, 12);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 13', 'article_content 13', 'article_file 13', sysdate, '4@4.4', 13, 13);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 14', 'article_content 14', 'article_file 14', sysdate, '4@4.4', 14, 14);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 15', 'article_content 15', 'article_file 15', sysdate, '4@4.4', 15, 15);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 16', 'article_content 16', 'article_file 16', sysdate, '4@4.4', 16, 16);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 17', 'article_content 17', 'article_file 17', sysdate, '4@4.4', 17, 17);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 18', 'article_content 18', 'article_file 18', sysdate, '4@4.4', 18, 18);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 19', 'article_content 19', 'article_file 19', sysdate, '4@4.4', 19, 19);
INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id, article_cnt, article_likes) VALUES ('article_title 20', 'article_content 20', 'article_file 20', sysdate, '4@4.4', 20, 20);


