package br.com.api.fatec.apifatec.domain.pedido;

import java.util.List;

import br.com.api.fatec.apifatec.domain.cliente.ClienteDTO;

public class PedidoDTO {
    private Long id;
    private ClienteDTO cliente;
    private String dataPedido;
    private String status;
    private List<ItemPedidoDTO> itensPedido;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemPedidoDTO> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
