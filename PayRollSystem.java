package com.aspire.controller;
import com.aspire.employeePayroll.EmployeePayroll;
import org.apache.logging.log4j.*;
/* Title: Pay Roll Processing System
 * Author: Jose Humberto Bengochea Aranda
 * Created at:4-16-2022
 * Updated at:5-10-2022
 * Reviewed by: Anitha
 * Reviewed at:5-10-2022
 * Suggestions:
//Display options from menu
//Try logger files - extra
//Use Private method for database connection - same class can be static
//Use thread for sleep
//Use Static blocks and methods
 */
public class PayRollSystem extends Thread{
	//private static Logger demoLogger=LogManager.getLogger(PayRollSystem.class.getName());
	public static void main(String[] args) {
		EmployeePayroll employeePayroll = new EmployeePayroll();
		employeePayroll.start();
		//employeePayroll.connectDatabase();
		employeePayroll.showPayrollSystemStartup();
		//demoLogger.info("Click successfull");
		//demoLogger.error("DB Connection Failed");
		//demoLogger.debug("This is a debug");
	}
}
