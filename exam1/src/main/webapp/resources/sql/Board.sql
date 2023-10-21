-- ���̺�
DROP TABLE MVC_BOARD_T;
CREATE TABLE MVC_BOARD_T (
    NO       NUMBER              NOT NULL,  -- �Խñ۹�ȣ
    AUTHOR   VARCHAR2(50 BYTE),             -- �ۼ���
    TITLE    VARCHAR2(2000 BYTE) NOT NULL,  -- ����
    CONTENT  CLOB,                          -- ����
    HIT      NUMBER,                        -- ��ȸ��
    IP       VARCHAR2(20 BYTE),             -- �ۼ���IP
    POSTDATE DATE,                          -- �ۼ���
    CONSTRAINT PK_MVC_BOARD PRIMARY KEY(NO) -- �⺻Ű
);

-- ������
DROP SEQUENCE MVC_BOARD_SEQ;
CREATE SEQUENCE MVC_BOARD_SEQ NOCACHE;

-- ������
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '���̽�', '�ñ��մϴ�', '��� ������ ��� ����?', 5, '127.0.0.1', SYSDATE);
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '���̺�', '���� �λ� �����', '�� ��Ź�帳�ϴ�', 15, '127.0.0.1', SYSDATE);
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '����ī', '�����մϴ�', '���� ���� �� ������', 3, '127.0.0.1', SYSDATE);
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '���и�', 'å �����', 'å �帲�մϴ�', 10, '127.0.0.1', SYSDATE);
INSERT INTO MVC_BOARD_T VALUES (MVC_BOARD_SEQ.NEXTVAL, '����', '�⼮�Դϴ�', '�⼮!', 2, '127.0.0.1', SYSDATE);
COMMIT;