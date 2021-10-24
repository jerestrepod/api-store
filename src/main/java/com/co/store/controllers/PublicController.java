package com.co.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
@Controller
@RequestMapping("/public")
public class PublicController {
	
	@GetMapping("/index")
	public String index() {
		return "logout";
	}

}
