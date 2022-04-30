```SQL
----------------
S
    (SNO, SNAME, STATUS, CITY);
CREATE TABLE S
(
    SNO    CHAR(3),
    SNAME  CHAR(10),
    STATUS CHAR(2),
    CITY   CHAR(10)
);
----------------
P
    (PNO,PNAME,COLOR,WEIGHT);
CREATE TABLE P
(
    PNO    CHAR(3),
    PNAME  CHAR(10),
    COLOR  CHAR(4),
    WEIGHT INT
);
----------------
SPJ
    (SNO,PNO,JNO,QTY);
CREATE TABLE SPJ
(
    SNO CHAR(3),
    PNO CHAR(3),
    JNO CHAR(3),
    QTY INT
);

----------------

SELECT SNO
FROM SPJ
WHERE JNO = 'J1';

----------------

SELECT SNO
FROM SPJ
WHERE JNO = 'J1'
  AND PNO = 'P1';

----------------

SELECT SNO
FROM SPJ
WHERE JNO = 'J1'
  AND PNO IN
      (SELECT PNO
       FROM P
       WHERE COLOR = '红');

----------------

SELECT JNO
FROM J
WHERE NOT EXISTS
    (SELECT *
     FROM SPJ
     WHERE SPJ.JNO = J.JNO
       AND SNO IN
           (SELECT SNO
            FROM S
            WHERE S.CITY = '天津')
       AND SPJ.PNO IN
           (SELECT PNO
            FROM P
            WHERE P.COLOR = '红'));
-----------------------------------
SELECT SNAME, CITY
FROM S;

SELECT PNAME, COLOR, WEIGHT
FROM P;

SELECT JNO
FROM SPJ
WHERE SNO = 'S1';

SELECT P.PNAME, SPJ.QTY
FROM P,
     SPJ
WHERE P.PNO = SPJ.PNO
  AND SPJ.JNO = 'J2';

SELECT DISTINCT PNO
FROM SPJ
WHERE SNO IN
      (SELECT SNO
       FROM S
       WHERE CITY = '上海');
```

