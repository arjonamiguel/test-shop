package com.test.service;

import java.math.BigDecimal;
import java.util.Map;

import com.test.exception.NotEnoughProductsInStockException;
import com.test.model.Product;

/**
 * @author miarjona
 *
 */
public interface ShoppingCartService {

    public void addProduct(Product product);

    public void removeProduct(Product product);

    public Map<Product, Integer> getProductsInCart();

    public void checkout() throws NotEnoughProductsInStockException;

    public BigDecimal getTotal();
}
