package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @author miarjona
 *
 */
@Controller
public class LoginCTRL {
	/**
	 * The attributes are used as identify the URL of the page or redirect path.
	 */
	private static final String LOGIN_PATH = "/login";
	private static final String REDIRECT_HOME_PATH = "redirect:/home";

	/**
	 * This method is used when the user need complete the buy or navigate with mode
	 * logged.
	 * 
	 * @param principal
	 * @return The main page
	 */
	@GetMapping(LOGIN_PATH)
	public String login(Principal principal) {
		if (principal != null) {
			return REDIRECT_HOME_PATH;
		}
		return LOGIN_PATH;
	}

}
