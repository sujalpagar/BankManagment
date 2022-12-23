package com.databases;

public class Account {
	//Abstraction
		private int accNo;     //Encapsulation (private data)
		private String accType;
		private float accBalance;
		private AccountDate OpDate;
		public static int accNoIndex=1000;
		

	// Constructor
		public Account(String accType,float accBalance) {
			this.accNo = accNoIndex;
			accNoIndex++;
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
		
		public void setAccNoIndex(int accNoIndex) {
			this.accNoIndex=accNoIndex;
			System.out.println("Account Number Index Change Successfully.......");
		}
		
	// Getter Method
		public int getAccNoIndex() {
			return this.accNoIndex;
		}
		
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
