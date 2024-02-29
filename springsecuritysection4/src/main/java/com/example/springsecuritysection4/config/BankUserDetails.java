package com.example.springsecuritysection4.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecuritysection4.model.Customer;
import com.example.springsecuritysection4.repository.CustomerRepository;

@Service
public class BankUserDetails implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		String userName = null, password = null;
		List<GrantedAuthority> authorities = null;
		
		List<Customer> customer = customerRepository.findByEmail(username);
		
		if(customer.size() == 0) {
			throw new UsernameNotFoundException("Customer user not found: "+username);
		}
		password = customer.get(0).getPwd();
		userName = customer.get(0).getEmail();
		authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority (customer.get(0).getRole()));
		
		
		return new User(userName, password, authorities);
	}

}
