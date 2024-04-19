package br.com.api.fatec.apifatec.domain.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.fatec.apifatec.entities.Produto;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto encontrarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        } else {
            return null;
        }
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
}
