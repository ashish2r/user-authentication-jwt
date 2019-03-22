package com.ashish.usermgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ashish.usermgmt.model.User;
import com.ashish.usermgmt.repository.UserRepository;
import com.ashish.usermgmt.security.JwtUserFactory;


@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not correct.");
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
