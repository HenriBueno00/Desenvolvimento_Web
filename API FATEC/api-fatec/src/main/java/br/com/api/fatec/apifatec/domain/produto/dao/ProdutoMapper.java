package br.com.api.fatec.apifatec.domain.produto.dao;

import br.com.api.fatec.apifatec.domain.produto.ProdutoDTO;
import br.com.api.fatec.apifatec.entities.Produto;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produto.setAtivo(dto.isAtivo());
        return produto;
    }

    public static ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        dto.setAtivo(produto.isAtivo());
        return dto;
    }
}
