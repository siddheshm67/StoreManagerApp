package com.DiscountCalc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DiscountCalc.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query(value = "select sum(amount) from customer",nativeQuery = true)
	int sumofAmount();
	
	@Query(value = "select sum(saving) from customer",nativeQuery = true)
	int sumofDicount();
	
	@Query(value = "select sum(final_price) from customer",nativeQuery = true)
	int sumofFinalAmt();
	
}
