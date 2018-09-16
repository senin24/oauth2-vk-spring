package com.github.senin24.memasik.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.senin24.memasik.web.domain.User;
import com.github.senin24.memasik.web.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class WebApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("Jack", "bauer"));
			repository.save(new User("Chloe", "brian"));
			repository.save(new User("Kim", "bauer"));
			repository.save(new User("David", "palmer"));
			repository.save(new User("Michelle", "dessler"));
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(user -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(user.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findBylogin('bauer'):");
			log.info("--------------------------------------------");
			repository.findByLogin("bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	
}
