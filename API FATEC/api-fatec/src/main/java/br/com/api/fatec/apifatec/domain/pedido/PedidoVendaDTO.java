package br.com.api.fatec.apifatec.domain.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.api.fatec.apifatec.domain.cliente.ClienteDTO;

public class PedidoVendaDTO {
    private Long id;
    private ClienteDTO cliente;
    private LocalDate emissao;
    private BigDecimal total;
    private String status;
    private List<PedidoVendaItemDTO> itens;

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

    public LocalDate getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDate emissao) {
        this.emissao = emissao;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PedidoVendaItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<PedidoVendaItemDTO> itens) {
        this.itens = itens;
    }
}
