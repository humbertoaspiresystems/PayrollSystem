package com.aspire.controller;
import com.aspire.employeePayroll.EmployeePayroll;
/* Title: Pay Roll Processing System
 * Author: Jose Humberto Bengochea Aranda
 * Created at:4-16-2022
 * Updated at:4-20-2022
 * Reviewed by: Anitha Manogaran
 * Reviewed at:4-20-22
 Suggestions by Anitha: 
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
		
		EmployeePayroll employeePayroll = new EmployeePayroll();
		employeePayroll.connectDatabase();
		employeePayroll.showPayrollSystemStartup();
		//employeePayroll.displayEmployees();
		
	}
}
