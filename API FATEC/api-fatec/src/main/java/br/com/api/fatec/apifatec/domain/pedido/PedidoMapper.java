import br.com.api.fatec.apifatec.domain.cliente.ClienteMapper;
import br.com.api.fatec.apifatec.domain.produto.ProdutoMapper;
import br.com.api.fatec.apifatec.entities.Pedido;
import br.com.api.fatec.apifatec.domain.pedido.PedidoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {
    public static Pedido toEntity(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setId(dto.getId());
        pedido.setCliente(ClienteMapper.toEntity(dto.getCliente()));
        pedido.setDataPedido(dto.getDataPedido());
        // Outros campos do pedido podem ser mapeados aqui
        return pedido;
    }

    public static PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setCliente(ClienteMapper.toDTO(pedido.getCliente()));
        dto.setDataPedido(pedido.getDataPedido());
        // Outros campos do DTO podem ser mapeados aqui
        return dto;
    }

    public static List<PedidoDTO> toDTOList(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoMapper::toDTO).collect(Collectors.toList());
    }
}
