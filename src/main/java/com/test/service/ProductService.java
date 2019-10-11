package com.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.model.Product;

import java.util.Optional;

/**
 * @author miarjona
 *
 */
public interface ProductService {

	/**
	 * This method obtain the Product object from id parameter
	 * 
	 * @param id
	 * @return the product object
	 */
	public Optional<Product> findById(Long id);

	/**
	 * This method obtain all products paginated
	 * 
	 * @param pageable
	 * @return the paginated list
	 */
	public Page<Product> findAllProductsPageable(Pageable pageable);

}
