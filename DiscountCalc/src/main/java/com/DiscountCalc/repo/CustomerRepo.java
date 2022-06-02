package com.DiscountCalc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DiscountCalc.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query(value = "select sum(amount) from customer where manager_id=:userId",nativeQuery = true)
	int sumofAmount(@Param("userId") int userid);
	
	@Query(value = "select sum(saving) from customer where manager_id=:userId",nativeQuery = true)
	int sumofDicount(@Param("userId") int userid);
	
	@Query(value = "select sum(final_price) from customer where manager_id=:userId",nativeQuery = true)
	int sumofFinalAmt(@Param("userId") int userid);
	
	@Query("from Customer as c where c.manager.id =:userId")
	List<Customer>FindByManagerId(@Param("userId") int userid);
	
}
