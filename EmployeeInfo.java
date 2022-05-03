import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

class EmployeeInfo extends EmployeeFullName {
	//Scanner,list,queue and public variables declaration
	Scanner employeeScanner = new Scanner(System.in);
	public int numberOfEmployees;
	public String[] salaryTypes;
	ArrayList<String> paymentOrder = new ArrayList<String>();
	double[] grossPayment = new double[numberOfEmployees];
	PriorityQueue<String> paymentQueue = new PriorityQueue<>();
	//Method for getting the quantity of employees
	public void getNumberOfEmployees() {
		System.out.print("Enter the number of employees:");
		numberOfEmployees = employeeScanner.nextInt();
	}
	
	public void getData() {
		//Declaration of String, int and double arrays
		String[] firstName = new String[numberOfEmployees];
		String[] lastName = new String[numberOfEmployees];
		int[] employeeID = new int[numberOfEmployees];
		String[] fullName = new String[numberOfEmployees];
		double[] startYear = new double[numberOfEmployees];
		double[] bonusPay = new double[numberOfEmployees];
		double[] grossPayment=new double[numberOfEmployees];
		double[] netPayment = new double[numberOfEmployees];
		double[] tax = new double[numberOfEmployees];
		String[] salaryTypes = new String[numberOfEmployees];
		//For loop for employee first and last name input
		for (int numberOfEmployeesReached = 0; numberOfEmployeesReached < numberOfEmployees; numberOfEmployeesReached++) {
			try {
				employeeScanner.nextLine();
				System.out.println("Enter first name, last name and ID for employee #" + (numberOfEmployeesReached + 1));
				firstName[numberOfEmployeesReached] = employeeScanner.nextLine();
				lastName[numberOfEmployeesReached] = employeeScanner.nextLine();
				employeeID[numberOfEmployeesReached] = employeeScanner.nextInt();
			} catch (Exception wrongInput) { // mismatch exception should be here with multiple catch statements, invalid data type exception
				System.out.println("Wrong input for employee ID, please use a number.");
			}
		}
		// Display employees with ID
		for (int counter = 0; counter < numberOfEmployees; counter++) {
			fullName[counter] = firstName[counter] + " " + lastName[counter];
		}
		//Get Salaries
		try {
			employeeScanner.nextLine();
			for (int counter = 0; counter < numberOfEmployees; counter++) {
				System.out.println("Enter salary type for employee # " + (counter + 1));
				salaryTypes[counter] = employeeScanner.nextLine();
			}
		} catch (InputMismatchException e) {
			// more specific exception class, mismatch or invalid data
			for (int counter = 0; counter < numberOfEmployees; counter++) {
				if (salaryTypes[counter] != "Half" || salaryTypes[counter] != "Full") {
					throw new NumberFormatException("Invalid value for salary type");
				}
			}
		}
		
		//Get Payments
		 for(int counter=0;counter<numberOfEmployees;counter++) {
		 if(salaryTypes[counter].equals("Half")==true){ 
			 grossPayment[counter]=8000;
			 tax[counter]=0.105;
			 netPayment[counter]=grossPayment[counter]-grossPayment[counter]*tax[counter];} 
		 if(salaryTypes[counter].equals("Full")==true) { 
			 grossPayment[counter]=185000;
			 tax[counter]=0.155;
			 netPayment[counter]=grossPayment[counter]-grossPayment[counter]*tax[counter];}
		 }
		 //Get Start and Bonus
		 
		 for (int counter = 0; counter < numberOfEmployees; counter++) {
		System.out.println("Enter start year for employee #"+(counter+1));
		startYear[counter] = employeeScanner.nextInt();
		 }
	
		 for (int counter = 0; counter < numberOfEmployees; counter++) {
			 if ((currentYear - startYear[counter]) > 40)
				 throw new ArithmeticException("Invalid start date- enter different start date.");
		 }
		 for (int counter = 0; counter < numberOfEmployees; counter++) {
			 bonusPay[counter] = (currentYear-startYear[counter])* 0.35 * grossPayment[counter];
			 System.out.println("Employee has " + (currentYear - startYear[counter]) + " years working and his bonus is "+ bonusPay[counter] + " Mexican pesos");
		 }
}
	public void paymentList(String lastName) {
		paymentOrder.add(lastName);
		System.out.println("You need to pay " + lastName);
	}

	public void paymentQueue() {
		
	}
}
