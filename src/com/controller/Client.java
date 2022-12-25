package com.controller;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

import com.databases.Account;
import com.databases.AccountDate;
import com.exceptions.InvalidAccNumber;
import com.exceptions.InvalidInputException;
import com.exceptions.LowBalException;
import com.provider.ClientData;
import com.services.AccountService;


public class Client {
	AccountService accService;
	static Scanner sc = new Scanner(System.in);
	static Account acc = new Account(0000,null, 100000);

	
	public static void main(String args[]) {
		AccountService acs;
		acs = (AccountService) ClientData.getObject(); 

/* ***********************************************************************************************
* 
*  Using acs Reference We Can Perform Multiple Operations Account Open, Withdraw Money, Deposite
*  Money And Account Balance Enquiry Using One Reference.
* 
**************************************************************************************************/
		
		System.out.print("Enter Account Type Here : ");  //Account Type Input
		String accType = sc.next();

		System.out.print("Enter Amount For Opening Account (1000rs min) : ");  //Amount
		float amount = sc.nextFloat();
//*****************************************************************************		
	//1.Account Opening 
		try {
			acs.accOpen(accType, amount);                        
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		
		try {
			acs.accOpen("employee", 145000);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	
		
	//2.Deposite Money       
		
		try {
			acs.deposit(1002, "saving", 680);  //Security Purpose Check Account Number And Account Type With Database
		} catch (InvalidAccNumber e) {
			e.printStackTrace();
		}

		
	//3.Withdraw Money
		
		try {
			acs.withdraw(1002,"saving", 568); //Security Purpose Check Account Number And Account Type With Database
		} catch (InvalidAccNumber e) {
			e.printStackTrace();
		} catch (LowBalException e) {
			e.printStackTrace();
		}
		

		
	//4.Enquiry Of Account
		
		try {
			acs.enquire(1004, "employee");   //Security Purpose Check Account Number And Account Type With Database
		} catch (InvalidAccNumber e) {
			e.printStackTrace();
		}  
		
		
	//5.Delete Account
		
		try {
			acs.deleteAccount(1006, "demet");
		} catch (InvalidAccNumber e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
