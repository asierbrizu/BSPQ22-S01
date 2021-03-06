CREATE DATABASE IF NOT EXISTS bd_bspq;
USE bd_bspq;
CREATE TABLE IF NOT EXISTS Usuario (email VARCHAR(100) PRIMARY KEY, contrasenya VARCHAR(100) DEFAULT NULL, nombre VARCHAR(100), apellido VARCHAR(100), dni VARCHAR(9), fecha_ncto VARCHAR(10), tipo VARCHAR(60));
CREATE TABLE IF NOT EXISTS Compra (id int (11) AUTO_INCREMENT PRIMARY KEY, usuario VARCHAR(100), matricula VARCHAR(7), fecha VARCHAR(40), id_coche VARCHAR(10));
CREATE TABLE IF NOT EXISTS Coche (id int (11) AUTO_INCREMENT PRIMARY KEY, marca VARCHAR(100), modelo VARCHAR(100), color VARCHAR(100), precio VARCHAR(100), imagen VARCHAR(100), Combustible VARCHAR(100), Instrucciones VARCHAR(100));

INSERT INTO coche VALUES( "1", "Audi", "RS e-tron GT", "Negro", "145760", "Audi-RS e-tron GT.png", "Electrico", NULL);
INSERT INTO coche VALUES( "2", "Audi", "A1", "Gris", "24810", "Audi-A1.png", "Diesel", NULL);
INSERT INTO coche VALUES( "3", "Audi", "A8", "Blanco", "110130", "Audi-A8.png", "Diesel", NULL);
INSERT INTO coche VALUES( "4", "Mercedes", "EQE", "Negro", "119476", "Mercedes-EQE.png", "Electrico", NULL);
INSERT INTO coche VALUES( "5", "Mercedes", "GLE SUV", "Negro", "137606", "Mercedes-GLE SUV.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "6", "Mercedes", "EQV", "Blanco", "78885", "Mercedes-EQV.png", "Electrico", NULL);
INSERT INTO coche VALUES( "7", "Hyundai", "i30", "Rojo", "17820", "Hyundai-i30.png", "Diesel", NULL);
INSERT INTO coche VALUES( "8", "Hyundai", "NEXO", "Marron", "72820", "Hyundai-NEXO.png", "Hidrogeno", NULL);
INSERT INTO coche VALUES( "9", "Hyundai", "KONA N", "Blanco", "40100", "Hyundai-KONA N.png", "Hibrido", NULL);
INSERT INTO coche VALUES( "10", "Alfa Romeo", "Giulia QV", "Verde", "150000", "Alfa Romeo-Giulia QV.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "11", "Alfa Romeo", "Tonale", "Azul", "58000", "Alfa Romeo-Tonale.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "12", "Alfa Romeo", "Stelvio", "Rojo", "68000", "Alfa Romeo-Stelvio.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "13", "Cupra", "Leon", "Gris", "40620", "Cupra-Leon.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "14", "Cupra", "Born", "Azul", "37500", "Cupra-Born.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "15", "Cupra", "Formentor", "Negro", "32400", "Cupra-Formentero.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "16", "Dacia", "Sandero", "Azul", "32400", "Dacia-Sandero.png", "Diesel", NULL);
INSERT INTO coche VALUES( "17", "Dacia", "Stepway", "Amarillo", "32400", "Dacia-Stepway.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "18", "Dacia", "Duster", "Naranja", "17564", "Dacia-Duster.png", "Diesel", NULL);
INSERT INTO coche VALUES( "19", "Jaguar", "I-Pace", "Plata", "81800", "Jaguar-I-Pace.png", "Electrico", NULL);
INSERT INTO coche VALUES( "20", "Jaguar", "XE", "Rojo", "51400", "Jaguar-XE.png", "Diesel", NULL);
INSERT INTO coche VALUES( "21", "Jaguar", "XF", "Blanco", "58400", "Jaguar-XF.png", "Diesel", NULL);
INSERT INTO coche VALUES( "22", "Tesla", "3", "Azul", "52976", "Tesla-3.png", "Electrico", NULL);
INSERT INTO coche VALUES( "23", "Tesla", "Y", "Blanco", "66976", "Tesla-Y.png", "Electrico", NULL);
INSERT INTO coche VALUES( "24", "Tesla", "S", "Blanco", "105400", "Tesla-S.png", "Electrico", NULL);
INSERT INTO coche VALUES( "25", "Mazda", "6", "Rojo", "33175", "Mazda-6.png", "Diesel", NULL);
INSERT INTO coche VALUES( "26", "Mazda", "MX-30", "Blanco", "34370", "Mazda-MX-30.png", "Electrico", NULL);
INSERT INTO coche VALUES( "27", "Mazda", "RX8", "Rojo", "35175", "Mazda-RX8.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "28", "Ferrari", "488", "Rojo", "258237", "Ferrari-488.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "29", "Ferrari", "GTC4", "Gris", "265708", "Ferrari-GTC4.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "30", "Ferrari", "812", "Amarillo", "339420", "Ferrari-812.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "31", "Honda", "Civic", "Blanco", "27664", "Honda-Civic.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "32", "Honda", "CR-V", "Gris", "40606", "Honda-CR-V.png", "Hibrido", NULL);
INSERT INTO coche VALUES( "33", "Honda", "Jazz", "Rojo", "23150", "Honda-Jazz.png", "Hibrido", NULL);
INSERT INTO coche VALUES( "34", "BMW", "X5", "Negro", "74000", "BMW-X5.png", "Diesel", NULL);
INSERT INTO coche VALUES( "35", "BMW", "Z4", "Rojo", "52600", "BMW-Z4.png", "Gasolina", NULL);
INSERT INTO coche VALUES( "36", "BMW", "Serie 8", "Azul", "109000", "BMW-Serie 8.png", "Gasolina", NULL);