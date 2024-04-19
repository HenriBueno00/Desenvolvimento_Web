package br.com.api.fatec.apifatec.domain.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.fatec.apifatec.entities.PedidoVendasItens;

@Repository
public interface PedidoVendaItemRepository extends JpaRepository<PedidoVendasItens, Integer> {
    // Você pode adicionar métodos personalizados de consulta aqui, se necessário
}
