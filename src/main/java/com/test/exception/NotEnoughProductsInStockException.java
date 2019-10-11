package com.test.exception;

import com.test.model.Product;

/**
 * @author miarjona
 *
 */
@SuppressWarnings("serial")
public class NotEnoughProductsInStockException extends Exception {

	/**
	 * Static message used in the class parent
	 */
	private static final String NOT_ENOUGH_MESSAGE = "Not enough products in stock";

	/**
	 * Constructor method, this class extends from Exception class
	 */
	public NotEnoughProductsInStockException() {
		super(NOT_ENOUGH_MESSAGE);
	}

	/**
	 * This method is a custom of product exception
	 * 
	 * @param product
	 */
	public NotEnoughProductsInStockException(Product product) {
		super(String.format("Not enough %s products in stock. Only %d left", product.getName(), product.getQuantity()));
	}

}
