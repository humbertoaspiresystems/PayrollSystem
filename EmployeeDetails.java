package com.aspire.employeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeDetails extends Thread{
	
	public String firstName,lastName,salaryType,paymentStatus="";
	public int employeeID;
	public double salary=0,startYear,currentYear=2022;
	private String user = "root";
	private String password = "aspire@123";
	private String url = "jdbc:mysql://localhost:3306/Employees";
	protected Connection connectionToDatabase = null;
	protected void connectDatabase() {
		try {
			connectionToDatabase = DriverManager.getConnection(url, user, password);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		System.out.println("  Connected to Database.");
	};
	protected void closeDatabase() {
		try {
			connectionToDatabase.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		System.out.println("Disconnected from database.");
	};
	public void waitForInput() {
		try {
			Thread.sleep(2000);}
		catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();}}
}
