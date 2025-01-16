package com.amit.quizServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class QuizServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServerApplication.class, args);
	}

}
