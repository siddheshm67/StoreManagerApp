package com.DiscountCalc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DiscountCalc.entity.Manager;
import com.DiscountCalc.service.ManagerService;

@Controller
public class HomeController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/front")
	public String Front() {
		
		return"front";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return"login";
	}
	
	@RequestMapping("/register")
	public String Register() {
		
		return"register";
	}
	
	@RequestMapping(value =  "/registerProcess" ,method = RequestMethod.POST)
	public String RegisterProcess(@ModelAttribute Manager manager,Model model,HttpSession session) {
		System.out.println(manager);
		Manager m1 = new Manager();
		m1.setNameString(manager.getNameString());
		m1.setUseridString(manager.getUseridString());
		m1.setGenderString(manager.getGenderString());
		m1.setMobilenoString(manager.getMobilenoString());
		m1.setPassString(manager.getPassString());
		m1.setRole("USER");
		Manager newManager = managerService.CreateNewManager(m1);
		session.setAttribute("message", "mr. "+newManager.getNameString()+" you are Successfully registred");
		return"register";
	}
}
