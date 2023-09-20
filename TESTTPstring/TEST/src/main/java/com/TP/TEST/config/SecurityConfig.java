package com.TP.TEST.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http

                .authorizeHttpRequests((authz) -> authz

                        .requestMatchers("/user").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/**").hasAuthority("read")
                        .requestMatchers("/demo").hasAuthority("write")
                        .requestMatchers("smrh").access(new WebExpressionAuthorizationManager("isAuthenticated()"))
                        .anyRequest().authenticated()
                );
        http.csrf().ignoringRequestMatchers("/user");

      //  http
      //          .formLogin(form -> form
        //.loginPage("/login")
        //                .permitAll()
         //       );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder()
                .username("said")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(user);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}













