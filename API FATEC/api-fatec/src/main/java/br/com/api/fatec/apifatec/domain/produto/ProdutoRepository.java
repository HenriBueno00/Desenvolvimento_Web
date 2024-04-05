package br.com.api.fatec.apifatec.domain.produto;

import br.com.api.fatec.apifatec.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
