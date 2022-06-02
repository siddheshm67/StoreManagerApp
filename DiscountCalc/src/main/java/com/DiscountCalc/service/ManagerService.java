package com.DiscountCalc.service;

import java.util.List;

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
	
	public int setTotalSale(int a,int b) {
		int sales = managerRepo.setTotalSales(a, b);
		
		return sales;
	}
	
	public List<Manager> getAllManagers(){
		List<Manager> list = managerRepo.findAll();
		return list;
	}
	
	public int totalSum() {
		
		int sUm = managerRepo.TotalSUm();
		
		return sUm;
	}
	
}
