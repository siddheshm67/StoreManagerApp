package com.DiscountCalc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DiscountCalc.entity.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer>{
		
	Manager findByUseridString(String useridString) ;
	
}
