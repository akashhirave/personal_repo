package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "register")
public class Register {
	
	@Id
	private String mail;
	private String password;
	
	public Register() {
		
	}
	
	public Register(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}


