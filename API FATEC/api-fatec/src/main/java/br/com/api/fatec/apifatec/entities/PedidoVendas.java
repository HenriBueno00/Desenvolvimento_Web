package br.com.api.fatec.apifatec.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.api.fatec.apifatec.shared.enums.PedidoVendaStatusEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "pedido_venda")
public class PedidoVendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "emissao")
    private LocalDate emissao;

    @Column(precision = 20, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private PedidoVendaStatusEnum status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoVenda", orphanRemoval = true)
    private List<PedidoVendasItens> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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

    public PedidoVendaStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PedidoVendaStatusEnum status) {
        this.status = status;
    }

    public List<PedidoVendasItens> getItems() {
        return items;
    }

    public void setItems(List<PedidoVendasItens> items) {
        this.items = items;
    }
}

