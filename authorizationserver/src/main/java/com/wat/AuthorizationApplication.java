package com.wat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Hello world!
 */
@SpringBootApplication
public class AuthorizationApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(AuthorizationApplication.class,args);
    }



}
