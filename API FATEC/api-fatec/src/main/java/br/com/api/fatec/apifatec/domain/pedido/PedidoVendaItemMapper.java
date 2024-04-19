package br.com.api.fatec.apifatec.domain.pedido;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.fatec.apifatec.entities.PedidoVendasItens;

public class PedidoVendaItemMapper {
    public static PedidoVendasItens toEntity(PedidoVendaItemDTO dto) {
    	PedidoVendasItens item = new PedidoVendasItens();
        item.setId(dto.getId());
        item.setQuantidade(dto.getQuantidade());
        item.setValorUnitario(dto.getValorUnitario());
        item.setValorTotal(dto.getValorTotal());
        // Mapeie o pedidoVenda e o produto, se necessário
        // item.setPedidoVenda(...);
        // item.setProduto(...);
        return item;
    }

    public static PedidoVendaItemDTO toDTO(PedidoVendasItens item) {
        PedidoVendaItemDTO dto = new PedidoVendaItemDTO();
        dto.setId(item.getId());
        dto.setQuantidade(item.getQuantidade());
        dto.setValorUnitario(item.getValorUnitario());
        dto.setValorTotal(item.getValorTotal());
        // Mapeie o pedidoVenda e o produto, se necessário
        // dto.setPedidoVenda(...);
        // dto.setProduto(...);
        return dto;
    }

    public static List<PedidoVendaItemDTO> toDTOList(List<PedidoVendasItens> itens) {
        return itens.stream().map(PedidoVendaItemMapper::toDTO).collect(Collectors.toList());
    }
}
