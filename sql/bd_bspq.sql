DROP SCHEMA IF EXISTS bd_bsql;
DROP USER IF EXISTS 'root'@'localhost';
CREATE SCHEMA bd_bspq;
CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
GRANT ALL ON bd_bspq.* TO 'root'@'localhost';