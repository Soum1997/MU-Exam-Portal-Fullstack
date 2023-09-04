package com.exam.service.impl;

import com.exam.model.User;
import com.exam.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //getting user from userRepository database
        User user = userRepository.findByUsername(username);

        if(user==null) {
            System.out.println("User not found with these credentials");
            throw new UsernameNotFoundException("Invalid Credentials i.e username for this user !!!!");
        }

        return user;
    }

}

