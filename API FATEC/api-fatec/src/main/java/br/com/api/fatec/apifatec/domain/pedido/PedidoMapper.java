package br.com.api.fatec.apifatec.domain.pedido;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.fatec.apifatec.entities.Pedido;

public class PedidoMapper {

    public static Pedido toEntity(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setId(dto.getId());
        pedido.setCliente(ClienteMapper.toEntity(dto.getCliente()));
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setStatus(dto.getStatus());
        // Mapear lista de itens do pedido, se necessário
        // pedido.setItens(...);
        return pedido;
    }

    public static PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setCliente(ClienteMapper.toDTO(pedido.getCliente()));
        dto.setDataPedido(pedido.getDataPedido());
        dto.setStatus(pedido.getStatus());
        // Mapear lista de itens do pedido, se necessário
        // dto.setItensPedido(...);
        return dto;
    }

    public static List<PedidoDTO> toDTOList(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoMapper::toDTO).collect(Collectors.toList());
    }
}
