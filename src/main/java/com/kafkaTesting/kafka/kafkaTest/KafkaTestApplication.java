package com.kafkaTesting.kafka.kafkaTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.kafkaTesting.kafka.kafkaTest")
@EnableAutoConfiguration
@SpringBootApplication
public class KafkaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTestApplication.class, args);
	}

}
