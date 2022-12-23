package com.daoimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.DatabaseOperations;
import com.databases.Account;
import com.mysql.cj.protocol.Resultset;
import com.provider.DBConnectionProvider;

public class DaoImplement implements DatabaseOperations {
	Connection con = DBConnectionProvider.getDbConnection();
	PreparedStatement ps;
	ResultSet rs; 
	
	
	public void insertAccount(Account acc) {
		try {
			ps = con.prepareStatement("insert into accdetails values(?,?,?) ");
			ps.setInt(1, acc.getAccNo());
			ps.setString(2, acc.getAccType());
			ps.setFloat(3, acc.getAccBal());
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Account retriveData(int accNo) {
		Account acc = null;
		try {
			ps = con.prepareStatement("select * from accdetails where accNo=?");
			ps.setInt(1, accNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Account Number : "+rs.getInt(1));
				System.out.println("Account Type : "+rs.getString(2));
				System.out.println("Total Balance : "+rs.getFloat(3));
			}
			if(rs==null) {
				System.out.println("Invalid Account Details");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	public void updateRecord(int accNo, float updatedbal) {
		Account acc = null;

		try {
			ps=con.prepareStatement("update accdetails set accBal=? where accNo=?");
//			ps=con.prepareStatement("select accBal from accdetails where accNo= ? ");
			ps.setFloat(1, updatedbal);
			ps.setInt(2, accNo);
			ps.executeUpdate();
			
			
//			System.out.println("Balance Update Successfully....");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public void deleteAccount(int accNo,String accType) {
		Account acc;
		try {
			ps=con.prepareStatement("delete from accdetails where accNo=? and accType=?");
			ps.setInt(1, accNo);
			ps.setString(2,accType);
			ps.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

	
	public boolean validation(int accNo) {
		try {
			ps = con.prepareStatement("select accNo from accdetails where accNo=?");
			ps.setInt(1, accNo);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int accNovar = rs.getInt(1);
				
				if(accNovar == accNo) {
					return true;
				}else {
					return false;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public float getAccBal(int accNo) {
		float bal = 0;
		try {
			ps=con.prepareStatement("select accBal from accdetails where accNo= ? ");
			ps.setInt(1, accNo);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				bal = rs.getFloat(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bal;
	}
	
	public String getAccType(int accNo) {
		String type=null;
		try {
			ps=con.prepareStatement("select accType from accdetails where accNo= ? ");
			ps.setInt(1, accNo);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				type = rs.getString(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return type;
	}
	
	public int getLastAccNo() {
		int num = 0;
		try {
			ps =con.prepareStatement("SELECT * FROM ( SELECT accNo FROM accdetails ORDER BY accNo DESC LIMIT 1 )Var1 ORDER BY accNo ASC;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				try {
					num = rs.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
		
	}
	
	
}
