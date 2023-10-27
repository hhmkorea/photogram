CREATE USER 'cos'@'%' IDENTIFIED BY 'cos1234'; 
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
CREATE DATABASE photogram;

SELECT * FROM user; 
DESC USER;
TRUNCATE user;

SELECT * FROM subscribe;
SELECT * FROM image;
TRUNCATE image;

-- 구독수 
SELECT COUNT(*) FROM subscribe WHERE fromUserId = 1;

-- 구독여부(ssal로 로그인, cos 페이지로 감) 
SELECT COUNT(*) FROM subscribe WHERE fromUserId = 1 AND toUserId = 2;



