package com.DiscountCalc.securityOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.DiscountCalc.entity.Manager;
import com.DiscountCalc.repo.ManagerRepo;
import com.DiscountCalc.service.ManagerService;

public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private ManagerService managerService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Manager manager = managerService.getbyID(username);
		
		 if (manager==null) {
			throw new UsernameNotFoundException("username is null");
		}
		 
		 CustomUserDetails customUserDetails = new CustomUserDetails(manager);
		return customUserDetails;
	}

}
