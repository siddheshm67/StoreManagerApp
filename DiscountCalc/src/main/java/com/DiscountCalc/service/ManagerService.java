package com.DiscountCalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiscountCalc.entity.Manager;
import com.DiscountCalc.repo.ManagerRepo;

@Service
public class ManagerService{
	
	@Autowired
	private ManagerRepo managerRepo;
	
	public Manager CreateNewManager(Manager manager) {
		
		Manager nManager = managerRepo.save(manager);
		
		return nManager;
	}
	
	public Manager getbyID(String userid) {
		
		Manager manager = managerRepo.findByUseridString(userid);
		
		return manager;
	}
	
}
