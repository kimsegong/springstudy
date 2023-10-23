-- 시퀀스
DROP SEQUENCE USER_SEQ;

CREATE SEQUENCE USER_SEQ NOCACHE;


-- 테이블
DROP TABLE INACTIVE_USER_T;
DROP TABLE LEAVE_USER_T;
DROP TABLE ACCESS_T;
DROP TABLE USER_T;

-- 가입한 사용자
CREATE TABLE USER_T (
    USER_NO        NUMBER              NOT NULL,        -- PK
    EMAIL          VARCHAR2(100 BYTE)  NOT NULL UNIQUE, -- 이메일을 아이디로 사용
    PW             VARCHAR2(64 BYTE)   NOT NULL,        -- SHA-256 암호화 방식 사용
    NAME           VARCHAR2(50 BYTE),                   -- 이름
    GENDER         VARCHAR2(2 BYTE),                    -- M, F, NO
    MOBILE         VARCHAR2(15 BYTE),                   -- 하이픈 제거 후 저장
    POSTCODE       VARCHAR2(5 BYTE),                    -- 우편번호
    ROAD_ADDRESS   VARCHAR2(100 BYTE),                  -- 도로명주소
    JIBUN_ADDRESS  VARCHAR2(100 BYTE),                  -- 지번주소
    DETAIL_ADDRESS VARCHAR2(100 BYTE),                  -- 상세주소
    AGREE          NUMBER              NOT NULL,        -- 서비스 동의 여부(0:필수, 1:이벤트)
    PW_MODIFIED_AT DATE,                                -- 비밀번호 수정일
    JOINED_AT      DATE,                                -- 가입일
    CONSTRAINT PK_USER PRIMARY KEY(USER_NO)
);

-- 접속 기록
CREATE TABLE ACCESS_T (
    EMAIL    VARCHAR2(100 BYTE) NOT NULL,  -- 접속한 사용자
    LOGIN_AT DATE,                         -- 로그인 일시
    CONSTRAINT FK_USER_ACCESS FOREIGN KEY(EMAIL) REFERENCES USER_T(EMAIL) ON DELETE CASCADE
);

-- 탈퇴한 사용자
CREATE TABLE LEAVE_USER_T (
    EMAIL     VARCHAR2(50 BYTE) NOT NULL UNIQUE,  -- 탈퇴한 사용자 이메일
    JOINED_AT DATE,                               -- 가입일
    LEAVED_AT DATE                                -- 탈퇴일
);

-- 휴면 사용자 (1년 이상 접속 기록이 없으면 휴면 처리)
CREATE TABLE INACTIVE_USER_T (
    USER_NO        NUMBER              NOT NULL,        -- PK
    EMAIL          VARCHAR2(100 BYTE)  NOT NULL UNIQUE, -- 이메일을 아이디로 사용
    PW             VARCHAR2(64 BYTE)   NOT NULL,        -- SHA-256 암호화 방식 사용
    NAME           VARCHAR2(50 BYTE),                   -- 이름
    GENDER         VARCHAR2(2 BYTE),                    -- M, F, NO
    MOBILE         VARCHAR2(15 BYTE),                   -- 하이픈 제거 후 저장
    POSTCODE       VARCHAR2(5 BYTE),                    -- 우편번호
    ROAD_ADDRESS   VARCHAR2(100 BYTE),                  -- 도로명주소
    JIBUN_ADDRESS  VARCHAR2(100 BYTE),                  -- 지번주소
    DETAIL_ADDRESS VARCHAR2(100 BYTE),                  -- 상세주소
    AGREE          NUMBER              NOT NULL,        -- 서비스 동의 여부(0:필수, 1:이벤트)
    PW_MODIFIED_AT DATE,                                -- 비밀번호 수정일
    JOINED_AT      DATE,                                -- 가입일
    INACTIVED_AT   DATE,                                -- 휴면처리일
    CONSTRAINT PK_INACTIVE_USER PRIMARY KEY(USER_NO)
);


-- 테스트용 INSERT
INSERT INTO USER_T VALUES(USER_SEQ.NEXTVAL, 'user1@naver.com', STANDARD_HASH('1111', 'SHA256'), '사용자1', 'M', '01011111111', '11111', '디지털로', '가산동', '101동 101호', 0, TO_DATE('20231001', 'YYYYMMDD'), TO_DATE('20220101', 'YYYYMMDD'));
INSERT INTO USER_T VALUES(USER_SEQ.NEXTVAL, 'user2@naver.com', STANDARD_HASH('2222', 'SHA256'), '사용자2', 'F', '01022222222', '22222', '디지털로', '가산동', '101동 101호', 0, TO_DATE('20230801', 'YYYYMMDD'), TO_DATE('20220101', 'YYYYMMDD'));
INSERT INTO USER_T VALUES(USER_SEQ.NEXTVAL, 'user3@naver.com', STANDARD_HASH('3333', 'SHA256'), '사용자3', 'NO', '01033333333', '33333', '디지털로', '가산동', '101동 101호', 0, TO_DATE('20230601', 'YYYYMMDD'), TO_DATE('20220101', 'YYYYMMDD'));

INSERT INTO ACCESS_T VALUES('user1@naver.com', TO_DATE('20231018', 'YYYYMMDD'));  -- 정상 회원 (user1)
INSERT INTO ACCESS_T VALUES('user2@naver.com', TO_DATE('20220201', 'YYYYMMDD'));  -- 휴면 회원 (user2)
                                                                                  -- 휴면 회원 (user3)
COMMIT;


-- 쿼리 테스트

-- 1. 로그인 할 때(이메일, 비밀번호 입력)
-- 1) 정상 회원
SELECT USER_NO, EMAIL, PW, NAME, GENDER, MOBILE, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, AGREE, PW_MODIFIED_AT, JOINED_AT
  FROM USER_T
 WHERE EMAIL = 'user1@naver.com'
   AND PW = '0FFE1ABD1A08215353C233D6E009613E95EEC4253832A761AF28FF37AC5A150C';

INSERT INTO ACCESS_T VALUES('user1@naver.com', SYSDATE);
COMMIT;

-- 2) 휴면 회원
SELECT USER_NO, EMAIL, PW, NAME, GENDER, MOBILE, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, AGREE, PW_MODIFIED_AT, JOINED_AT
  FROM INACTIVE_USER_T
 WHERE EMAIL = 'user1@naver.com'
   AND PW = '0FFE1ABD1A08215353C233D6E009613E95EEC4253832A761AF28FF37AC5A150C';
-- 이후 휴면 복원으로 이동

-- 2. 이메일 중복 체크
SELECT EMAIL
  FROM USER_T
 WHERE EMAIL = 'user4@naver.com';

SELECT EMAIL
  FROM LEAVE_USER_T
 WHERE EMAIL = 'user4@naver.com';

SELECT EMAIL
  FROM INACTIVE_USER_T
 WHERE EMAIL = 'user4@naver.com';

-- 3. 휴면 처리 할 때 (12개월 이상 로그인 이력이 없다. 로그인 이력이 전혀 없는 사용자 중에서 가입일이 12개월 이상 지났다.)
INSERT INTO INACTIVE_USER_T
(
SELECT USER_NO, U.EMAIL, PW, NAME, GENDER, MOBILE, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, AGREE, PW_MODIFIED_AT, JOINED_AT, SYSDATE
  FROM USER_T U LEFT OUTER JOIN ACCESS_T A
    ON U.EMAIL = A.EMAIL
 WHERE MONTHS_BETWEEN(SYSDATE, LOGIN_AT) >= 12
    OR (LOGIN_AT IS NULL AND MONTHS_BETWEEN(SYSDATE, JOINED_AT) >= 12)
);

DELETE
  FROM USER_T
 WHERE EMAIL IN(SELECT U.EMAIL
                  FROM USER_T U LEFT OUTER JOIN ACCESS_T A
                    ON U.EMAIL = A.EMAIL
                 WHERE MONTHS_BETWEEN(SYSDATE, LOGIN_AT) >= 12
                    OR (LOGIN_AT IS NULL AND MONTHS_BETWEEN(SYSDATE, JOINED_AT) >= 12));
COMMIT;

-- 4. 휴면 복원 할 때
INSERT INTO USER_T
(
SELECT USER_NO, EMAIL, PW, NAME, GENDER, MOBILE, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, AGREE, PW_MODIFIED_AT, JOINED_AT
  FROM INACTIVE_USER_T
 WHERE EMAIL = 'user2@naver.com'
);

DELETE
  FROM INACTIVE_USER_T
 WHERE EMAIL = 'user2@naver.com';

SELECT USER_NO, EMAIL, PW, NAME, GENDER, MOBILE, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, AGREE, PW_MODIFIED_AT, JOINED_AT
  FROM USER_T
 WHERE EMAIL = 'user2@naver.com';

INSERT INTO ACCESS_T VALUES('user2@naver.com', SYSDATE);
COMMIT;

-- 5. 탈퇴 할 때
INSERT INTO LEAVE_USER_T VALUES('user1@naver.com', TO_DATE('20220101', 'YYYYMMDD'), SYSDATE);
DELETE FROM USER_T WHERE USER_NO = 1;
COMMIT;

