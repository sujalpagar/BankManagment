package com.databases;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

import com.dao.DatabaseOperations;
import com.provider.ClientData;



public class Account {
	
	//Abstraction
		private int accNo;     //Encapsulation (private data)
		private String accType;
		private float accBalance;
		private AccountDate OpDate;



	// Constructor
		public Account(int accNo,String accType,float accBalance) {

			this.accNo = accNo;   //accNo AutoGeneration Algorithm Present At "com.services.AccountService"
			this.accType= accType;
			this.accBalance=accBalance;
//			this.OpDate = OpDate;
			
		}
		
	// Setter Method
		public void setAccNo(int accNo) {
			this.accNo=accNo;
		}
		
		public void setAccType(String accType) {
			this.accType = accType;
		}
		
		public void setAccBal(float accBalance) {
			this.accBalance = accBalance;
		}
		

		
	// Getter Method
		
		public int getAccNo() {
			return this.accNo;
		}
		
		public String getAccType() {
			return this.accType;
		}
		
		public float getAccBal() {
			return this.accBalance;
		}
		
	// toString Method
		public String toString() {
			return ("Account Details....\n"+"Account Number : "+this.accNo+"\nAccount Type : "+this.accType+"\nAccount Balance : "+this.accBalance);
		}
		
}

