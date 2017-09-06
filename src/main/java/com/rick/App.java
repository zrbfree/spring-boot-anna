package com.rick;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.rick.generator.mapper","com.rick.apps.mapper"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
