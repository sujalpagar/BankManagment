package com.services;

import com.dao.DatabaseOperations;

//import java.time.LocalDate;
//import java.util.Date;
import java.sql.Date;
import java.util.Scanner;

import com.databases.Account;
import com.databases.AccountDate;
import com.exceptions.InvalidAccNumber;
import com.exceptions.InvalidInputException;
import com.exceptions.LowBalException;
import com.provider.ClientData;

import AccountOperations.AccountOperation;

public class AccountService implements AccountOperation
{
	Account acc;
	static Scanner sc = new Scanner(System.in);
	
	DatabaseOperations dao = ClientData.createDao();
	
	//Open Account 
	public void accOpen(String accType, float amount) throws InvalidInputException {
		try {
			if(amount>=1000) {
				acc = new Account(accType,amount);
				dao.insertAccount(acc);
				System.out.println("Account Open Successfully.... Account Number Is "+dao.getLastAccNo());
			}else {
				throw new InvalidInputException("Amount Should be 1000 or Greter than Thousand Rs.");
			}
		}
		finally {
			
		}
	}
	
	
	//Deposit
	public void deposit(int accNo,String accType, float amount) throws InvalidAccNumber {
		if(dao.validation(accNo)==true && accType.equals(dao.getAccType(accNo))) {
			float bal = dao.getAccBal(accNo);  //get Account balance from database
			float update = bal+amount;         //add deposit amount in previous amount
//			acc.setAccBal(acc.getAccBal()+amount);
			dao.updateRecord(accNo, update);
			System.out.println(amount+"rs. Amount Credited Successfully Total Balance Is "+dao.getAccBal(accNo));
		}
		else {
			throw new InvalidAccNumber("Invalid Account Number Or Password !!! Please Try Again.....");
		}
	}
	
	
	//Withdraw
	public void withdraw(int accNo,String accType, int amount) throws InvalidAccNumber, LowBalException {
		if(dao.validation(accNo)==false || (dao.getAccBal(accNo)-1000)<amount) //Minimum 1000rs balance limit 
		{
			throw new LowBalException("Your Balance Is Low");
		}
		else if(dao.validation(accNo)==true && accType.equals(dao.getAccType(accNo))){
			float userWithdraw = dao.getAccBal(accNo)-amount; //Withdraw Money By User
			dao.updateRecord(accNo, userWithdraw);

			System.out.println(amount+"rs. Amount Debited Successfully Total Balance Is "+dao.getAccBal(accNo));
		}
		else if(dao.getAccBal(accNo)<amount) {
			throw new LowBalException("Your Balance Is Low");
		}
		else {
			throw new InvalidAccNumber("Invalid Account Number Or Password !!! Please Try Again.....");
		}
	}
	
	
	//ToString
	public String toString() {
		System.out.print("Enter Account Number : ");
		int accNo = sc.nextInt();
		return ("Account Details....\n"+"Account Number : "+dao.getAccBal(accNo)+"\nAccount Type : "+dao.getAccType(accNo)+"\nAccount Balance : "+dao.getAccBal(accNo));
	}
	
	//Enquire
	public void enquire(int accNo,String accType) throws InvalidAccNumber{
		dao.retriveData(accNo);
		if(dao.validation(accNo)==true && accType.equals(dao.getAccType(accNo))) {
			System.out.println("your Account Balance is "+ dao.getAccBal(accNo));
		}else {
			throw new InvalidAccNumber("Invalid Account Number Or Password !!! Please Try Again.....");
		}
	}
	
	//Details
	public void details() {
		System.out.print("Enter Account Number : ");
		int accNo = sc.nextInt();
		System.out.println("\nAccount Details Are......\n"+"Account Number : "+accNo+"\n"+"Account Type : "+dao.getAccType(accNo)+"\n"+"Account Balance : "+dao.getAccBal(accNo));
	}

	//Delete Account 
	public void deleteAccount(int accNo,String accType) throws InvalidAccNumber {
		
		if(dao.validation(accNo)==true && accType.equals(dao.getAccType(accNo))) {
			
			dao.deleteAccount(accNo,accType);
			System.out.println("Account Delete Successfully.....");
		}
		else {
			throw new InvalidAccNumber("Invalid Account Number Or Password !!! Please Try Again.....");
		}
	}

	//last Account Number
	public int getLastAccNum() {
		return dao.getLastAccNo();
	}
	

}
