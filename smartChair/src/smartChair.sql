INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('1@1.1', '1', 'user_name 01', 'user_nick 01', sysdate, 'Y');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('2@2.2', '2', 'user_name 02', 'user_nick 02', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('3@3.3', '3', 'user_name 03', 'user_nick 03', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('4@4.4', '4', 'user_name 04', 'user_nick 04', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('5@5.5', '5', 'user_name 05', 'user_nick 05', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('6@6.6', '6', 'user_name 06', 'user_nick 06', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('7@7.7', '7', 'user_name 07', 'user_nick 07', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('8@8.8', '8', 'user_name 08', 'user_nick 08', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('9@9.9', '9', 'user_name 09', 'user_nick 09', sysdate, 'N');
INSERT INTO tb_user (user_id, user_pw, user_name, user_nick, user_joindate, admin_yesno) VALUES ('10@10.10', '10', 'user_name 10', 'user_nick 10', sysdate, 'N');

update tb_user set user_pw = '1' where user_name = 'user_name 01';
update tb_user set user_pw = '2' where user_name = 'user_name 02';
update tb_user set user_pw = '3' where user_name = 'user_name 03';
update tb_user set user_pw = '4' where user_name = 'user_name 04';
update tb_user set user_pw = '5' where user_name = 'user_name 05';
update tb_user set user_pw = '6' where user_name = 'user_name 06';
update tb_user set user_pw = '7' where user_name = 'user_name 07';
update tb_user set user_pw = '8' where user_name = 'user_name 08';
update tb_user set user_pw = '9' where user_name = 'user_name 09';
update tb_user set user_pw = '10' where user_name = 'user_name 10';

select * from tb_user;
