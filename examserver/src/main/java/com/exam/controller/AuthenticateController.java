package com.exam.controller;

import com.exam.config.JwtUtils;
import com.exam.model.*;
import com.exam.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.exam.model.JwtRequest;
import com.exam.model.JwtResponse;
import com.exam.service.impl.UserDetailsServiceImpl;
import com.exam.config.JwtUtils;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    //for generating user received from client
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken (@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        }catch(UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found");
        }catch(Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        //Above code is executed means user is authenticated
        //for getting user details by username
        UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        //for generating token for user by JwtUtil class method
        String token= this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }
    //for authenticating user received from the client
    private void authenticate(String username,String password) throws Exception {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }catch(DisabledException e) {
            e.printStackTrace();
            System.out.println("User Disabled");
        }
        catch(BadCredentialsException e) {
            e.printStackTrace();
            System.out.println("Bad Credentials");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
    }


}
