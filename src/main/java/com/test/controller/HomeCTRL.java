package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.Product;
import com.test.service.ProductService;
import com.test.util.Pager;

import java.util.Optional;

/**
 * @author miarjona
 *
 */
@Controller
public class HomeCTRL {
	/**
	 * The attributes are used as identify the URL of the page.
	 */
	private static final String HOME_PATH = "/home";

	/**
	 * Attribute indicate the first page number .
	 */
	private static final int FIRST_PAGE = 0;

	/**
	 * Attribute indicate the size the page.
	 */
	private static final int SIZE_PAGE = 6;

	/**
	 * Attribute indicate the service product
	 */
	private final ProductService productService;

	/**
	 * The constructor method, initialize the service object
	 * 
	 * @param productService
	 */
	@Autowired
	public HomeCTRL(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * This method show the main page, consulting the product list available
	 * 
	 * @param page
	 * @return The ModelAndView object
	 */
	@GetMapping(HOME_PATH)
	public ModelAndView home(@RequestParam("page") Optional<Integer> currentPage) {

		int selectedPage = (currentPage.orElse(0) < 1) ? FIRST_PAGE : currentPage.get() - 1;

		Page<Product> productsList = productService.findAllProductsPageable(new PageRequest(selectedPage, SIZE_PAGE));
		Pager pager = new Pager(productsList);

		ModelAndView model = new ModelAndView();
		model.addObject("products", productsList);
		model.addObject("pager", pager);
		model.setViewName(HOME_PATH);

		return model;
	}

}
