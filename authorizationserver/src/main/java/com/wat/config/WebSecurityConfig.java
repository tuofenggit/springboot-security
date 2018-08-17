package com.wat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


/**
 * @Author: chuangwang8
 * @Date: 2018-08-16 16:33
 * @Description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *
     *
     * {@link AbstractAuthenticationFilterConfigurer } defaultSuccessUrl() 登录成功默认跳转url,框架默认策略
     *  successHandler(new MyLoginSucHandler(true, "/index123")) 可以自定义登录成功方案
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                antMatchers("/in").permitAll()
                .antMatchers("/index").hasRole("USER")
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().successHandler(new MyLoginSucHandler(true,"/index")).permitAll()
                .and()
                .logout().permitAll()
                .and().rememberMe().tokenValiditySeconds(60 *10)
                .and()
                .sessionManagement().maximumSessions(1).expiredUrl("/login");
               /* anyRequest().authenticated().
                and().
                formLogin().successHandler(new MyLoginSucHandler(true, "/index")).permitAll().
                and().rememberMe().tokenValiditySeconds(60 * 10).key("123").
                and().httpBasic().
                and().sessionManagement().maximumSessions(1).and().
                logout().logoutUrl("/login?logout").logoutSuccessUrl("/index").permitAll();*/
    }

  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub

        auth
                .inMemoryAuthentication().passwordEncoder(new MessageDigestPasswordEncoder("MD5"))
                .withUser("admin").password("123456").roles("USER")
                .and()
                .withUser("test").password("test123").roles("ADMIN");
    }*/

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("123456").roles("USER","ADMIN").build());
        return manager;
    }


}
