package com.provider;

import java.io.FileInputStream;
import java.util.Properties;

import com.dao.DatabaseOperations;
import com.services.AccountService;

import AccountOperations.AccountOperation;

public class ClientData {
	
	static FileInputStream fis;
	static Properties p=new Properties() ;
	
	static {	
		try{
			fis = new FileInputStream(".//Resourses//config.properties");
			p = new Properties();
			p.load(fis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public static Properties getAccNumberIndex(String filename) {
//		AccountService asobj = null;
//		FileInputStream fis = null;
//		
//		try {
//			fis = new FileInputStream(filename);
//			p=new Properties();
//			p.load(fis);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return p;
//	}
	
	
	public static AccountOperation getObject() {
		AccountOperation accobj = null;
		FileInputStream fis = null;
		
		try {
				
			String classname = p.getProperty("class");
			
			accobj =(AccountOperation) Class.forName(classname).newInstance();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return accobj;
	}
	
	public static DatabaseOperations createDao() {
		DatabaseOperations dao=null;
		try {
			String classDao = p.getProperty("classDao");
			dao=(DatabaseOperations)Class.forName(classDao).newInstance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
}
