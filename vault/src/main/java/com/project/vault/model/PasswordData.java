package com.project.vault.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passworddata")
public class PasswordData {
	
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name="account_id")
 private int accountId;
 @Column(name="accounttype_id")
 private int accounttypeId;
 @Column(name="account_name")
 private String accountName;
 @Column(name="acc_password")
 private String accPassword;
 
 public PasswordData() {
	 
 }
public PasswordData(int accountId, int accounttypeId, String accountName, String accPassword) {
	super();
	this.accountId = accountId;
	this.accounttypeId = accounttypeId;
	this.accountName = accountName;
	this.accPassword = accPassword;
}
public int getAccountId() {
	return accountId;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}
public int getAccounttypeId() {
	return accounttypeId;
}
public void setAccounttypeId(int accounttypeId) {
	this.accounttypeId = accounttypeId;
}
public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}
public String getAccPassword() {
	return accPassword;
}
public void setAccPassword(String accPassword) {
	this.accPassword = accPassword;
}
 
 
	
}
