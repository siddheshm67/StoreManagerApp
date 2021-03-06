package com.DiscountCalc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ValueGenerationType;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String nameString;
	private String useridString;
	private String genderString;
	private String mobilenoString;
	private String passString;
	private String role;
	private int totalSales;
	
	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER,mappedBy = "manager",orphanRemoval = true)
	private List<Customer> customers = new ArrayList<>();
	
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getUseridString() {
		return useridString;
	}
	public void setUseridString(String useridString) {
		this.useridString = useridString;
	}
	public String getGenderString() {
		return genderString;
	}
	public void setGenderString(String genderString) {
		this.genderString = genderString;
	}
	public String getMobilenoString() {
		return mobilenoString;
	}
	public void setMobilenoString(String mobilenoString) {
		this.mobilenoString = mobilenoString;
	}
	public String getPassString() {
		return passString;
	}
	public void setPassString(String passString) {
		this.passString = passString;
	}
	public Manager(int id, String nameString, String useridString, String genderString, String mobilenoString,
			String passString, String role) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.useridString = useridString;
		this.genderString = genderString;
		this.mobilenoString = mobilenoString;
		this.passString = passString;
		this.role = role;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", nameString=" + nameString + ", useridString=" + useridString + ", genderString="
				+ genderString + ", mobilenoString=" + mobilenoString + ", passString=" + passString + ", role=" + role
				+ "]";
	}
	
	
	
	
	
	
	
	
}
