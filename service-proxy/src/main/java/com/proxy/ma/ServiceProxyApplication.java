package com.proxy.ma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.proxy.ma.filters.AbcFilter;
import com.proxy.ma.filters.ErrorFilter;
import com.proxy.ma.filters.PostFilter;
import com.proxy.ma.filters.PreFilter;
import com.proxy.ma.filters.RouteFilter;


@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient

public class ServiceProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProxyApplication.class, args);
	}
	
	@Bean
	public AbcFilter abcfilter()
	{
		return new AbcFilter();
	}
	
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
	
	
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
