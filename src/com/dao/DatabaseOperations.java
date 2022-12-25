package com.dao;

import com.databases.Account;

public interface DatabaseOperations {
	
	void insertAccount(Account acc);
	Account retriveData(int accNo);
	void updateRecord(int accNo,float updatedbal);
	void deleteAccount(int accNo,String accType);
	boolean validation(int accNo);
	float getAccBal(int accNo);
	String getAccType(int accNo);
	int getLastAccNo();
	
}