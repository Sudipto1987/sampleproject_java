package com.sudipto.sampleproject1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_request")
public class UserRequest {
	
	
	@Id
	@Column(name="request_id")
	private int id;
	
	@Column(name="request_date")
	private Date date;
	
	@Column(name="submitted_by")
	private String submittedBy;
	
	@Column(name="action_taken")
	private String action;
	
	@Column(name="account_number")
	private int account_number;
	
	
	public UserRequest() {}


	public UserRequest(int id, Date date, String submittedBy, String action, int account_number) {
		super();
		this.id = id;
		this.date = date;
		this.submittedBy = submittedBy;
		this.action = action;
		this.account_number = account_number;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getSubmittedBy() {
		return submittedBy;
	}


	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public int getAccount_number() {
		return account_number;
	}


	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	
	
	
	
	

}
