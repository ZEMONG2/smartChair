select * from tb_user;
select * from tb_community;

DROP TABLE TB_USER CASCADE CONSTRAINTS;
DROP TABLE TB_COMMUNITY CASCADE CONSTRAINTS;
DROP TABLE TB_POSE CASCADE CONSTRAINTS;
DROP TABLE TB_CONTROL CASCADE CONSTRAINTS;
DROP TABLE TB_COMMENT CASCADE CONSTRAINTS;

DROP SEQUENCE TB_COMMENT_SEQ ;
DROP SEQUENCE TB_COMMUNITY_SEQ ;
DROP SEQUENCE TB_CONTROL_SEQ ;
DROP SEQUENCE TB_POSE_SEQ ;
-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- tb_user Table Create SQL
CREATE TABLE tb_user
(
    user_id          VARCHAR2(50)    NOT NULL, 
    user_pw          VARCHAR2(20)    NOT NULL, 
    user_name        VARCHAR2(20)    NOT NULL, 
    user_nick        VARCHAR2(20)    NOT NULL, 
user_tel         VARCHAR2(20)    NOT NULL, 
    user_gender      VARCHAR2(20)    NOT NULL, 
    user_birthday    DATE            NOT NULL, 
    user_joindate    DATE            DEFAULT SYSDATE NOT NULL, 
    admin_yesno      CHAR(1)         DEFAULT 'N' NOT NULL, 
    
     PRIMARY KEY (user_id)
)
;

COMMENT ON TABLE tb_user IS '사용자 테이블';

COMMENT ON COLUMN tb_user.user_id IS '사용자 아이디';

COMMENT ON COLUMN tb_user.user_pw IS '사용자 비밀번호';

COMMENT ON COLUMN tb_user.user_name IS '사용자 이름';

COMMENT ON COLUMN tb_user.user_nick IS '사용자 닉네임';

COMMENT ON COLUMN tb_user.user_joindate IS '사용자 가입일자';

COMMENT ON COLUMN tb_user.admin_yesno IS '관리자 여부';

COMMENT ON COLUMN tb_user.user_tel IS '핸드폰 번호';

COMMENT ON COLUMN tb_user.user_gender IS '성별';

COMMENT ON COLUMN tb_user.user_birthday IS '생년월일';

CREATE INDEX IX_tb_user_1
    ON tb_user(user_name);

CREATE UNIQUE INDEX UQ_tb_user_1
    ON tb_user(user_nick);


-- tb_community Table Create SQL
CREATE TABLE tb_community
(
    article_seq        NUMBER(12, 0)     NOT NULL, 
    article_title      VARCHAR2(200)     NOT NULL, 
    article_content    VARCHAR2(4000)    NOT NULL, 
    article_file       VARCHAR2(200)     NOT NULL, 
    article_date       DATE              DEFAULT SYSDATE NOT NULL, 
    user_id            VARCHAR2(50)      NOT NULL, 
    article_cnt        NUMBER(12, 0)     DEFAULT 0 NOT NULL, 
    article_likes      NUMBER(12, 0)     DEFAULT 0 NOT NULL, 
    user_ip            VARCHAR2(20)      NOT NULL, 
     PRIMARY KEY (article_seq)
);

CREATE SEQUENCE tb_community_SEQ
START WITH 1
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER tb_community_AI_TRG
BEFORE INSERT ON tb_community 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_community_SEQ.NEXTVAL
    INTO :NEW.article_seq
    FROM DUAL
END
;

--DROP TRIGGER tb_community_AI_TRG;
;

--DROP SEQUENCE tb_community_SEQ;
;

COMMENT ON TABLE tb_community IS '공유 커뮤니티 테이블'
;

COMMENT ON COLUMN tb_community.article_seq IS '글 순번'
;

COMMENT ON COLUMN tb_community.article_title IS '글 제목'
;

COMMENT ON COLUMN tb_community.article_content IS '글 내용'
;

COMMENT ON COLUMN tb_community.article_file IS '글 첨부파일'
;

COMMENT ON COLUMN tb_community.article_date IS '글 작성일자'
;

COMMENT ON COLUMN tb_community.user_id IS '글 작성자'
;

COMMENT ON COLUMN tb_community.article_cnt IS '글 조회수'
;

COMMENT ON COLUMN tb_community.article_likes IS '글 좋아요수'
;

COMMENT ON COLUMN tb_community.user_ip IS '작성자 아이피'
;

ALTER TABLE tb_community
    ADD CONSTRAINT FK_tb_community_user_id_tb_use FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
;


-- tb_comment Table Create SQL
CREATE TABLE tb_comment
(
    comment_seq        NUMBER(12, 0)     NOT NULL, 
    article_seq        NUMBER(12, 0)     NOT NULL, 
    comment_content    VARCHAR2(4000)    NOT NULL, 
    comment_date       DATE              DEFAULT SYSDATE NOT NULL, 
    user_id            VARCHAR2(50)      NOT NULL, 
     PRIMARY KEY (comment_seq)
)
;

CREATE SEQUENCE tb_comment_SEQ
START WITH 1
INCREMENT BY 1;
;

CREATE OR REPLACE TRIGGER tb_comment_AI_TRG
BEFORE INSERT ON tb_comment 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_comment_SEQ.NEXTVAL
    INTO :NEW.comment_seq
    FROM DUAL
END


--DROP TRIGGER tb_comment_AI_TRG;


--DROP SEQUENCE tb_comment_SEQ;


COMMENT ON TABLE tb_comment IS '댓글 테이블'
;

COMMENT ON COLUMN tb_comment.comment_seq IS '댓글 순번'
;

COMMENT ON COLUMN tb_comment.article_seq IS '원글 순번'
;

COMMENT ON COLUMN tb_comment.comment_content IS '댓글 내용'
;

COMMENT ON COLUMN tb_comment.comment_date IS '댓글 작성일자'
;

COMMENT ON COLUMN tb_comment.user_id IS '댓글 작성자'
;

ALTER TABLE tb_comment
    ADD CONSTRAINT FK_tb_comment_article_seq_tb_c FOREIGN KEY (article_seq)
        REFERENCES tb_community (article_seq)
;

ALTER TABLE tb_comment
    ADD CONSTRAINT FK_tb_comment_user_id_tb_user_ FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
;


-- tb_control Table Create SQL
CREATE TABLE tb_control
(
    control_seq         NUMBER(12, 0)    NOT NULL, 
    user_height         NUMBER(12, 1)    NOT NULL, 
    user_prev_height    NUMBER(12, 1)    NOT NULL, 
    pose_status         VARCHAR2(50)     NOT NULL, 
    user_id             VARCHAR2(50)     NOT NULL, 
    reg_date            DATE             DEFAULT SYSDATE NOT NULL, 
     PRIMARY KEY (control_seq)
)
;

CREATE SEQUENCE tb_control_SEQ
START WITH 1
INCREMENT BY 1;
;

CREATE OR REPLACE TRIGGER tb_control_AI_TRG
BEFORE INSERT ON tb_control 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_control_SEQ.NEXTVAL
    INTO :NEW.control_seq
    FROM DUAL
END
;

--DROP TRIGGER tb_control_AI_TRG;
;

--DROP SEQUENCE tb_control_SEQ;
;

COMMENT ON TABLE tb_control IS '책상 제어 테이블'
;

COMMENT ON COLUMN tb_control.control_seq IS '제어 순번'
;

COMMENT ON COLUMN tb_control.user_height IS '사용자 설정 높이'
;

COMMENT ON COLUMN tb_control.user_prev_height IS '사용자 이전 높이'
;

COMMENT ON COLUMN tb_control.pose_status IS '자세 상태'
;

COMMENT ON COLUMN tb_control.user_id IS '사용자 아이디'
;

COMMENT ON COLUMN tb_control.reg_date IS '등록 시간'
;

ALTER TABLE tb_control
    ADD CONSTRAINT FK_tb_control_user_id_tb_user_ FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
;


-- tb_pose Table Create SQL
CREATE TABLE tb_pose
(
    pose_seq         NUMBER(12, 0)    NOT NULL, 
    pose_type        VARCHAR2(20)     NOT NULL, 
    pose_start_dt    DATE             DEFAULT SYSDATE NOT NULL, 
    pose_end_dt      DATE             DEFAULT SYSDATE NOT NULL, 
    user_id          VARCHAR2(50)     NOT NULL, 
     PRIMARY KEY (pose_seq)
)
;

CREATE SEQUENCE tb_pose_SEQ
START WITH 1
INCREMENT BY 1
;

CREATE OR REPLACE TRIGGER tb_pose_AI_TRG
BEFORE INSERT ON tb_pose 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_pose_SEQ.NEXTVAL
    INTO :NEW.pose_seq
    FROM DUAL
END
;

--DROP TRIGGER tb_pose_AI_TRG;
;

--DROP SEQUENCE tb_pose_SEQ;
;

COMMENT ON TABLE tb_pose IS '자세 테이블'
;

COMMENT ON COLUMN tb_pose.pose_seq IS '자세 순번'
;

COMMENT ON COLUMN tb_pose.pose_type IS '자세 유형'
;

COMMENT ON COLUMN tb_pose.pose_start_dt IS '자세 시작시간'
;

COMMENT ON COLUMN tb_pose.pose_end_dt IS '자세 종료시간'
;

COMMENT ON COLUMN tb_pose.user_id IS '등록자 아이디'
;

ALTER TABLE tb_pose
    ADD CONSTRAINT FK_tb_pose_user_id_tb_user_use FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
;


