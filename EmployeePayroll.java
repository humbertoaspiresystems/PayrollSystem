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
	/*	public void getNumberOfEmployees() {
			System.out.println("How many employees do you want to add?");
			numberOfEmployees=employeeScanner.nextInt();
			String[] fullName = new String[numberOfEmployees];
			System.out.println(fullName.length);
		}
	//Scanner,list,queue and public variables declaration
	Scanner employeeScanner = new Scanner(System.in);
	/*ArrayList<String> paymentOrder = new ArrayList<String>();
	PriorityQueue<String> paymentQueue = new PriorityQueue<>();
	public int numberOfEmployees;
	public String[] firstName = new String[numberOfEmployees];
	String[] lastName = new String[numberOfEmployees];
	int[] employeeID = new int[numberOfEmployees];
	String[] fullName = new String[numberOfEmployees];
	String[] salaryTypes = new String[numberOfEmployees];
	double[] bonusPay = new double[numberOfEmployees];
	double[] grossPayment=new double[numberOfEmployees];
	double[] netPayment = new double[numberOfEmployees];
	double[] tax = new double[numberOfEmployees];
	int[] startYear = new int[numberOfEmployees];
	
	public void getEmployeeData() {
		//Declaration of String, int and double arrays
		int validateInput=0;
		//For loop for employee first and last name input
		for(int numberOfEmployeesReached = 0; numberOfEmployeesReached < numberOfEmployees; numberOfEmployeesReached++) {
			try {
				//employeeScanner.nextLine();
				System.out.println("Enter first name, last name and ID for employee #" + (numberOfEmployeesReached + 1));
				while(firstName[numberOfEmployeesReached]==null) {
					firstName[numberOfEmployeesReached] = employeeScanner.nextLine();
						if(firstName[numberOfEmployeesReached].matches("^[a-zA-Z]*$")==false || firstName[numberOfEmployeesReached]=="") 
							System.out.println("Wrong first name input, try again ");
						else
							validateInput=1;}
				
				validateInput=0;
				while(validateInput==0) {
					lastName[numberOfEmployeesReached] = employeeScanner.nextLine();
						if(lastName[numberOfEmployeesReached].matches("^[a-zA-Z]*$")==false || lastName[numberOfEmployeesReached]=="") 
							System.out.println("Wrong last name input, try again ");
						else
							validateInput=1;}
				employeeID[numberOfEmployeesReached] = employeeScanner.nextInt();
				
			} catch (InputMismatchException inputMismatchException) { // mismatch exception should be here with multiple catch statements, invalid data type exception
				System.out.println("Wrong input for employee ID, please use a number.");
				numberOfEmployeesReached--;
			} 
		}
		// Display employees with ID
		for(int counter = 0; counter < numberOfEmployees; counter++) {
			fullName[counter] = firstName[counter] + " " + lastName[counter];
		}
		//Get Salaries
		try {
			employeeScanner.nextLine();
			for (int counter = 0; counter < numberOfEmployees; counter++) {
				System.out.println("Enter salary type for employee # " + (counter + 1)+" (Enter H for half time and F for full time");
				validateInput=0;
				while(validateInput==0) {
					salaryTypes[counter]=employeeScanner.nextLine();
					if(salaryTypes[counter].equals("H") || salaryTypes[counter].equals("F")) 
						validateInput=1;
					else
						System.out.println("Wrong input for salary type, please try again."+salaryTypes[counter]);}
		} }
		catch (InputMismatchException inputMismatchException) {
			for (int counter = 0; counter < numberOfEmployees; counter++) {
				if (salaryTypes[counter] != "H" || salaryTypes[counter] != "F") {
					throw new NumberFormatException("Invalid value for salary type");
				}
			}
		} // USE ANOTHER CATCH STATEMENTS LINE 62
		
		//Get Payments in Mexican pesos
		 for(int counter=0;counter<numberOfEmployees;counter++) {
		 if(salaryTypes[counter].equals("H")==true){ 
			 grossPayment[counter]=8000;
			 tax[counter]=0.105;
			 netPayment[counter]=grossPayment[counter]-grossPayment[counter]*tax[counter];} 
		 if(salaryTypes[counter].equals("F")==true) { 
			 grossPayment[counter]=185000;
			 tax[counter]=0.155;
			 netPayment[counter]=grossPayment[counter]-grossPayment[counter]*tax[counter];}
		 }
		 //Get Start and Bonus
		 try {
		 for (int counter = 0; counter < numberOfEmployees; counter++) {
		System.out.println("Enter start year for employee #"+(counter+1));
		startYear[counter] = employeeScanner.nextInt();
		if((currentYear - startYear[counter]) > 40 && startYear[counter]!=0)
			 throw new ArithmeticException("Invalid start date for employee #"+(counter+1)+"- enter different start date.");
		
		 }}
		 catch(InputMismatchException inputMismatchException) {
			 System.out.println("Invalid input for start date, must be a year.");
		 }
		 
		 for(int counter = 0; counter < numberOfEmployees; counter++) {
			 bonusPay[counter] = (currentYear-startYear[counter])* 0.35 * grossPayment[counter];
			 //System.out.println("Employee has " + (currentYear - startYear[counter]) + " years working and his bonus is "+ bonusPay[counter] + " Mexican pesos");
		 }
}
	/*public void paymentList(String lastName) {
		paymentOrder.add(lastName);
		System.out.println("You need to pay " + lastName);
	}*/
/*
	public void paymentQueue() {/*
		int[] startYearOrder=startYear;
		Arrays.sort(startYearOrder);
		for(int counter=0; counter<startYearOrder.length; counter++) {
			System.out.println(startYearOrder[counter]);
		}
		*/
	//	System.out.println("ahora si jalo");
//	}
	Scanner employeeScanner = new Scanner(System.in);
	//New coding here
	public void showPayrollSystemStartup() {
		System.out.println("==============================================");
		System.out.println("\tWelcome to Aspire Payroll System");
		System.out.println("==============================================");
		System.out.println("1.Add Employee");
		System.out.println("2.Remove Employee");
		System.out.println("3.Pay Employee");
		System.out.println("4.Display all employees");
		System.out.println("5.Display payment queue");
		System.out.println("6.Exit Payroll System");
		System.out.println("==============================================");
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
		case 6: System.out.println("Exiting Payroll System");
				
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
		
		System.out.print("Enter new employee first name:");
		firstName=employeeScanner.nextLine();
		
		System.out.print("Enter new employee last name:");
		lastName=employeeScanner.nextLine();
		
		System.out.print("Enter new employee ID:");
		employeeID=employeeScanner.nextInt();
		
		System.out.print("Enter new salary type(Enter Half Time or Full Time):");
		employeeScanner.nextLine();
		salaryType=employeeScanner.nextLine();
		
		System.out.print("Enter new employee starting year:");
		startYear=employeeScanner.nextInt();
		
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
			System.out.println("Employee deleted from database.");
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
		
	}
}
