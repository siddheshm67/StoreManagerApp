package com.DiscountCalc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.DiscountCalc.entity.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer>{
		
	Manager findByUseridString(String useridString) ;
	
	@Transactional
	@Modifying
	@Query(value = "update Manager m set m.total_sales=:amt WHERE m.id =:id",nativeQuery = true)
	int setTotalSales(int id,int amt);
	
	@Query(value = "select sum(total_sales) from manager",nativeQuery = true)
	int TotalSUm();
	
}
