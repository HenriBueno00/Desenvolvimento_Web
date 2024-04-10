import br.com.api.fatec.apifatec.domain.cliente.ClienteService;
import br.com.api.fatec.apifatec.domain.produto.ProdutoService;
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.ItemPedido;
import br.com.api.fatec.apifatec.entities.Pedido;
import br.com.api.fatec.apifatec.entities.Produto;
import br.com.api.fatec.apifatec.domain.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    private final ProdutoService produtoService;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido encontrarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido salvarPedido(Pedido pedido) {
        // Verifique se o cliente associado ao pedido existe
        Cliente cliente = clienteService.encontrarClientePorId(pedido.getCliente().getId());
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado para o ID fornecido");
        }

        // Verifique se os produtos associados aos itens do pedido existem e atualize os preços
        for (ItemPedido item : pedido.getItens()) {
            Produto produto = produtoService.encontrarProdutoPorId(item.getProduto().getId());
            if (produto == null) {
                throw new IllegalArgumentException("Produto não encontrado para o ID fornecido: " + item.getProduto().getId());
            }
            item.setProduto(produto);
            item.setPrecoUnitario(produto.getPreco());
        }

        // Calcule o total do pedido
        double total = pedido.getItens().stream().mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade()).sum();
        pedido.setTotal(total);

        // Salve o pedido
        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
