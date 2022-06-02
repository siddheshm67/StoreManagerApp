package com.DiscountCalc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiscountCalc.entity.Customer;
import com.DiscountCalc.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer saveCustomer(Customer customer ) {
		
		Customer customer2 = customerRepo.save(customer);
		
		
		return customer2;
	}
	
	public List<Customer> getAll(){
		
		List<Customer> list = customerRepo.findAll();
		
		return list;
	}
	
	public int sumOfamt(int id) {
		int sumofAmount = customerRepo.sumofAmount(id);
		
		return sumofAmount;
	}
	
	public int sumOfFinalamt(int id) {
		
		int sumofFinalAmt = customerRepo.sumofFinalAmt(id);
		
		return sumofFinalAmt;
	}
	
	public int sumOfDiscount(int id) {
		
		int sumofDicount = customerRepo.sumofDicount(id);
		
		return sumofDicount;
	}
	
	public List<Customer> findByManagerId(int id){
		
		List<Customer> list = customerRepo.FindByManagerId(id);
		
		return list;
	}
	
	
}
