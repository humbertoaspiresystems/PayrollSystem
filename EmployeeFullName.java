abstract class EmployeeFullName{
	double[] grossPayment,tax,netPayment,bonusPay,startYear;
	double currentYear=2022;
	String[] salaryTypes;
	public String[] firstName;
	public String[] lastName;
	public String[] FullName;
	public int[] employeeID;
	public abstract void getNumberOfEmployees();
	public abstract void getData();
	public abstract void getSalaryType();
	public abstract void showPayment();
	public abstract void showEmployeeStartAndBonus();
}

