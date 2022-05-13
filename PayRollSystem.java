package com.aspire.controller;
import com.aspire.employeeDetails.EmployeeDetails;
import com.aspire.employeePayroll.EmployeePayroll;

public class PayRollSystem {
	public static void main(String[] args) {
		EmployeePayroll employeePayroll = new EmployeePayroll();
		EmployeeDetails employeeDetails=new EmployeeDetails();
		employeeDetails.start();
		employeePayroll.start();
		employeePayroll.showPayrollSystemStartup();		
}}
