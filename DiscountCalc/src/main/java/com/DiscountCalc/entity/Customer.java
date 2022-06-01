package com.DiscountCalc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String CustName;
	private String type;
	private int amount;
	private int discount;
	private int saving;
	private int finalPrice;
	
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getSaving() {
		return saving;
	}
	public void setSaving(int saving) {
		this.saving = saving;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getType() {
		return type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
	public Customer(int id, String custName, String type, int amount, int discount, int saving, int finalPrice) {
		super();
		this.id = id;
		CustName = custName;
		this.type = type;
		this.amount = amount;
		this.discount = discount;
		this.saving = saving;
		this.finalPrice = finalPrice;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", CustName=" + CustName + ", type=" + type + ", amount=" + amount + ", discount="
				+ discount + ", saving=" + saving + ", finalPrice=" + finalPrice + "]";
	}
	
	
	
	
}
