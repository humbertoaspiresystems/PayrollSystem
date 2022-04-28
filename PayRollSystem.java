/* Title: Pay Roll Processing System
 * Author: Jose Humberto Bengochea Aranda
 * Created at:4-16-2022
 * Updated at:4-20-2022
 * Reviewed by: Anitha Manogaran
 * Reviewed at:4-20-22
 Suggestions by Anitha: 
 1. You can use display method to display all the details
 2. Now take a contract employee, calculate salary for contract employee EMPLOYEE CATEGORY REGULAR EMPLOYEE AND CONTRACT
 You can extend payroll system class for both employees
 3. Think about interface, how to implement interface concepts and Abstract class
 4. Constructors for application
 Reviewd at:4-27-2022
 1. Use proper name for exceptions
 */
public class PayRollSystem{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeInfo employeeInfo=new EmployeeInfo();
		employeeInfo.getNumberOfEmployees();
		employeeInfo.getData();
		ShowTotalPayment showTotalPayment=new ShowTotalPayment();
		showTotalPayment.getSalaryType();
		//showTotalPayment.showPayment();
		//showTotalPayment.showEmployeeStartAndBonus();
	}
}