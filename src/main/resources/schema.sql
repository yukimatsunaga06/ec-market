USE market;

DROP TABLE IF EXISTS users_table;

CREATE TABLE users_table
(id INT NOT NULL AUTO_INCREMENT,name NOT NULL VARCHAR(100),email NOT NULL VARCHAR(100),password NOT NULL TEXT,zipcode NOT NULL VARCHAR(8),address NOT NULL VARCHAR(100),telephone NOT NULL VARCHAR(15),PRIMARY KEY(id));