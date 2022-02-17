package com.jbk.springbootCRUDEx;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCruDappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCruDappApplication.class, args);
	}

	@Bean
	@Qualifier("book1Bean")
	public Book book1() {
		System.out.println("From Book 1 object");
		Book bk1= new Book();
		return bk1;
	}
	@Bean
	@Qualifier("book2")
	public Book book2() {
		System.out.println("From Book 2 ------object");
		Book bk2= new Book();
		return bk2;
	}
}
