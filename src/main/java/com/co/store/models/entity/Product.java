package com.co.store.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an user.
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
/**
 * @author desarrollo4
 *
 */
@Entity
@Table(name = "products")
public class Product implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * auto generated id for products
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	/**
	 * represent product name
	 */
	private String productName;
	/**
	 * brand of product
	 */
	private String brand;
	/**
	 * price of product
	 */
	private String price;
	/**
	 * stock of the product
	 */
	private int stock;
	
	/**
	 * represent if the product is selected in the shopping car or not 1 - 0
	 */
	private int inShoppingCar;
	
	/**
	 * @return the idProduct
	 */
	public Long getIdProduct() {
		return idProduct;
	}
	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * @return the inShoppingCar
	 */
	public int getInShoppingCar() {
		return inShoppingCar;
	}
	/**
	 * @param inShoppingCar the inShoppingCar to set
	 */
	public void setInShoppingCar(int inShoppingCar) {
		this.inShoppingCar = inShoppingCar;
	}
	
	
}
