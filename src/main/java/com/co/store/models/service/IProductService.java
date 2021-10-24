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
	 * get all the products
	 * @return
	 */
	public List<Product> allProducts();
	
	/**
	 * add the product to the shopping car, adding 1 to the inShoppingCar field
	 * and subtracting 1 to the stock field, when stock is 0 return an error message
	 * same when not found product otherwise return ok message.
	 * @param product
	 * @return
	 */
	public String addProduct(Long product);
	
	/**
	 * update product from entity request product
	 * @param product
	 * @return
	 */
	public Product updateProduct(Product product);
	
	
	/**
	 * persist product entity
	 * @param product
	 * @return
	 */
	public Product registerProduct(Product product);
	
	
	/**
	 * remove the product from the shopping car, subtracting 1 to the inShoppingCar field
	 * and adding 1 to the stock field, when inShoppingCar is 0 return an error message
	 * same when not found product otherwise return ok message.
	 * @param product
	 * @return
	 */
	public String removeProduct(Long product);
}
