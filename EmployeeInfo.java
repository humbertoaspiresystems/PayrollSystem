import java.util.InputMismatchException;
import java.util.Scanner;
class EmployeeInfo extends EmployeeFullName{
	Scanner employeeScanner=new Scanner(System.in);
	public int numberOfEmployees;
	
	public void getNumberOfEmployees(){
		System.out.print("Enter the number of employees:");
		numberOfEmployees=employeeScanner.nextInt();
	}
	
	public void getData()
	{
		String[] firstName=new String[numberOfEmployees];
		String[] lastName=new String[numberOfEmployees];
		int[] employeeID=new int[numberOfEmployees];
		String[] FullName=new String[numberOfEmployees];
		for(int numberOfEmployeesReached=0;numberOfEmployeesReached<numberOfEmployees;numberOfEmployeesReached++)
		{
			try{
			employeeScanner.nextLine();
			System.out.println("Enter first name, last name and ID for employee # "+(numberOfEmployeesReached+1));
			firstName[numberOfEmployeesReached]=employeeScanner.nextLine();
			lastName[numberOfEmployeesReached]=employeeScanner.nextLine();
			employeeID[numberOfEmployeesReached]=employeeScanner.nextInt();}
			catch(Exception wrongInput) { //mismatch exception should be here with multiple catch statements, invalid data type exception 
				System.out.println("Wrong input for employee ID, please use a number.");
			}
			//finally {
			//	System.out.println("If wrong input, re enter values for employees ID information please.");
			//}
		}
		System.out.println("There are "+numberOfEmployees+" employees ");
		//Display employees with ID
		for(int counter=0;counter<numberOfEmployees;counter++) {
			FullName[counter]=firstName[counter]+" "+lastName[counter];
			System.out.println(FullName[counter]+" with ID "+employeeID[counter]);}	
	}
	public void getSalaryType(){
		//System.out.println("Entro");
		String[] salaryTypes=new String[numberOfEmployees];
		try{
			System.out.println(numberOfEmployees);
		for(int counter=0;counter<numberOfEmployees;counter++) {
			employeeScanner.nextLine();
			System.out.println("Enter salary type for employee # "+(counter+1));
			salaryTypes[counter]=employeeScanner.nextLine();}}
		catch(InputMismatchException e) { 
			//more specific exception class, mismatch or invalid data
			for(int counter=0;counter<numberOfEmployees;counter++) {
			if(salaryTypes[counter]!="Half" || salaryTypes[counter]!="Full") {
				throw new NumberFormatException("Invalid value for salary type");}}
		}
	}
	
	public void showPayment() {
		double[] grossPayment=new double[numberOfEmployees];
		double[] netPayment=new double[numberOfEmployees];
		double[] tax=new double[numberOfEmployees];
		System.out.println(salaryTypes[0]);
		for(int counter=0;counter<numberOfEmployees;counter++) {
		if(salaryTypes[counter]=="Half"){
			grossPayment[counter]=8000;
			tax[counter]=0.105;
			netPayment[counter]=grossPayment[counter]-grossPayment[counter]*tax[counter];}
		if(salaryTypes[counter]=="Full") {
			grossPayment[counter]=185000;
			tax[counter]=0.155;
			netPayment[counter]=grossPayment[counter]-grossPayment[counter]*tax[counter];}}
		System.out.println(grossPayment[0]+" |"+tax[0]+"  "+netPayment[0]);}
	
	public void showEmployeeStartAndBonus(){
		double[] startYear=new double[numberOfEmployees];
		double[] bonusPay=new double[numberOfEmployees];
		System.out.println("startbonus;");
		for(int counter=0;counter<numberOfEmployees;counter++) {
		startYear[counter]=employeeScanner.nextInt();}
		for(int counter=0;counter<numberOfEmployees;counter++) {
		if((currentYear-startYear[counter])>45)
			throw new ArithmeticException("Invalid start date- enter different start date.");}
		for(int counter=0;counter<numberOfEmployees;counter++) {
			bonusPay[counter]=(currentYear-startYear[counter])*0.425*grossPayment[counter];
			System.out.println("Employee has "+(currentYear-startYear[counter])+" years working and his bonus is "+bonusPay[counter]+" Mexican pesos");}}

}
