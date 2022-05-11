CREATE DATABASE IF NOT EXISTS Employees;
USE Employees;

CREATE TABLE IF NOT EXISTS Employees(
First_Name CHAR(25),
Last_name CHAR(25),
Employee_ID INT NOT NULL,
Salary_Type CHAR(25),
Start_Year INT NOT NULL,
Salary INT NOT NULL,
Payment_Status CHAR(20)
);

SELECT * FROM Employees;

