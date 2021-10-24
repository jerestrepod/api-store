package com.co.store.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.store.models.entity.Product;
import com.co.store.models.entity.User;
import com.co.store.models.service.IProductService;
import com.co.store.models.service.IUserService;
import com.co.store.utils.Constants;

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
	
	@Autowired
	private IProductService productService;
	
	/**
	 * GET method that is reach when login process is success use security config from spring-security
	 * @param auth
	 * @param session
	 * @return
	 */
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
	
	/**
	 * Get method bring all products in db
	 * @return
	 */
	@GetMapping("/allProducts")
	public ResponseEntity<List<Product>> allProducts() {
		return ResponseEntity.ok(productService.allProducts());
	}
	
	/**
	 * Put method get a product id, add this to count in shopping car and decrease this to stock product
	 * @param productId
	 * @return
	 */
	@PutMapping(value="/addProduct/{productId}")
	public ResponseEntity<String> addProduct(@PathVariable("productId") Long productId) {
		String result = productService.addProduct(productId);
		if(result.equals(Constants.NOT_FOUND_PRODUCT)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}
	
	/**
	 * Put method get a product id, decrease this to  in shopping car and count this to stock product
	 * @param productId
	 * @return
	 */
	@PutMapping(value="/removeProduct/{productId}")
	public ResponseEntity<String> removeProduct(@PathVariable("productId") Long productId) {
		String result = productService.removeProduct(productId);
		if(result.equals(Constants.NOT_FOUND_PRODUCT)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}
	
	/**
	 * Just update the specified product
	 * @param product
	 * @return
	 */
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product result = productService.updateProduct(product);
		if(result == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}
}
