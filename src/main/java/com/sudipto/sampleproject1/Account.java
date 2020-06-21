package com.sudipto.sampleproject1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	
	@Id
	@Column(name="account_number")
	private int account_number;
	
	
	
	public Account() {	}



	public int getAccount_number() {
		return account_number;
	}



	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}



	public Account(int account_number) {
		super();
		this.account_number = account_number;
	}
	
	
	
	
	
	

}
