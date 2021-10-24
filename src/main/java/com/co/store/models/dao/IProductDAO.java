
package com.co.store.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.store.models.entity.Product;

/**
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
public interface IProductDAO extends JpaRepository<Product, Long>{
	
}
