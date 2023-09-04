package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;

public interface UserService {

    //posting user to database
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //getting user from database
    public User getUser(String userName);

    //delete user from database
    public void deleteUser(Long userId);



}
