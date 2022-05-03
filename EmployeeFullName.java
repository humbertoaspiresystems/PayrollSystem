abstract class EmployeeFullName {
	double[] grossPayment, tax, netPayment, bonusPay, startYear;
	double currentYear = 2022;
	public String[] firstName;
	public String[] lastName;
	public String[] fullName;
	public int[] employeeID;
	public void getNumberOfEmployees() {};
	public abstract void getData();
	public abstract void paymentList();
	public abstract void paymentQueue();
}
