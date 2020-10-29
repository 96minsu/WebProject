package com.example.WebProject;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.Resource;

@Slf4j
@SpringBootApplication
public class WebProjectApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebProjectApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebProjectApplication.class, args);
		
		log.trace("Trace Level 테스트");
		log.debug("DEBUG Level 테스트");
		log.info("INFO Level 테스트");
		log.warn("WARN Level 테스트");
		log.error("ERROR Level 테스트");
		System.out.println("====== Server Started ======");
	}
	
}
