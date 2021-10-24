package com.co.store;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.co.store.models.dao.IProductDAO;
import com.co.store.models.entity.Product;
import com.co.store.models.impl.IProductServiceImpl;
import com.co.store.utils.Constants;

@RunWith(MockitoJUnitRunner.class)
public class BusinessUnitTest {

	@Mock
	private IProductDAO productDao;

	@Mock
	private Product product;

	@InjectMocks
	private IProductServiceImpl productServiceImpl;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * test add product service implementation validating
	 * the state of stock product, product in shopping car,
	 * answer string of the method and call to the persistence. 
	 * When everything its ok.
	 */
	@Test
	public void addProductWhenIsInStock() {
		
		String brand = "samsung";
		Long idProduct = 123L;
		int inShoppinCar = 0;
		String price = "100usd";
		String productName = "tablet";
		int stock = 1;
		Product mockedProduct = new Product(idProduct, productName, brand, price, stock, inShoppinCar);		

		Optional<Product> optionalMockedProduct = Optional.of(mockedProduct);
		
		Mockito.when(productDao.findById(mockedProduct.getIdProduct())).thenReturn(optionalMockedProduct);
		
		String answer = productServiceImpl.addProduct(mockedProduct.getIdProduct());
		
		assertTrue(mockedProduct.getStock() == --stock);
		assertTrue(mockedProduct.getInShoppingCar() == ++inShoppinCar);
		assertTrue(answer.equals(Constants.ADD_PRODUCT_OK));
		verify(productDao, times(1)).save(mockedProduct);
	}
	
	/**
	 * test add product service implementation validating
	 * the state of stock product, product in shopping car,
	 * answer string of the method and call to the persistence. 
	 * When haven't stock product
	 */
	@Test
	public void addProductWhenNoStock() {
		
		String brand = "samsung";
		Long idProduct = 124L;
		int inShoppinCar = 0;
		String price = "100usd";
		String productName = "tablet";
		int stock = 0;
		Product mockedProduct = new Product(idProduct, productName, brand, price, stock, inShoppinCar);		

		Optional<Product> optionalMockedProduct = Optional.of(mockedProduct);
		
		Mockito.when(productDao.findById(mockedProduct.getIdProduct())).thenReturn(optionalMockedProduct);
		
		String answer = productServiceImpl.addProduct(mockedProduct.getIdProduct());
		
		assertTrue(mockedProduct.getStock() == stock);
		assertTrue(mockedProduct.getInShoppingCar() == inShoppinCar);
		assertTrue(answer.equals(Constants.NO_STOCK_PRODUCT));
		verify(productDao, times(0)).save(mockedProduct);
	}
	
	/**
	 * test add product service implementation validating
	 * the state of stock product, product in shopping car,
	 * answer string of the method and call to the persistence. 
	 * When not found product.
	 */
	@Test
	public void addProductWhenNotFoundProduct() {
		
		String brand = "samsung";
		Long idProduct = 125L;
		int inShoppinCar = 0;
		String price = "100usd";
		String productName = "tablet";
		int stock = 0;
		Product mockedProduct = new Product(idProduct, productName, brand, price, stock, inShoppinCar);		
		
		Optional<Product> optionalMockedProduct = Optional.ofNullable(null);
		Mockito.when(productDao.findById(mockedProduct.getIdProduct())).thenReturn(optionalMockedProduct);
		
		String answer = productServiceImpl.addProduct(mockedProduct.getIdProduct());
		
		assertTrue(mockedProduct.getStock() == stock);
		assertTrue(mockedProduct.getInShoppingCar() == inShoppinCar);
		assertTrue(answer.equals(Constants.NOT_FOUND_PRODUCT));
		verify(productDao, times(0)).save(mockedProduct);
	}
	
	/**
	 * test remove product service implementation validating
	 * the state of stock product, product in shopping car,
	 * answer string of the method and call to the persistence. 
	 * When everything its ok.
	 */
	@Test
	public void removeProductWhenIsInShoppingCar() {
		
		String brand = "samsung";
		Long idProduct = 126L;
		int inShoppinCar = 1;
		String price = "100usd";
		String productName = "tablet";
		int stock = 1;
		Product mockedProduct = new Product(idProduct, productName, brand, price, stock, inShoppinCar);		

		Optional<Product> optionalMockedProduct = Optional.of(mockedProduct);
		
		Mockito.when(productDao.findById(mockedProduct.getIdProduct())).thenReturn(optionalMockedProduct);
		
		String answer = productServiceImpl.removeProduct(mockedProduct.getIdProduct());
		
		assertTrue(mockedProduct.getStock() == ++stock);
		assertTrue(mockedProduct.getInShoppingCar() == --inShoppinCar);
		assertTrue(answer.equals(Constants.REMOVE_PRODUCT_OK));
		verify(productDao, times(1)).save(mockedProduct);
	}
	
	/**
	 * test remove product service implementation validating
	 * the state of stock product, product in shopping car,
	 * answer string of the method and call to the persistence. 
	 * When product isn't in shopping car.
	 */
	@Test
	public void removeProductWhenIsNotInShoppingCar() {
		
		String brand = "samsung";
		Long idProduct = 127L;
		int inShoppinCar = 0;
		String price = "100usd";
		String productName = "tablet";
		int stock = 1;
		Product mockedProduct = new Product(idProduct, productName, brand, price, stock, inShoppinCar);		

		Optional<Product> optionalMockedProduct = Optional.of(mockedProduct);
		
		Mockito.when(productDao.findById(mockedProduct.getIdProduct())).thenReturn(optionalMockedProduct);
		
		String answer = productServiceImpl.removeProduct(mockedProduct.getIdProduct());
		
		assertTrue(mockedProduct.getStock() == stock);
		assertTrue(mockedProduct.getInShoppingCar() == inShoppinCar);
		assertTrue(answer.equals(Constants.NO_PRODUCT_IN_SHOPPING_CAR));
		verify(productDao, times(0)).save(mockedProduct);
	}
	
	/**
	 * test remove product service implementation validating
	 * the state of stock product, product in shopping car,
	 * answer string of the method and call to the persistence. 
	 * When not found product.
	 */
	@Test
	public void removeProductWhenProductNotFound() {
		
		String brand = "samsung";
		Long idProduct = 128L;
		int inShoppinCar = 0;
		String price = "100usd";
		String productName = "tablet";
		int stock = 1;
		Product mockedProduct = new Product(idProduct, productName, brand, price, stock, inShoppinCar);			
		
		Optional<Product> optionalMockedProduct = Optional.ofNullable(null);
		
		Mockito.when(productDao.findById(mockedProduct.getIdProduct())).thenReturn(optionalMockedProduct);
		
		String answer = productServiceImpl.removeProduct(mockedProduct.getIdProduct());
		
		assertTrue(mockedProduct.getStock() == stock);
		assertTrue(mockedProduct.getInShoppingCar() == inShoppinCar);
		assertTrue(answer.equals(Constants.NOT_FOUND_PRODUCT));
		verify(productDao, times(0)).save(mockedProduct);
	}
}
