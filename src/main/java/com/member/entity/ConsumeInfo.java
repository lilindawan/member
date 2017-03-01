package com.member.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ConsumeInfo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal member_id;
	private String consume_money;
	private String consume_remarks;
	private Date consume_date;
	
	public BigDecimal getMember_id() {
		return member_id;
	}
	public void setMember_id(BigDecimal member_id) {
		this.member_id = member_id;
	}
	public String getConsume_money() {
		return consume_money;
	}
	public void setConsume_money(String consume_money) {
		this.consume_money = consume_money;
	}
	public String getConsume_remarks() {
		return consume_remarks;
	}
	public void setConsume_remarks(String consume_remarks) {
		this.consume_remarks = consume_remarks;
	}
	public Date getConsume_date() {
		return consume_date;
	}
	public void setConsume_date(Date consume_date) {
		this.consume_date = consume_date;
	}

	
}