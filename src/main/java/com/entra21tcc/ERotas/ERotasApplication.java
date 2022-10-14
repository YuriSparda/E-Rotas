package com.entra21tcc.ERotas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.entra21tcc.ERotas.entities.Address;
import com.entra21tcc.ERotas.entities.Client;
import com.entra21tcc.ERotas.repositories.ClientRepository;

@SpringBootApplication
public class ERotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERotasApplication.class, args);
	}

	public Address end;

	@Bean
	public CommandLineRunner demo(ClientRepository ClientRep) {
		return (args) -> {
			ClientRep.save(new Client(null, "Marcos", "123456", "marcos@gmail.com", "000.000.000-00",
					end = new Address(1234, "rua", "estado", "cidade", "bairro", 01,
							"complemento")));
			ClientRep.save(new Client(null, "Pedro", "654321", "pedro@gmail.com", "000.000.000-00",
					end = new Address(1234, "rua", "estado", "cidade", "bairro", 02,
							"complemento")));
			ClientRep.save(new Client(null, "Tiago", "123654", "thiago@gmail.com", "000.000.000-00",
					end = new Address(1234, "rua", "estado", "cidade", "bairro", 03,
							"complemento")));
			ClientRep.save(new Client(null, "Yurii", "321456", "yuri@gmail.com", "000.000.000-00",
					end = new Address(1234, "rua", "estado", "cidade", "bairro", 04,
							"complemento")));
			ClientRep.save(new Client(null, "Wellington", "142536", "narguilé@gmail.com", "000.000.000-00",
					end = new Address(1234, "rua", "estado", "cidade", "bairro", 05,
							"complemento")));
		};
	}
}
