package com.aspire.employeePayroll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.aspire.employeeDetails.EmployeeDetails;

public class EmployeePayroll extends EmployeeDetails {
	
	//Method for getting the quantity of employees
	Scanner employeeScanner = new Scanner(System.in);
	//New coding here
	public void showPayrollSystemStartup() {
		System.out.println("============================================");
		System.out.println("    Welcome to Aspire Payroll System App");
		System.out.println("============================================");
		System.out.println("1.Add Employee");
		System.out.println("2.Remove Employee");
		System.out.println("3.Pay Employee");
		System.out.println("4.Display all employees");
		System.out.println("5.Display payment queue");
		System.out.println("6.Exit Payroll System");
		System.out.println("============================================");
		int optionSelect=0;
		while(optionSelect!=6) {
		optionSelect=employeeScanner.nextInt();
		switch(optionSelect) {
		case 1: addEmployee();
				break;
		case 2: removeEmployee();
				break;
		case 3: payEmployee();
				break;
		case 4: displayEmployees();
				break;
		case 5: displayQueue();
				break;
		case 6: System.out.println("Exiting Payroll System.");
				closeDatabase();
				System.exit(0);
		}}
	}
	
	String user="root";
	String password="aspire@123";
	String url="jdbc:mysql://localhost:3306/Employees";
	Connection connection=null;
	
	public void connectDatabase() {
		//Connection to SQL Database
				try{ 
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection=DriverManager.getConnection(url,user,password);}
					catch(ClassNotFoundException classNotFound) {
						classNotFound.printStackTrace();}
					catch(SQLException sqlException) {
						sqlException.printStackTrace();}	
				System.out.println("Connected to Database.");
	}
	
	public void closeDatabase() {
		try {
			connection.close();}
			catch(SQLException e) {
				e.printStackTrace();}
		System.out.println("Disconnected from database.");
	}
	
	public void addEmployee() {
		employeeScanner.nextLine();
		
		while(firstName==null) {
			System.out.print("Enter new employee first name:");
			firstName=employeeScanner.nextLine();
			if(firstName.matches("^[a-zA-Z]*$")==false) {
				System.out.println("Wrong input for first name, please try again.");
				firstName=null;}}
		
		while(lastName==null) {
			System.out.print("Enter new employee last name:");
			lastName=employeeScanner.nextLine();
			if(lastName.matches("^[a-zA-Z]*$")==false) {
				System.out.println("Wrong input for last name, please try again.");
				lastName=null;}}
		
		while(employeeID==0) {
			try {
				System.out.print("Enter new employee ID:");
				employeeID=employeeScanner.nextInt();}
			catch (InputMismatchException inputMismatchException) { 
				System.out.println("Wrong input for employee ID, please use a number.");
				employeeID=0;
				employeeScanner.nextLine();}}
			
		while(salaryType==null) {
			employeeScanner.nextLine();
			System.out.print("Enter new salary type (Enter Half or Full Time):");
			salaryType=employeeScanner.nextLine();
			if(salaryType.equals("HalfTime")) {
				System.out.println("Wrong salary type input, please try again.");
				salaryType=null;}
			if(salaryType.equals("FullTime")) {
				System.out.println("Wrong salary type input, please try again.");
				salaryType=null;}
		}
			
		while(startYear==0) {
		System.out.print("Enter new employee starting year:");
		startYear=employeeScanner.nextInt();
		if((currentYear-startYear)>45){
			System.out.println("Start date is too far away, enter new start year.");
			startYear=0;}
		}
		
		if(salaryType.equals("Half Time")==true)
			salary=8500;
		
		if(salaryType.equals("Full Time")==true)
			salary=18500;
		
		paymentStatus="Unpaid";
		
		System.out.println(firstName+" "+lastName+" "+employeeID+" "+salaryType+" "+startYear+" "+salary+" "+paymentStatus);

		try {
		Statement statement=connection.createStatement();
		String addEmployee="INSERT IGNORE INTO Employees VALUES ('"+firstName+"','"+lastName+"',"+employeeID+",'"+salaryType+"',"+startYear+",'"+salary+"','"+paymentStatus+"')";
		statement.execute(addEmployee);
		System.out.println("Employee added to database.");
		}
		catch(SQLException sqlException) {
			sqlException.printStackTrace();}
		
	}
	public void removeEmployee() {
		employeeScanner.nextLine();
		
		System.out.print("Enter employee first name:");
		firstName=employeeScanner.nextLine();
		System.out.print("Enter employee last name:");
		lastName=employeeScanner.nextLine();
		
		try {
			Statement statement=connection.createStatement();
			String deleteEmployee="DELETE FROM Employees WHERE First_Name='"+firstName+"' AND Last_Name='"+lastName+"'";
			statement.execute(deleteEmployee);
			System.out.println("Employee deleted from database.");
			}
			catch(SQLException sqlException) {
				sqlException.printStackTrace();}
	}
	public void payEmployee() {
		
		System.out.print("Enter employee ID:");
		employeeID=employeeScanner.nextInt();
		
		try {
			Statement statement=connection.createStatement();
			String payEmployee="UPDATE Employees SET Payment_Status='Paid' WHERE Employee_ID="+employeeID;
			statement.execute(payEmployee);
			System.out.println("Employee payment done.");
			}
			catch(SQLException sqlException) {
				sqlException.printStackTrace();}
		
	}
	
	public void displayEmployees() {
		try {
		Statement statement=connection.createStatement();
		String showEmployees="SELECT * FROM Employees";
		ResultSet result=statement.executeQuery(showEmployees);
		while(result.next()) {
			String employeeData="";
			for(int i=1; i<8; i++) {
			employeeData+=result.getString(i)+"\t";}
			System.out.println(employeeData);
			}
		}
		catch(SQLException sqlException) {
			sqlException.printStackTrace();}	
	}
	
	public void displayQueue() {
		try {
			Statement statement=connection.createStatement();
			String displayQueue="SELECT First_Name,Last_Name,Salary FROM Employees WHERE Payment_Status='Unpaid' ORDER BY Start_Year ASC";
			ResultSet result=statement.executeQuery(displayQueue);
			while(result.next()) {
				String employeeData="";
				for(int i=1; i<4; i++) {
				employeeData+=result.getString(i)+"\t";}
				System.out.println(employeeData);
				}
			}
		catch(SQLException sqlException) {
			sqlException.printStackTrace();}
		
		
	}
}
