package br.com.api.fatec.apifatec.domain.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.fatec.apifatec.entities.PedidoVendas;

import java.util.List;

@Service
public class PedidoVendaService {

    @Autowired
    private PedidoVendaRepository pedidoVendaRepository;

    public List<PedidoVendas> listarPedidosVenda() {
        return pedidoVendaRepository.findAll();
    }

    public PedidoVendas encontrarPedidoVendaPorId(Long id) {
        return pedidoVendaRepository.findById(id).orElse(null);
    }

    public PedidoVendas salvarPedidoVenda(PedidoVendas pedidoVenda) {
        return pedidoVendaRepository.save(pedidoVenda);
    }

    public void deletarPedidoVenda(Long id) {
        pedidoVendaRepository.deleteById(id);
    }
}
