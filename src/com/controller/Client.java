package com.controller;
import java.sql.Time;
import java.util.Date;


import com.databases.Account;
import com.databases.AccountDate;
import com.exceptions.InvalidAccNumber;
import com.exceptions.InvalidInputException;
import com.exceptions.LowBalException;
import com.provider.ClientData;
import com.services.AccountService;

public class Client {
	AccountService accService;
	static Account acc = new Account(null, 100000);
//	public static String type;
//	public static float amount;
//	public static int dd;
//	public static int mm;
//	public static int yy;
	
	public static void main(String args[]) {
		
		AccountService p = (AccountService) ClientData.getObject();
		AccountService p1 = (AccountService) ClientData.getObject();
		AccountService p2 = (AccountService) ClientData.getObject();
//		try {
//			p.accOpen("saving", 2000);
//		} catch (InvalidInputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			p1.accOpen("current", 30000);
//		} catch (InvalidInputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			p2.accOpen("demet", 500000);
//		} catch (InvalidInputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			p1.deposit(1001,"saving", 200);
//		} catch (InvalidAccNumber e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			p2.withdraw(1003, "demet", 200);
//		} catch (InvalidAccNumber e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (LowBalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			p2.deleteAccount(1003, "demet");
		} catch (InvalidAccNumber e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
