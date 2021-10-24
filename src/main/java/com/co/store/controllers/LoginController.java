package com.co.store.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.co.store.models.entity.User;
import com.co.store.models.service.IUserService;

/**
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
@Controller
public class LoginController {

	@Autowired
	private IUserService userService;
	
	/**
	 * GET method use to go to login page and use security config from spring-security
	 * @param model
	 * @return
	 */
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	/**
	 * GET method use to go to register page and use security config from spring-security
	 * @param model
	 * @return
	 */
	@GetMapping("/auth/register")
	public String registerForm(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	/**
	 * POST method use for redirect to register or login page and begin persist proccess
	 * @param model
	 * @return
	 */
	@PostMapping("/auth/register")
	public String register(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "redirect:/auth/register";
		} else {
			model.addAttribute("user", userService.registerUser(user)); 
		}
		return "redirect:/auth/login";
	}
}
