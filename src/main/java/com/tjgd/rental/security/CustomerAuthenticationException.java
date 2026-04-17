package com.tjgd.rental.security;


// ✅ 应该继承：org.springframework.security.core.AuthenticationException
import org.springframework.security.core.AuthenticationException;

public class CustomerAuthenticationException  extends AuthenticationException {

    public CustomerAuthenticationException(String msg) {
        super(msg);
    }



}
