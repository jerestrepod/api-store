package com.co.store.models.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.store.models.dao.IProductDAO;
import com.co.store.models.entity.Product;
import com.co.store.models.service.IProductService;
import com.co.store.utils.Constants;

/**
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
@Service
public class IProductServiceImpl implements IProductService {

	@Autowired
	private IProductDAO productDao;

	@Override
	public List<Product> allProducts() {
		return productDao.findAll();
	}

	@Override
	public String addProduct(Long productId) {
		Optional<Product> optionalProduct = productDao.findById(productId);
		
		if(optionalProduct.isPresent()) {			
			Product updateProduct = optionalProduct.get();
			if(updateProduct.getStock() <= 0) {
				return Constants.NO_STOCK_PRODUCT;
			}
			updateProduct.setStock(updateProduct.getStock() - 1);
			updateProduct.setInShoppingCar(1);
			productDao.save(updateProduct);
			return Constants.ADD_PRODUCT_OK;
		} else {
			return Constants.NOT_FOUND_PRODUCT;
		}
		
	}
	
	@Override
	public String removeProduct(Long productId) {
		Optional<Product> optionalProduct = productDao.findById(productId);
		
		if(optionalProduct.isPresent()) {			
			Product updateProduct = optionalProduct.get();
			if(updateProduct.getInShoppingCar() == 0) {
				return Constants.NO_PRODUCT_IN_SHOPPING_CAR;
			}
			updateProduct.setStock(updateProduct.getStock() + 1);
			updateProduct.setInShoppingCar(0);
			productDao.save(updateProduct);
			return Constants.REMOVE_PRODUCT_OK;
		} else {
			return Constants.NOT_FOUND_PRODUCT;
		}
		
	}
	
	@Override
	public Product updateProduct(Product product) {
		Optional<Product> optionalProduct = productDao.findById(product.getIdProduct());
		
		if(optionalProduct.isPresent()) {			
			Product updateProduct = optionalProduct.get();
			
			updateProduct.setBrand(product.getBrand());
			updateProduct.setInShoppingCar(product.getInShoppingCar());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setProductName(product.getProductName());
			updateProduct.setStock(product.getStock());
			return productDao.save(updateProduct);
		} else {
			return null;
		}
		
	}

}
