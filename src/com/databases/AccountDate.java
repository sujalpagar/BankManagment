package com.databases;

public class AccountDate {
	private int dd,mm,yy;
	
	public AccountDate( int yy,int mm,int dd) {
		this.dd = dd;
		this.mm = mm;
		this.yy = yy;
	}
	
//Setter method
	public void setDd(int dd) {
		this.dd = dd;
	}
	
	public void setMm(int mm) {
		this.mm = mm;
	}
	
	public void setYy(int yy) {
		this.yy = yy;
	}
	
//Getter Method
	public int getDd() {
		return dd;
	}
	
	public int getMm() {
		return dd;
	}
	
	public int getYy() {
		return yy;
	}
}