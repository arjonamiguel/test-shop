package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.model.Product;
import com.test.repository.ProductRepository;
import com.test.service.ProductService;

import java.util.Optional;

/**
 * @author miarjona
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	/**
	 * The attribute of service 
	 */
    private final ProductRepository productRepository;

    /**
     * Constructor method, initialize the object service
     * @param productRepository
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAllProductsPageable(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
