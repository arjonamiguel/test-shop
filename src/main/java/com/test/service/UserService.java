package com.test.service;

import java.util.Optional;

import com.test.model.User;

/**
 * @author miarjona
 *
 */
public interface UserService {

    public Optional<User> findByUsername(String username);

    public Optional<User> findByEmail(String email);

    public User saveUser(User user);

}
