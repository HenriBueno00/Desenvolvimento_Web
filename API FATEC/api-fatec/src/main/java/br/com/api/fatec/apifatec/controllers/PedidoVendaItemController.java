package br.com.api.fatec.apifatec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.api.fatec.apifatec.domain.pedido.PedidoVendaItemDTO;
import br.com.api.fatec.apifatec.domain.pedido.PedidoVendaItemService;

import java.util.List;

@RestController
@RequestMapping("/api/pedido-venda-items")
public class PedidoVendaItemController {

    @Autowired
    private PedidoVendaItemService pedidoVendaItemService;

    @GetMapping
    public ResponseEntity<List<PedidoVendaItemDTO>> listarPedidoVendaItems() {
        List<PedidoVendaItemDTO> pedidosVendaItems = pedidoVendaItemService.listarPedidoVendaItems();
        return new ResponseEntity<>(pedidosVendaItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoVendaItemDTO> encontrarPedidoVendaItemPorId(@PathVariable Long id) {
        PedidoVendaItemDTO pedidoVendaItem = pedidoVendaItemService.encontrarPedidoVendaItemPorId(id);
        if (pedidoVendaItem != null) {
            return new ResponseEntity<>(pedidoVendaItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PedidoVendaItemDTO> criarPedidoVendaItem(@RequestBody PedidoVendaItemDTO pedidoVendaItemDTO) {
        PedidoVendaItemDTO novoPedidoVendaItem = pedidoVendaItemService.criarPedidoVendaItem(pedidoVendaItemDTO);
        return new ResponseEntity<>(novoPedidoVendaItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoVendaItemDTO> atualizarPedidoVendaItem(@PathVariable Long id, @RequestBody PedidoVendaItemDTO pedidoVendaItemDTO) {
        PedidoVendaItemDTO pedidoVendaItemAtualizado = pedidoVendaItemService.atualizarPedidoVendaItem(id, pedidoVendaItemDTO);
        if (pedidoVendaItemAtualizado != null) {
            return new ResponseEntity<>(pedidoVendaItemAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedidoVendaItem(@PathVariable Long id) {
        pedidoVendaItemService.deletarPedidoVendaItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
