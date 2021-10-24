package com.co.store.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.store.models.entity.User;
import com.co.store.models.service.IUserService;

/**
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
@Controller
@RequestMapping("/private")
public class PrivateController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/index")
	public String index(Authentication auth,HttpSession session) {
		String username = auth.getName();
		if(session.getAttribute("user") == null) {
			User user = userService.findByUsername(username);
			user.setPassword(null);
			session.setAttribute("user", user);
		} 
		return "index";
	}
}
