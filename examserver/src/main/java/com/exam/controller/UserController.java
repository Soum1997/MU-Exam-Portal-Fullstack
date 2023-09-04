package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;


    //adding user data to database
    @PostMapping("/")
    public User CreateUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();

        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        roles.add(userRole);

//		userService.createUser(user, userRoles);

        return this.userService.createUser(user, roles);

//		return "Sucess ..";
    }

//    getting user from Database

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String userName) {

        return this.userService.getUser(userName);
    }

    //delete user by Id
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }

}

