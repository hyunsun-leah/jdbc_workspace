CREATE TABLE PRODUCT(
    PRODUCT_ID VARCHAR2(20) PRIMARY KEY,
    P_NAME VARCHAR2(20) NOT NULL,
    PRICE NUMBER NOT NULL,
    DESCRIPTION VARCHAR2(20),
    STOCK NUMBER NOT NULL
);

SELECT * FROM PRODUCT;

INSERT INTO PRODUCT
VALUES ('nb_ss7', '�Ｚ��Ʈ��', '1570000', '�ø���7', '10');