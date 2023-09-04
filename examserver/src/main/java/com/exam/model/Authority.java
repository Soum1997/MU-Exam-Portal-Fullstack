package com.exam.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private String authority;


    public Authority(String authority) {
        super();
        this.authority = authority;
    }



    //Spring security internally uses getAuthority() i.e simple string Ex: Admin,Normal..etc
    @Override
    public String getAuthority() {

        return this.authority;
    }

}
