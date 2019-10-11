package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.model.User;
import com.test.repository.RoleRepository;
import com.test.repository.UserRepository;
import com.test.service.UserService;

import java.util.Collections;
import java.util.Optional;

/**
 * @author miarjona
 *
 */
@Service
public class UserServiceImp implements UserService {

	/**
	 * Attributes of layer repository
	 */
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	/**
	 * Attribute static identify role user
	 */
	private static final String USER_ROLE = "ROLE_USER";

	/**
	 * Constructor method
	 * 
	 * @param userRepository
	 * @param roleRepository
	 * @param passwordEncoder
	 */
	/**
	 * @param userRepository
	 * @param roleRepository
	 * @param passwordEncoder
	 */
	@Autowired
	public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	/* (non-Javadoc)
	 * @see com.reljicd.service.UserService#findByUsername(java.lang.String)
	 */
	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	/* (non-Javadoc)
	 * @see com.reljicd.service.UserService#findByEmail(java.lang.String)
	 */
	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/* (non-Javadoc)
	 * @see com.reljicd.service.UserService#saveUser(com.reljicd.model.User)
	 */
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActive(1);
		user.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));
		return userRepository.saveAndFlush(user);
	}
}
