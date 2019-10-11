package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.User;
import com.test.service.UserService;

import javax.validation.Valid;

/**
 * @author miarjona
 *
 */
@Controller
public class RegistrationCTRL {

	private static final String REGISTRATION_PATH = "/registration";
	private static final String ALREADY_EMAIL_MESSAGE = "There is already a user registered with the email provided";
	private static final String ALREADY_USERNAME_MESSAGE = "There is already a user registered with the username provided";
	private static final String REGISTERED_SUCCESS_MESSAGE = "User has been registered successfully";

	/**
	 * This attribute indicate the services for the user
	 */
	private final UserService userService;

	/**
	 * The constructor method, initialize the user service object
	 * 
	 * @param userService
	 */
	@Autowired
	public RegistrationCTRL(UserService userService) {
		this.userService = userService;
	}

	/**
	 * This method is used for the registration process.
	 * 
	 * @return the model an d view object
	 */
	@RequestMapping(value = REGISTRATION_PATH, method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName(REGISTRATION_PATH);
		return model;
	}

	/**
	 * This method is used in the creation of new user
	 * 
	 * @param user
	 * @param bindingResult
	 * @return The model and view object
	 */
	@RequestMapping(value = REGISTRATION_PATH, method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {

		if (userService.findByEmail(user.getEmail()).isPresent()) {
			bindingResult.rejectValue("email", "error.user", ALREADY_EMAIL_MESSAGE);
		}
		if (userService.findByUsername(user.getUsername()).isPresent()) {
			bindingResult.rejectValue("username", "error.user", ALREADY_USERNAME_MESSAGE);
		}

		ModelAndView model = new ModelAndView();

		if (bindingResult.hasErrors()) {
			model.setViewName(REGISTRATION_PATH);
		} else {
			userService.saveUser(user);

			model.addObject("successMessage", REGISTERED_SUCCESS_MESSAGE);
			model.addObject("user", new User());
			model.setViewName(REGISTRATION_PATH);
		}
		return model;
	}
}
