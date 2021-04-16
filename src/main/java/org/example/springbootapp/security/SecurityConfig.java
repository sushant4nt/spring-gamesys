package org.example.springbootapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("stuart")
//                .password(passwordEncoder().encode("password"))
//                .roles("ADMIN")
//                .and()
//                .withUser("dave")
//                .password(passwordEncoder().encode("evad"))
//                .roles("USER");
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Use basic authentication (credentials in the Authorization header)
        http.httpBasic();

        // Don't send JSESSIONID
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Request-level authorisation
        http.authorizeRequests().antMatchers("/authenticated").access("isAuthenticated()");

        http.authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN");

        http.authorizeRequests().antMatchers("/stuart").access("principal.username eq 'stuart'");
    }
}
