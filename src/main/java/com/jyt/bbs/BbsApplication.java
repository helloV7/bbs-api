package com.jyt.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@ServletComponentScan
@MapperScan("com.jyt.bbs.dao")
@SpringBootApplication
public class BbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbsApplication.class, args);
	}
}
