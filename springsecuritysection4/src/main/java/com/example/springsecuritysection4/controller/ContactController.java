package com.example.springsecuritysection4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	@GetMapping("/contacts")
	public String getContactDetals() {
		return ("Inquiry Details are saved to the DB");
	}
}
