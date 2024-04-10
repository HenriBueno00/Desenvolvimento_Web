package br.com.api.fatec.apifatec.controllers;

import java.util.List;

import br.com.api.fatec.apifatec.domain.produto.ProdutoService;
import br.com.api.fatec.apifatec.domain.produto.ProdutoMapper;
import br.com.api.fatec.apifatec.domain.produto.ProdutoDTO;
import br.com.api.fatec.apifatec.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> produtos = ProdutoMapper.toDTOList(produtoService.listarProdutos());
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        Produto produtoCriado = produtoService.criarProduto(produto);
        ProdutoDTO produtoCriadoDTO = ProdutoMapper.toDTO(produtoCriado);
        return new ResponseEntity<>(produtoCriadoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> encontrarProdutoPorId(@PathVariable Long id) {
        ProdutoDTO produto = ProdutoMapper.toDTO(produtoService.encontrarProdutoPorId(id));
        return produto != null ? new ResponseEntity<>(produto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        ProdutoDTO produtoCriado = ProdutoMapper.toDTO(produtoService.criarProduto(produto));
        return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        ProdutoDTO produtoAtualizado = ProdutoMapper.toDTO(produtoService.atualizarProduto(id, produto));
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}