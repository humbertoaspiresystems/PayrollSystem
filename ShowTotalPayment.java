import java.util.InputMismatchException;

class ShowTotalPayment extends EmployeeInfo{
	double[] grossPayment,tax,netPayment,bonusPay,startYear;
	double currentYear=2022;
	String[] salaryTypes;
	public void getSalaryType(){
		//System.out.println("Entro");
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
		System.out.println("showPayment;");
		for(int counter=0;counter<numberOfEmployees;counter++) {
		if(salaryTypes[counter]=="Half"){
			grossPayment[counter]=8000;
			tax[counter]=0.105;
			netPayment[counter]=grossPayment[counter]-grossPayment[counter]*tax[counter];}
		if(salaryTypes[counter]=="Full") {
			grossPayment[counter]=185000;
			tax[counter]=0.155;
			netPayment[counter]=grossPayment[counter]-grossPayment[counter]*tax[counter];}}}
	
	public void showEmployeeStartAndBonus(){
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