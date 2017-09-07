package com.hiwotab.daveslist;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws  Exception{
        auth.inMemoryAuthentication().
                withUser("seeker").password("password").roles("SEEKER")
                .and()
                .withUser("dave").password("begreat").roles("ADMIN")
                .and()
                .withUser("renter").password("password").roles("RENTER");
    }


    @Override
    protected void configure(HttpSecurity http)throws  Exception{

        http
                .authorizeRequests()
                .antMatchers("/")
                .access("hasRole('ROLE_SEEKER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_RENTER')")
                .antMatchers("/addOwnerInfo","/addRoomInfo","/dispAllRooms","/notRent","/Rent").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/notRent").access("hasRole('ROLE_SEEKER')")
                .antMatchers("/addRoomInfo").access("hasRole('ROLE_RENTER')")
                .antMatchers("/css/**","/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .httpBasic();


    }

}
