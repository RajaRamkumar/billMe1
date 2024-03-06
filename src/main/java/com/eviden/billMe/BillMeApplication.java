package com.eviden.billMe;

import com.eviden.billMe.entity.Post;
import com.eviden.billMe.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BillMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillMeApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(PostRepository postRepository) {
		return args -> {
			postRepository.save(new Post("Test","Test Data","Test Content"));
		};
	}
*/
}
