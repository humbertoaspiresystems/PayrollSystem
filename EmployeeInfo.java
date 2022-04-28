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
}
