package com.co.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
@Controller
public class InitController {
	
	/**
	 * GET method for init the app, just redirect for the root page 
	 * that have navegation option -- login -- register
	 * @return
	 */
	@GetMapping("/")
	public String start() {
		return "start";
	}
}
