package com.dc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dc.mapper")
public class CaptchaLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaptchaLoginApplication.class, args);
	}

}
