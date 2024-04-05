package br.com.api.fatec.apifatec.domain.produto;

import br.com.api.fatec.apifatec.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto encontrarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produtoExistente = encontrarProdutoPorId(id);
        if (produtoExistente != null) {
            produto.setId(id); 
            return produtoRepository.save(produto);
        } else {
            return null;
        }
    }
}
