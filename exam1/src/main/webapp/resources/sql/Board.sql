-- 테이블
DROP TABLE MVC_BOARD_T;
CREATE TABLE MVC_BOARD_T (
    NO       NUMBER              NOT NULL,  -- 게시글번호
    AUTHOR   VARCHAR2(50 BYTE),             -- 작성자
    TITLE    VARCHAR2(2000 BYTE) NOT NULL,  -- 제목
    CONTENT  CLOB,                          -- 내용
    HIT      NUMBER,                        -- 조회수
    IP       VARCHAR2(20 BYTE),             -- 작성자IP
    POSTDATE DATE,                          -- 작성일
    CONSTRAINT PK_MVC_BOARD PRIMARY KEY(NO) -- 기본키
);

-- 시퀀스
DROP SEQUENCE MVC_BOARD_SEQ;
CREATE SEQUENCE MVC_BOARD_SEQ NOCACHE;

-- 데이터
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '스미스', '궁금합니다', '등업 기준이 어떻게 되죠?', 5, '127.0.0.1', SYSDATE);
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '데이빗', '가입 인사 드려요', '잘 부탁드립니다', 15, '127.0.0.1', SYSDATE);
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '제시카', '나눔합니다', '빨리 오는 분 선착순', 3, '127.0.0.1', SYSDATE);
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '에밀리', '책 드려요', '책 드림합니다', 10, '127.0.0.1', SYSDATE);
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '엠마', '출석입니다', '출석!', 2, '127.0.0.1', SYSDATE);
COMMIT;