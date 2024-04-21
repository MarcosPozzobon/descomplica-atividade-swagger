package com.marcos.desenvolvimento.backendkanbanagile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BackendKanbanAgileApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendKanbanAgileApplication.class, args);
		log.info("APLICAÇÃO INICIADA COM SUCESSO!");
	}
}
