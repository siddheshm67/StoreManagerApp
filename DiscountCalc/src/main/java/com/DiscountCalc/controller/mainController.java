package com.DiscountCalc.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DiscountCalc.entity.Customer;
import com.DiscountCalc.entity.Manager;
import com.DiscountCalc.repo.CustomerRepo;
import com.DiscountCalc.service.CustomerService;
import com.DiscountCalc.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class mainController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ManagerService managerService;
		
	@RequestMapping("/home")
	public String home(HttpSession session) {
		session.setAttribute("message", "show");
		return"home";
	}
	
	@RequestMapping(value = "/calculate",method = RequestMethod.POST)
	public String calc( @ModelAttribute Customer customer,Model model,HttpSession session,Principal principal) {
		System.out.println("customer***"+customer);
		int amt = customer.getAmount();
	
		String type = customer.getType();
		Manager manager = managerService.getbyID(principal.getName());
		
		if (type.equals("Premium")) {
			int[] arr = checkPremium(amt);
			model.addAttribute("mrp",amt);
			model.addAttribute("dicount_rs", arr[0]);
			model.addAttribute("dicount_percentage", arr[2]);
			model.addAttribute("finalamt", arr[1]);
			model.addAttribute("message", "true");
			System.out.println("premium****");
			
			Customer customer2 = new Customer();
			customer2.setAmount(amt);
			customer2.setCustName(customer.getCustName());
			customer2.setDiscount(arr[2]);
			customer2.setFinalPrice(arr[1]);
			customer2.setSaving(arr[0]);
			customer2.setType(type);
			customer2.setManager(manager);
			
			customerService.saveCustomer(customer2);
			session.setAttribute("message", "show");
			
			
			return"home";
	
		}
		
		else {
			
			int[] arr = checkRegular(amt);
			model.addAttribute("mrp",amt);
			model.addAttribute("dicount_rs", arr[0]);
			model.addAttribute("dicount_percentage", arr[2]);
			model.addAttribute("finalamt", arr[1]);
			model.addAttribute("message", "true");
			System.out.println(amt);
			System.out.println("regular****");
			
			Customer customer2 = new Customer();
			customer2.setAmount(amt);
			customer2.setCustName(customer.getCustName());
			customer2.setDiscount(arr[2]);
			customer2.setFinalPrice(arr[1]);
			customer2.setSaving(arr[0]);
			customer2.setType(type);
			customer2.setManager(manager);
			
			customerService.saveCustomer(customer2);
			session.setAttribute("message", "show");
			
			return"home";
		}
		
		
		
	}

	private int[] checkRegular(int amt) {
		
		int ans[] = new int[3];
		if (amt<5000) {
			ans[0]= amt;
			ans[1]= amt;
			ans[2] = 0;
		}
		if (amt>=5000 && amt<=10000) {
			ans[0]= amt*10/100;
			ans[1] = amt-ans[0];
			ans[2] = 10;
			
		}
		if (amt>=10000) {
			ans[0]= amt*20/100;
			ans[1] = amt-ans[0];
			ans[2] = 20;
		}
		
		return ans;
	}
	
	private int[] checkPremium(int amt) {
		
		int ans[] = new int[3];
		
		if (amt<4000) {
			ans[0]= amt*10/100;
			ans[1] = amt-ans[0];
			ans[2] = 10;
		}
		
		if (amt>=4000 && amt<8000) {
			ans[0] = amt*15/100;
			ans[1] = amt-ans[0];
			ans[2] = 15;
		}
		
		if (amt>=8000 && amt<12000) {
			ans[0] = amt*20/100;
			ans[1] = amt-ans[0];
			ans[2] = 20;
		}
		
		if (amt>=12000 ) {
			ans[0]= amt*30/100;
			ans[1] = amt-ans[0];
			ans[2] = 30;
		}
		
		return ans;
	}
	
	@RequestMapping("/dash")
	public String dash(Model model,Principal principal,HttpSession session) {
		
		Manager manager = managerService.getbyID(principal.getName());
		
		int sumofAmount = customerService.sumOfamt(manager.getId());
		int sumOfDiscount = customerService.sumOfDiscount(manager.getId());
		int sumOfFinalamt = customerService.sumOfFinalamt(manager.getId());
		
		model.addAttribute("totalSalesAmt", sumofAmount);
		
		model.addAttribute("name", manager.getNameString());
		model.addAttribute("userid", manager.getUseridString());
		model.addAttribute("sumOfDiscount", sumOfDiscount);
		model.addAttribute("sumOfFinalamt", sumOfFinalamt);
		System.out.println(manager.getId());
		
		int sale = managerService.setTotalSale(manager.getId(), sumOfFinalamt);
		
		System.out.println(sale);
		
		List<Customer> list = customerService.getAll();
		List<Customer> list2 = customerService.findByManagerId(manager.getId());
		model.addAttribute("list", list2);
		session.setAttribute("message", "show");
		
		return"dash";
	}
	
	
	
	
}
