INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('1@1.1', '1', '1', '1', '111-1111-1111', 'men', sysdate, 'Y');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('2@2.2', '2', '2', '2', '222-2222-2222', 'men', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('3@3.3', '3', '3', '3', '333-3333-3333', 'men', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('4@4.4', '4', '4', '4', '444-4444-4444', 'women', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('5@5.5', '5', '5', '5', '555-5555-5555', 'men', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('6@6.6', '6', '6', '6', '666-6666-6666', 'women', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('7@7.7', '7', '7', '7', '777-7777-7777', 'men', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('8@8.8', '8', '8', '8', '888-8888-8888', 'women', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_joindate, admin_yesno) VALUES ('9@9.9', '9', '9', '9', '999-9999-9999', 'women', sysdate, 'N');

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



