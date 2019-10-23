DROP TABLE IF EXISTS sequence;
CREATE TABLE sequence (
                          NAME VARCHAR ( 50 ) NOT NULL,
                          current_value INT NOT NULL,
                          increment INT NOT NULL DEFAULT 1,
                          PRIMARY KEY ( NAME )
) ENGINE = INNODB;

DROP FUNCTION IF EXISTS currval;
DELIMITER $
CREATE FUNCTION currval ( seq_name VARCHAR ( 50 ) )
    RETURNS INTEGER
    LANGUAGE SQL
    DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY
        DEFINER COMMENT ''
BEGIN
    DECLARE    VALUE    INTEGER;
    SET VALUE    = 0;
    SELECT
        current_value INTO
        VALUE    FROM sequence WHERE NAME = seq_name;
    RETURN VALUE;
END $DELIMITER;


DROP FUNCTION IF EXISTS nextval;
DELIMITER $
CREATE FUNCTION nextval ( seq_name VARCHAR ( 50 ) )
RETURNS INTEGER
LANGUAGE SQL
DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
    UPDATE sequence
    SET current_value = current_value + increment
    WHERE
        NAME = seq_name;
    RETURN currval ( seq_name );
END $DELIMITER;


DROP FUNCTION IF EXISTS nextval;
DELIMITER $
CREATE FUNCTION nextval ( seq_name VARCHAR ( 50 ) )
    RETURNS INTEGER
    LANGUAGE SQL
    DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
    UPDATE sequence
    SET current_value = current_value + increment
    WHERE
            NAME = seq_name;
    RETURN currval ( seq_name );
END $DELIMITER;

DROP FUNCTION IF EXISTS setval;
DELIMITER $
CREATE FUNCTION setval ( seq_name VARCHAR ( 50 ), VALUE INTEGER )
    RETURNS INTEGER
    LANGUAGE SQL
    DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
    UPDATE sequence SET current_value = VALUE
    WHERE
            NAME = seq_name;
    RETURN currval ( seq_name );
END $DELIMITER;

INSERT INTO sequence VALUES ('UserIdSeq',0,1);
--添加一个sequence名称和初始值，以及自增幅度添加一个名为UserIdSeq的自增序列

SELECT SETVAL('UseridSeq',0);
--设置指定sequence的初始值这里设置UserIdSeq的初始值为0

SELECT CURRVAL('UseridSeq');
--查询指定sequence的当前值这里是获取UserIdSeq当前值

SELECT NEXTVAL('UseridSeq');--查询指定sequence的下一个值这里是获取UserIdSeq下一个值