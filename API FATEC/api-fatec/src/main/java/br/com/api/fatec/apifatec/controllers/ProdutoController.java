package br.com.api.fatec.apifatec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.api.fatec.apifatec.domain.produto.ProdutoDTO;
import br.com.api.fatec.apifatec.domain.produto.ProdutoService;
import br.com.api.fatec.apifatec.entities.Produto;
import br.com.api.fatec.apifatec.domain.produto.ProdutoMapper;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        List<ProdutoDTO> produtosDTO = ProdutoMapper.toDTOList(produtos);
        return new ResponseEntity<>(produtosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> encontrarProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.encontrarProdutoPorId(id);
        if (produto != null) {
            ProdutoDTO produtoDTO = ProdutoMapper.toDTO(produto);
            return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        Produto produtoCriado = produtoService.salvarProduto(produto);
        ProdutoDTO produtoCriadoDTO = ProdutoMapper.toDTO(produtoCriado);
        return new ResponseEntity<>(produtoCriadoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produtoExistente = produtoService.encontrarProdutoPorId(id);
        if (produtoExistente != null) {
            Produto produto = ProdutoMapper.toEntity(produtoDTO);
            produto.setId(id);
            Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
            ProdutoDTO produtoAtualizadoDTO = ProdutoMapper.toDTO(produtoAtualizado);
            return new ResponseEntity<>(produtoAtualizadoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        Produto produtoExistente = produtoService.encontrarProdutoPorId(id);
        if (produtoExistente != null) {
            produtoService.deletarProduto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
