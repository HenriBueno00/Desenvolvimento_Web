package br.com.api.fatec.apifatec.domain.pedido;

import java.math.BigDecimal;

import br.com.api.fatec.apifatec.domain.produto.ProdutoDTO;

public class PedidoVendaItemDTO {
    private Long id;
    private ProdutoDTO produto;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
