package br.com.api.fatec.apifatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.entities.Cliente;

@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository) {
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("Danilo");
			cliente.setEmail("h2danilofatec@hotmail.com");
			cliente.setEndereco("Rua xxx, 126");
			cliente.setRazaoSocial("Danilo");
			
			clienteRepository.save(cliente);
			
			Cliente cliente2 = new Cliente();
	        cliente2.setNome("João");
	        cliente2.setEmail("joao@example.com");
	        cliente2.setEndereco("Avenida Principal, 123");
	        cliente2.setRazaoSocial("João LTDA");

	        clienteRepository.save(cliente2);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}
}
