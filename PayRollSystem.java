package com.aspire.controller;

import com.aspire.employeePayroll.EmployeePayroll;

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
 Reviewed at:5-03-2022
 1. Use proper name for exceptions
 2. MORE SPECIFIC EXCEPTION CLASSES, AT LAST MORE GENERICA CLASS
 3. SPECIFY FOR INPUT
 4. IF WE WANT MORE EMPLOYEES, HOW TO ADD THEM UP? ADD EMPLOYEE METHOD, ADD IN MAIN METHOD
 5. EXCEPTIONS FOR VALIDATING DATA, NAME AND ID AND SALARY TYPE
 6. EXCEPTION FOR START YEARS VALIDATION CHECK STRING/INTS
 */
public class PayRollSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeePayroll employeePayroll = new EmployeePayroll();
		employeePayroll.getNumberOfEmployees();
		employeePayroll.getEmployeeData();
		employeePayroll.paymentList("Bengochea"); // create exception of there is no one with that last name
		employeePayroll.paymentList("Wilke");
		employeePayroll.paymentList("Daniels");
		employeePayroll.paymentList("Smith");
		employeePayroll.paymentQueue();
		employeePayroll.displayEmployees();
		//employeePayroll.displayPayment();
		//employeePayroll.payEmployee();
	}
}
