package br.com.api.fatec.apifatec.domain.pedido;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.fatec.apifatec.domain.cliente.ClienteMapper;
import br.com.api.fatec.apifatec.entities.PedidoVendas;

public class PedidoVendaMapper {
    public static PedidoVendas toEntity(PedidoDTO dto) {
    	PedidoVendas pedido = new PedidoVendas();
        pedido.setId(dto.getId());
        pedido.setCliente(ClienteMapper.toEntity(dto.getCliente()));
        pedido.setEmissao(dto.getEmissao());
        pedido.setTotal(dto.getTotal());
        pedido.setStatus(dto.getStatus());
        // Mapeie os items, se necessário
        // pedido.setItems(dto.getItems().stream().map(PedidoVendaItemMapper::toEntity).collect(Collectors.toList()));
        return pedido;
    }

    public static PedidoDTO toDTO(PedidoVendas pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setCliente(ClienteMapper.toDTO(pedido.getCliente()));
        dto.setEmissao(pedido.getEmissao());
        dto.setTotal(pedido.getTotal());
        dto.setStatus(pedido.getStatus());
        // Mapeie os items, se necessário
        // dto.setItems(PedidoVendaItemMapper.toDTOList(pedido.getItems()));
        return dto;
    }

    public static List<PedidoDTO> toDTOList(List<PedidoVendas> pedidos) {
        return pedidos.stream().map(PedidoVendaMapper::toDTO).collect(Collectors.toList());
    }
}
