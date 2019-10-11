package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Product;

import java.util.Optional;

/**
 * @author miarjona
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
