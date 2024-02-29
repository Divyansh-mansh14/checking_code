package com.example.springsecuritysection4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
	
	@GetMapping("/myCards")
	public String getCardsDetails() {
		return ("Here are the Card details from the DB");
	}
}
