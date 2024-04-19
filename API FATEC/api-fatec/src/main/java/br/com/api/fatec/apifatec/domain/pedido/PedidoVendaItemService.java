package br.com.api.fatec.apifatec.domain.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.fatec.apifatec.entities.PedidoVendasItens;

import java.util.List;

@Service
public class PedidoVendaItemService {

    @Autowired
    private PedidoVendaItemRepository pedidoVendaItemRepository;

    public List<PedidoVendasItens> listarItensPedidoVenda() {
        return pedidoVendaItemRepository.findAll();
    }

    public PedidoVendasItens encontrarItemPedidoVendaPorId(Integer id) {
        return pedidoVendaItemRepository.findById(id).orElse(null);
    }

    public PedidoVendasItens salvarItemPedidoVenda(PedidoVendasItens itemPedidoVenda) {
        return pedidoVendaItemRepository.save(itemPedidoVenda);
    }

    public void deletarItemPedidoVenda(Integer id) {
        pedidoVendaItemRepository.deleteById(id);
    }
}
