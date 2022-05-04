package com.aspire.employeePayroll;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.aspire.employeeDetails.EmployeeDetails;

public class EmployeePayroll extends EmployeeDetails {
	//Scanner,list,queue and public variables declaration
	Scanner employeeScanner = new Scanner(System.in);
	ArrayList<String> paymentOrder = new ArrayList<String>();
	PriorityQueue<String> paymentQueue = new PriorityQueue<>();
	String[] firstName = new String[numberOfEmployees];
	String[] lastName = new String[numberOfEmployees];
	int[] employeeID = new int[numberOfEmployees];
	String[] fullName = new String[numberOfEmployees];
	int[] startYear = new int[numberOfEmployees];
	double[] bonusPay = new double[numberOfEmployees];
	double[] grossPayment=new double[numberOfEmployees];
	double[] netPayment = new double[numberOfEmployees];
	double[] tax = new double[numberOfEmployees];
	String[] salaryTypes = new String[numberOfEmployees];
	//Method for getting the quantity of employees
	public void getNumberOfEmployees() {
		System.out.println("There are "+numberOfEmployees+" employees to register in the payroll system");
	}

	public void getEmployeeData() {
		//Declaration of String, int and double arrays
		int validateInput=0;
		//String[] salaryTypes = new String[numberOfEmployees];
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
	public void paymentList(String lastName) {
		paymentOrder.add(lastName);
		System.out.println("You need to pay " + lastName);
	}

	public void paymentQueue() {
		int[] startYearOrder=startYear;
		Arrays.sort(startYearOrder);
		for(int counter=0; counter<startYearOrder.length; counter++) {
			System.out.println(startYearOrder[counter]);
		}
		
	}
	
	public void displayEmployees() {
		for(int counter=0; counter<numberOfEmployees; counter++) {
			System.out.print("Employee:"+fullName[counter]+"\tID:"+employeeID[counter]);
			if(salaryTypes[counter].equals("H"))
				System.out.print("\tSalary Type: Half Time");
			else
				System.out.print("\tSalary Type: Full Time");
			System.out.print("\tStart Date:"+startYear[counter]+"\n");
		}
	}
	
}
