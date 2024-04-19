package br.com.api.fatec.apifatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.domain.pedido.PedidoRepository;
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.Produto;
import br.com.api.fatec.apifatec.entities.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class ApiFatecApplication {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Bean
    public CommandLineRunner run() {
        return args -> {
            // Adicionando clientes
            Cliente cliente1 = new Cliente();
            cliente1.setNome("Danilo");
            cliente1.setEmail("h2danilofatec@hotmail.com");
            cliente1.setEndereco("Rua xxx, 126");
            cliente1.setRazaoSocial("Danilo");

            clienteRepository.save(cliente1);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("João");
            cliente2.setEmail("joao@example.com");
            cliente2.setEndereco("Avenida Principal, 123");
            cliente2.setRazaoSocial("João LTDA");

            clienteRepository.save(cliente2);

            // Adicionando produtos
            Produto produto1 = new Produto();
            produto1.setNome("Água");
            produto1.setDescricao("Descrição do Produto 1");
            produto1.setPreco(BigDecimal.valueOf(10.0));
            produto1.setQuantidadeEstoque(100);

            produtoRepository.save(produto1);

            Produto produto2 = new Produto();
            produto2.setNome("Refrigerante");
            produto2.setDescricao("Descrição do Produto 2");
            produto2.setPreco(BigDecimal.valueOf(20.0));
            produto2.setQuantidadeEstoque(50);

            produtoRepository.save(produto2);

            // Adicionando pedidos
            Pedido pedido1 = new Pedido();
            pedido1.setCliente(cliente1);
            pedido1.setEmissao(LocalDate.now());
            pedido1.setTotal(BigDecimal.valueOf(50.0)); // Suponha que o pedido contenha 5 unidades do produto1 e 2 unidades do produto2
            pedido1.setStatus("Em andamento");

            pedidoRepository.save(pedido1);

            Pedido pedido2 = new Pedido();
            pedido2.setCliente(cliente2);
            pedido2.setEmissao(LocalDate.now());
            pedido2.setTotal(BigDecimal.valueOf(30.0)); // Suponha que o pedido contenha 3 unidades do produto1
            pedido2.setStatus("Concluído");

            pedidoRepository.save(pedido2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiFatecApplication.class, args);
    }
}
