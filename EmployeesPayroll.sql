CREATE DATABASE IF NOT EXISTS Employees;
USE Employees;

CREATE TABLE IF NOT EXISTS Employees(
First_Name CHAR(25),
Last_name CHAR(25),
Employee_ID INT NOT NULL,
Salary_Type CHAR(25),
Start_Year INT NOT NULL,
Salary INT NOT NULL,
Payment_Status CHAR(20),
PRIMARY KEY (First_Name));
/*
INSERT IGNORE INTO Employees VALUES ('Jose','Bengochea', 500017, 'Full Time', 2022,18500,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Ramiro','Moreno', 500032, 'Half Time', 2004,8000,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Gijs','Wilke', 500087, 'Half Time', 2002,8000,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Diego','Bravo', 500045, 'Half Time', 2012,8000,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Jose Pablo','Alatorre', 500023, 'Full Time', 2020,18500,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Luis','Monroy', 500145, 'Full Time', 2022,18500,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Xavier','Macias', 500465, 'Full Time', 2000,18500,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Ricardo','Albuquerque', 500854, 'Full Time', 2001,18500,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Ronald','Weasley', 500458, 'Half Time', 2015,8000,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Harry','Potter', 500021, 'Full Time', 2018,18500,'Unpaid');
INSERT IGNORE INTO Employees VALUES ('Cristiano','Ronaldo', 500098, 'Half Time', 2021,18500,'Unpaid');*/
SELECT * FROM Employees;

