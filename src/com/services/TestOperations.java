package com.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.dao.DatabaseOperations;
import com.exceptions.InvalidAccNumber;
import com.exceptions.InvalidInputException;
import com.exceptions.LowBalException;
import com.provider.ClientData;

class TestOperations {
	AccountService as;
	DatabaseOperations dao;
	
	@BeforeClass
	public void connectDb() {
		dao= ClientData.createDao();
		System.out.println("Connect Database Successfully....");
	}
	
	
	@Before
	public void createResourse() {
		as = new AccountService();
		assertTrue(as != null);
	}
	
	
	@Test
	public void testAccOpen() {
		try {
			as.accOpen("saving", 500);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		assertTrue(dao.getAccBal(as.getLastAccNum())>=1000);
	}

	
	@Test
	void testDeposit() {
		try {
			as.deposit(0, null, 0);
		} catch (InvalidAccNumber e) {
			e.printStackTrace();
		}
		assertTrue(dao.getAccBal(as.getLastAccNum())>=1000);
	}

	@Test
	void testWithdraw() {
		try {
			as.withdraw(0, null, 0);
		} catch (InvalidAccNumber e) {
			e.printStackTrace();
		} catch (LowBalException e) {
			e.printStackTrace();
		}
		assertTrue(dao.getAccBal(as.getLastAccNum())>= 1000);
	}

	@Test
	void testEnquire() {
		try {
			as.enquire(0, null);
		} catch (InvalidAccNumber e) {
			e.printStackTrace();
		}
		assertTrue(dao.getAccBal(as.getLastAccNum())>= 1000);
	}

	@Test
	void testDeleteAccount() {
		try {
			as.deleteAccount(0, null);
		} catch (InvalidAccNumber e) {
			e.printStackTrace();
		}
		assertTrue(dao.getAccBal(as.getLastAccNum())>= 1000);
	}
	
	@After
	public void releaseDb() {
		System.out.println("Remove Connection Successfully.......");
	}

}
