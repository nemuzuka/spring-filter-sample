package com.example.demo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityFilterConfiguration {

  @Bean
  @Order(1)
  public SecurityFilterChain hello1SecurityFilterChain(HttpSecurity http) throws Exception {
    http.securityMatcher("/api1/**")
        .authorizeHttpRequests(
            authorize ->
                authorize.requestMatchers("/api1/hello1").permitAll().anyRequest().authenticated());
    http.addFilterBefore(new BeforeAuthorizationFilter1(), AuthorizationFilter.class);
    return http.build();
  }

  @Bean
  @Order(2)
  public SecurityFilterChain hello2SecurityFilterChain(HttpSecurity http) throws Exception {
    http.securityMatcher("/api2/**")
        .authorizeHttpRequests(
            authorize ->
                authorize.requestMatchers("/api2/hello2").permitAll().anyRequest().authenticated());
    http.addFilterBefore(new BeforeAuthorizationFilter2(), AuthorizationFilter.class);
    return http.build();
  }

  @Slf4j
  static class BeforeAuthorizationFilter1 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
        HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
      log.info("called BeforeAuthorizationFilter1.");
      filterChain.doFilter(request, response);
    }
  }

  @Slf4j
  static class BeforeAuthorizationFilter2 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
        HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
      log.info("called BeforeAuthorizationFilter2.");
      filterChain.doFilter(request, response);
    }
  }
}
