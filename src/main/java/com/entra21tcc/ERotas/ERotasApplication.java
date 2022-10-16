package com.entra21tcc.ERotas;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.entra21tcc.ERotas.entities.Address;
import com.entra21tcc.ERotas.entities.Client;
import com.entra21tcc.ERotas.entities.Order;
import com.entra21tcc.ERotas.entities.stts;
import com.entra21tcc.ERotas.repositories.ClientRepository;
import com.entra21tcc.ERotas.repositories.OrderRepository;

@SpringBootApplication
public class ERotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERotasApplication.class, args);
	}

	@Autowired
	private ClientRepository ClientRep;
	@Autowired
	private OrderRepository ordersRep;

	@Bean
	public CommandLineRunner demo(Address end) {

		Client u1 = new Client(null, "Marcos", "123456", "marcos@gmail.com", "000.000.000-00",
				end = new Address(1234, "rua", "estado", "cidade", "bairro", 01,
						"complemento"));
		Client u2 = new Client(null, "Pedro", "654321", "pedro@gmail.com", "000.000.000-00",
				end = new Address(1234, "rua", "estado", "cidade", "bairro", 02,
						"complemento"));
		Client u3 = new Client(null, "Tiago", "123654", "thiago@gmail.com", "000.000.000-00",
				end = new Address(1234, "rua", "estado", "cidade", "bairro", 03,
						"complemento"));
		Client u4 = new Client(null, "Yurii", "321456", "yuri@gmail.com", "000.000.000-00",
				end = new Address(1234, "rua", "estado", "cidade", "bairro", 04,
						"complemento"));
		Client u5 = new Client(null, "Wellington", "142536", "narguilé@gmail.com", "000.000.000-00",
				end = new Address(1234, "rua", "estado", "cidade", "bairro", 05,
						"complemento"));
		return (args) -> {
			ClientRep.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
			ordersRep.save(new Order(null, Instant.parse("2019-06-20T19:53:07Z"), null, u1, null, stts.SHIPPED));
			ordersRep.save(new Order(null, Instant.parse("2019-07-21T03:42:10Z"), null, u2, null, stts.DELIVERED));
			ordersRep.save(
					new Order(null, Instant.parse("2019-07-22T15:21:22Z"), null, u3, null, stts.DELIVERED));
		};
	}
}
