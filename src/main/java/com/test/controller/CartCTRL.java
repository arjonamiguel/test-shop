package com.test.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.test.exception.NotEnoughProductsInStockException;
import com.test.service.ProductService;
import com.test.service.ShoppingCartService;

/**
 * @author miarjona
 *
 */
@Controller
public class CartCTRL {

	/**
	 * The attributes are used as identify the URL of the page.
	 */
	private static final String CART_PATH = "/shoppingCart";
	private static final String ADD_PRODUCT_PATH = "/shoppingCart/addProduct/{productId}";
	private static final String REMOVE_PRODUCT_PATH = "/shoppingCart/removeProduct/{productId}";
	private static final String CHECKOUT_PATH = "/shoppingCart/checkout";

	/**
	 * this Attribute indicate the services for the cart
	 */
	private final ShoppingCartService cartService;
	/**
	 * Attribute indicate the service product
	 */
	private final ProductService productService;

	/**
	 * The constructor method, initialize the services object
	 * 
	 * @param cartService
	 * @param productService
	 */
	@Autowired
	public CartCTRL(ShoppingCartService cartService, ProductService productService) {
		this.cartService = cartService;
		this.productService = productService;
	}

	/**
	 * this method show the cart information, about the product selected previously
	 * 
	 * @return The model and view object
	 */
	@GetMapping(CART_PATH)
	public ModelAndView cart() {
		ModelAndView modelAndView = new ModelAndView(CART_PATH);
		BigDecimal total = cartService.getTotal();

		modelAndView.addObject("products", cartService.getProductsInCart());
		modelAndView.addObject("total", total != null ? total.toString() : 0);
		return modelAndView;
	}

	/**
	 * This method added the new product to shopping cart.
	 * 
	 * @param productId
	 * @return the model and view object
	 */
	@GetMapping(ADD_PRODUCT_PATH)
	public ModelAndView addProductToCart(@PathVariable("productId") Long productId) {
		productService.findById(productId).ifPresent(cartService::addProduct);
		return cart();
	}

	/**
	 * This method remove the product from cart
	 * 
	 * @param productId
	 * @return The model and view object
	 */
	@GetMapping(REMOVE_PRODUCT_PATH)
	public ModelAndView removeProductFromCart(@PathVariable("productId") Long productId) {
		productService.findById(productId).ifPresent(cartService::removeProduct);
		return cart();
	}

	/**
	 * This method validate the product stock
	 * 
	 * @return The model and view object
	 */
	@GetMapping(CHECKOUT_PATH)
	public ModelAndView checkout() {
		try {
			cartService.checkout();
		} catch (NotEnoughProductsInStockException e) {
			return cart().addObject("outOfStockMessage", e.getMessage());
		}
		return cart();
	}
}
