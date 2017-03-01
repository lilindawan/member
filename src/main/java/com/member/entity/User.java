package com.member.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 8809101560720973267L;

	private BigDecimal member_id;
	private String member_name;
	private String member_birthday;
	private String due_date;
	private String phone_number;
	private String available_amount;
	private String total_consumption;
	private String total_money;
	public String getTotal_money() {
		return total_money;
	}
	public void setTotal_money(String total_money) {
		this.total_money = total_money;
	}
	private String remarks;
	private Date creation_date;
	public BigDecimal getMember_id() {
		return member_id;
	}
	public void setMember_id(BigDecimal member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_birthday() {
		return member_birthday;
	}
	public void setMember_birthday(String member_birthday) {
		this.member_birthday = member_birthday;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAvailable_amount() {
		return available_amount;
	}
	public void setAvailable_amount(String available_amount) {
		this.available_amount = available_amount;
	}
	public String getTotal_consumption() {
		return total_consumption;
	}
	public void setTotal_consumption(String total_consumption) {
		this.total_consumption = total_consumption;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}