package br.com.api.fatec.apifatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.Produto;

@SpringBootApplication
public class ApiFatecApplication {
    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository clienteRepository, @Autowired ProdutoRepository produtoRepository) {
        return args -> {
            // Adicionando clientes
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

            // Adicionando produtos
            Produto produto1 = new Produto();
            produto1.setNome("Agua");
            produto1.setDescricao("Descrição do Produto 1");
            produto1.setPreco(10.0);
            produto1.setQuantidadeEstoque(100);

            produtoRepository.save(produto1);

            Produto produto2 = new Produto();
            produto2.setNome("Reefri");
            produto2.setDescricao("Descrição do Produto 2");
            produto2.setPreco(20.0);
            produto2.setQuantidadeEstoque(50);

            produtoRepository.save(produto2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiFatecApplication.class, args);
    }
}
