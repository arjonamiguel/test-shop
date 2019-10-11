package com.test.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author miarjona
 *
 */
@RestController
public class ErrorCTRL implements ErrorController {

	/**
	 * Attribute used as redirect page.
	 */
	private static final String ERROR_PATH = "/error";
	private static final String FORBIDDEN_PATH = "/403";

	/**
	 * This method is used when the page obtain a error.
	 * 
	 * @return the model and view redirect to the page
	 */
	@RequestMapping(ERROR_PATH)
	public ModelAndView error() {
		return new ModelAndView(ERROR_PATH);
	}

	/**
	 * This method is used when return a forbidden action
	 * 
	 * @return
	 */
	@GetMapping(FORBIDDEN_PATH)
	public ModelAndView error403() {
		return new ModelAndView(FORBIDDEN_PATH);
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
