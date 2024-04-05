package br.com.api.fatec.apifatec.controllers;

import br.com.api.fatec.apifatec.domain.produto.ProdutoService;
import br.com.api.fatec.apifatec.domain.produto.ProdutoMapper;
import br.com.api.fatec.apifatec.domain.produto.ProdutoDTO;
import br.com.api.fatec.apifatec.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> encontrarProdutoPorId(@PathVariable Long id) {
        ProdutoDTO produto = ProdutoMapper.toDTO(produtoService.encontrarProdutoPorId(id));
        return produto != null ? new ResponseEntity<>(produto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        ProdutoDTO produtoSalvo = ProdutoMapper.toDTO(produtoService.salvarProduto(produto));
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produtoExistente = produtoService.encontrarProdutoPorId(id);
        if (produtoExistente != null) {
            produtoDTO.setId(id); // Garantindo que o ID seja o mesmo do produto existente
            Produto produtoAtualizado = ProdutoMapper.toEntity(produtoDTO);
            ProdutoDTO produtoAtualizadoDTO = ProdutoMapper.toDTO(produtoService.salvarProduto(produtoAtualizado));
            return new ResponseEntity<>(produtoAtualizadoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
