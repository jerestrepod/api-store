package com.co.store.models.service;

import java.util.List;

import com.co.store.models.entity.Product;

/**
 * 
 * @author  Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
public interface IProductService {	
	
	
	/**
	 * @return
	 */
	public List<Product> allProducts();
	
	/**
	 * @param product
	 * @return
	 */
	public String addProduct(Long product);
	
	/**
	 * @param product
	 * @return
	 */
	public Product updateProduct(Product product);
	
	
	/**
	 * @param product
	 * @return
	 */
	public Product registerProduct(Product product);
	
	
	/**
	 * @param product
	 * @return
	 */
	public String removeProduct(Long product);
}
