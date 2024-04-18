package br.com.api.fatec.apifatec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.api.fatec.apifatec.domain.pedido.PedidoDTO;
import br.com.api.fatec.apifatec.domain.pedido.PedidoMapper;
import br.com.api.fatec.apifatec.domain.pedido.PedidoService;
import br.com.api.fatec.apifatec.entities.Pedido;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        List<PedidoDTO> pedidosDTO = PedidoMapper.toDTOList(pedidos);
        return new ResponseEntity<>(pedidosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> encontrarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.encontrarPedidoPorId(id);
        if (pedido != null) {
            PedidoDTO pedidoDTO = PedidoMapper.toDTO(pedido);
            return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = PedidoMapper.toEntity(pedidoDTO);
        Pedido pedidoCriado = pedidoService.salvarPedido(pedido);
        PedidoDTO pedidoCriadoDTO = PedidoMapper.toDTO(pedidoCriado);
        return new ResponseEntity<>(pedidoCriadoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedidoExistente = pedidoService.encontrarPedidoPorId(id);
        if (pedidoExistente != null) {
            Pedido pedido = PedidoMapper.toEntity(pedidoDTO);
            pedido.setId(id);
            Pedido pedidoAtualizado = pedidoService.atualizarPedido(id, pedido);
            PedidoDTO pedidoAtualizadoDTO = PedidoMapper.toDTO(pedidoAtualizado);
            return new ResponseEntity<>(pedidoAtualizadoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        Pedido pedidoExistente = pedidoService.encontrarPedidoPorId(id);
        if (pedidoExistente != null) {
            pedidoService.deletarPedido(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
