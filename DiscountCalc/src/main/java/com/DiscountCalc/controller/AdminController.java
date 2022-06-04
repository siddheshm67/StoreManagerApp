package com.DiscountCalc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DiscountCalc.entity.Manager;
import com.DiscountCalc.service.ManagerService;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/")
	public String AdminDashboard(Model model) {
		
		List<Manager> managers = managerService.getAllManagers();
		model.addAttribute("list", managers);
		
		int totalSum = managerService.totalSum();
		
		model.addAttribute("sumOfFinalamt", totalSum);
		return"admin";
	}
	
	@RequestMapping("/deleteManager/{id}")
	public String DeleteManager(@PathVariable("id") int id) {
		
		managerService.delteManager(id);
		
		return"redirect:/Admin/";
	}
	
}
