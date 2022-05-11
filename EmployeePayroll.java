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

import org.apache.logging.log4j.Logger;

import com.aspire.employeeDetails.EmployeeDetails;
import org.apache.logging.log4j.*;
public class EmployeePayroll extends EmployeeDetails {
	Scanner employeeScanner = new Scanner(System.in);
	static {
		System.out.println("============================================");
		System.out.println("  Welcome to Aspire Payroll System App");
		System.out.println("============================================");}
	public void showPayrollSystemStartup() {
		connectDatabase();
		int optionSelect=0;
		while(optionSelect!=6) {
			waitInput();
			System.out.println("============================================");
			System.out.println("  Select an option from the following menu.  ");
			System.out.println("============================================");
			System.out.println("1.Add Employee");
			System.out.println("2.Remove Employee");
			System.out.println("3.Pay Employee");
			System.out.println("4.Display all employees");
			System.out.println("5.Display payment queue");
			System.out.println("6.Exit Payroll System");
			System.out.println("============================================");
			System.out.print("Enter option:");
		try {
		optionSelect=employeeScanner.nextInt();
		employeeScanner.nextLine();}
		catch(InputMismatchException inputMismatchException) {
			System.out.println("Invalid input, please try again.");
			optionSelect=0;
			
		}
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
				break;	
				
		case 7: testing();
				break;

		default: System.out.println("Invalid option, please try again.");
				 break;
		}}
	}
	private String user="root";
	private String password="aspire@123";
	private String url="jdbc:mysql://localhost:3306/Employees";
	private Connection connection=null;
	private void connectDatabase(){ 
				try{ 
					connection=DriverManager.getConnection(url,user,password);}
					catch(SQLException sqlException) {
						sqlException.printStackTrace();}	
				System.out.println("  Connected to Database.");
	}
	private void closeDatabase() { 
		try {
			connection.close();}
			catch(SQLException sqlException) {
				sqlException.printStackTrace();}
		System.out.println("Disconnected from database.");
	}
	public void addEmployee() {
		int validateExistence=0;
		while(validateExistence==0) {
			firstName=null;
			lastName=null;
			employeeID=0;
			salaryType=null;
			startYear=0;
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
				salaryType=null;}}	
		while(startYear==0) {
		try {
		System.out.print("Enter new employee starting year:");
		startYear=employeeScanner.nextInt();
		if((currentYear-startYear)>45){
			System.out.println("Start date is too far away, enter new start year.");
			startYear=0;}}
		catch(InputMismatchException inputMismatchException) {
			System.out.println("Input Mismatch Exception, please try again.");}
		}
		if(salaryType.equals("Half Time")==true)
			salary=8500+8500*(currentYear-startYear)*0.05;
		if(salaryType.equals("Full Time")==true)
			salary=18500+18500*(currentYear-startYear)*0.07;
		paymentStatus="Unpaid";
		try {
		Statement statement=connection.createStatement();
		String validateEmployeeExistence="SELECT Employee_ID FROM Employees WHERE First_Name='"+firstName+"' AND Last_Name='"+lastName+"'";
		ResultSet result=statement.executeQuery(validateEmployeeExistence);
		if(result.next()==true)
			System.out.println("Employee already exists in database.");
		else {
			String validateId="SELECT Employee_ID FROM Employees WHERE Employee_ID="+employeeID;
			ResultSet result2=statement.executeQuery(validateId);
			if(result2.next()==true) 
				System.out.println("Employee ID already exists in database.");
			else {
				String addEmployee="INSERT IGNORE INTO Employees VALUES ('"+firstName+"','"+lastName+"',"+employeeID+",'"+salaryType+"',"+startYear+",'"+salary+"','"+paymentStatus+"')";
				statement.execute(addEmployee);
				System.out.println("Employee added to database.");
				validateExistence=1;}}}
		catch(SQLException sqlException) {
			sqlException.printStackTrace();}
		employeeScanner.nextLine();}}
	public void removeEmployee() {
		employeeID=0;
		try {
			while(employeeID==0) {
			System.out.print("Enter employee ID:");
			try {
			employeeID=employeeScanner.nextInt();}
			catch(InputMismatchException inputMismatchException) {
				System.out.println("Wrong input for ID, please try again.");
				employeeScanner.nextLine();
				employeeID=0;
			}
			String checkEmployeeExists="SELECT First_Name FROM Employees WHERE Employee_ID="+employeeID;
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery(checkEmployeeExists);
			if(result.next()==false) {
				System.out.println("There is no employee with that ID,try again.");
				employeeID=0;}
			else {
				if(employeeID!=0) {
						String deleteEmployee="DELETE FROM Employees WHERE Employee_ID="+employeeID;						
						statement.execute(deleteEmployee);
						System.out.println("Employee deleted from database.");}}}}
			catch(SQLException sqlException) {
				sqlException.printStackTrace();}
	}
	public void payEmployee() {
		employeeID=0;
		try {
			while(employeeID==0) {
			System.out.print("Enter employee ID:");
			try {
			employeeID=employeeScanner.nextInt();}
			catch(InputMismatchException inputMismatchException) {
				System.out.println("Wrong input for ID, please try again.");
				employeeScanner.nextLine();
				employeeID=0;
			}
			String checkEmployeeExists="SELECT First_Name FROM Employees WHERE Employee_ID="+employeeID;
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery(checkEmployeeExists);
			if(result.next()==false) {
				System.out.println("There is no employee with that ID,try again.");
				employeeID=0;}
			else {
				if(employeeID!=0) {
						String payEmployee="UPDATE Employees SET Payment_Status='Paid' WHERE Employee_ID="+employeeID;
						statement.execute(payEmployee);
						System.out.println("Employee payment done.");}}}}
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
			for(int databaseRowCounter=1; databaseRowCounter<8; databaseRowCounter++) {
			employeeData+=result.getString(databaseRowCounter)+"\t";}
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
				for(int databaseRowCounter=1; databaseRowCounter<4; databaseRowCounter++) 
					employeeData+=result.getString(databaseRowCounter)+" ";
				System.out.println("You owe "+employeeData+"Mexican pesos.");
				}
			}
			catch(SQLException sqlException) {
				sqlException.printStackTrace();}
	}
	void waitInput() {
		try {
			Thread.sleep(2000);} 
		catch(InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
		
	}
}
