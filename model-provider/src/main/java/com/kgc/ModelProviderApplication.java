package com.kgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.kgc.dao")
@ImportResource("classpath:spring-provider.xml")
public class ModelProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelProviderApplication.class, args);
	}

}
