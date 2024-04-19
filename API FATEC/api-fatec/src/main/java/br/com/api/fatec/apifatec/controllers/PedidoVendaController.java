package br.com.api.fatec.apifatec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.api.fatec.apifatec.domain.pedido.PedidoVendaDTO;
import br.com.api.fatec.apifatec.domain.pedido.PedidoVendaService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos-venda")
public class PedidoVendaController {

    @Autowired
    private PedidoVendaService pedidoVendaService;

    @GetMapping
    public ResponseEntity<List<PedidoVendaDTO>> listarPedidosVenda() {
        List<PedidoVendaDTO> pedidosVenda = pedidoVendaService.listarPedidosVenda();
        return new ResponseEntity<>(pedidosVenda, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoVendaDTO> encontrarPedidoVendaPorId(@PathVariable Long id) {
        PedidoVendaDTO pedidoVenda = pedidoVendaService.encontrarPedidoVendaPorId(id);
        if (pedidoVenda != null) {
            return new ResponseEntity<>(pedidoVenda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PedidoVendaDTO> criarPedidoVenda(@RequestBody PedidoVendaDTO pedidoVendaDTO) {
        PedidoVendaDTO novoPedidoVenda = pedidoVendaService.criarPedidoVenda(pedidoVendaDTO);
        return new ResponseEntity<>(novoPedidoVenda, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoVendaDTO> atualizarPedidoVenda(@PathVariable Long id, @RequestBody PedidoVendaDTO pedidoVendaDTO) {
        PedidoVendaDTO pedidoVendaAtualizado = pedidoVendaService.atualizarPedidoVenda(id, pedidoVendaDTO);
        if (pedidoVendaAtualizado != null) {
            return new ResponseEntity<>(pedidoVendaAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedidoVenda(@PathVariable Long id) {
        pedidoVendaService.deletarPedidoVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
