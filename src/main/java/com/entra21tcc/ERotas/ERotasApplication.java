package com.entra21tcc.ERotas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.entra21tcc.ERotas.entities.Client;
import com.entra21tcc.ERotas.repositories.ClientRepository;

@SpringBootApplication
public class ERotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERotasApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientRepository ClientRep) {
		return (args) -> {
			ClientRep.save(new Client(null, "Marcos", null, null, null, null));
			ClientRep.save(new Client(null, "Pedro", null, null, null, null));
			ClientRep.save(new Client(null, "Tiago", null, null, null, null));
			ClientRep.save(new Client(null, "Yurii", null, null, null, null));
			ClientRep.save(new Client(null, "Wellington", null, null, null, null));
		};
	}
}
