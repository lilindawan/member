package com.member.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayCheckInfo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal member_id;
	private String paycheck_money;
	private String paycheck_remarks;
	private Date paycheck_date;
	public BigDecimal getMember_id() {
		return member_id;
	}
	public void setMember_id(BigDecimal member_id) {
		this.member_id = member_id;
	}
	public String getPaycheck_money() {
		return paycheck_money;
	}
	public void setPaycheck_money(String paycheck_money) {
		this.paycheck_money = paycheck_money;
	}
	public String getPaycheck_remarks() {
		return paycheck_remarks;
	}
	public void setPaycheck_remarks(String paycheck_remarks) {
		this.paycheck_remarks = paycheck_remarks;
	}
	public Date getPaycheck_date() {
		return paycheck_date;
	}
	public void setPaycheck_date(Date paycheck_date) {
		this.paycheck_date = paycheck_date;
	}
	
	
}