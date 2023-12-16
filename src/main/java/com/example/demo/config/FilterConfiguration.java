package com.example.demo.config;

import com.example.demo.filter.HighestPlusOnePrecedenceFilter;
import com.example.demo.filter.HighestPrecedenceFilter;
import com.example.demo.filter.LowestMinusOnePrecedenceFilter;
import com.example.demo.filter.LowestPrecedenceFilter;
import com.example.demo.filter.OrderNegative101Filter;
import com.example.demo.filter.OrderNegative99Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfiguration {
  @Bean
  public FilterRegistrationBean<HighestPrecedenceFilter> highestPrecedenceFilter() {
    var registrationBean = new FilterRegistrationBean<HighestPrecedenceFilter>();
    var filter = new HighestPrecedenceFilter();
    registrationBean.setFilter(filter);
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<HighestPlusOnePrecedenceFilter> highestPlusOnePrecedenceFilter() {
    var registrationBean = new FilterRegistrationBean<HighestPlusOnePrecedenceFilter>();
    var filter = new HighestPlusOnePrecedenceFilter();
    registrationBean.setFilter(filter);
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<LowestMinusOnePrecedenceFilter> lowestMinusOnePrecedenceFilter() {
    var registrationBean = new FilterRegistrationBean<LowestMinusOnePrecedenceFilter>();
    var filter = new LowestMinusOnePrecedenceFilter();
    registrationBean.setFilter(filter);
    registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE - 1);
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<LowestPrecedenceFilter> lowestPrecedenceFilter() {
    var registrationBean = new FilterRegistrationBean<LowestPrecedenceFilter>();
    var filter = new LowestPrecedenceFilter();
    registrationBean.setFilter(filter);
    registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<OrderNegative99Filter> orderNegative99Filter() {
    var registrationBean = new FilterRegistrationBean<OrderNegative99Filter>();
    var filter = new OrderNegative99Filter();
    registrationBean.setFilter(filter);
    registrationBean.setOrder(-99);
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<OrderNegative101Filter> orderNegative101Filter() {
    var registrationBean = new FilterRegistrationBean<OrderNegative101Filter>();
    var filter = new OrderNegative101Filter();
    registrationBean.setFilter(filter);
    registrationBean.setOrder(-101);
    return registrationBean;
  }
}
