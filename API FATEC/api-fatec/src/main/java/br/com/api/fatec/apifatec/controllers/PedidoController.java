import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        List<PedidoDTO> pedidos = pedidoService.listarPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> encontrarPedidoPorId(@PathVariable Long id) {
        PedidoDTO pedido = pedidoService.encontrarPedidoPorId(id);
        return pedido != null ?
                new ResponseEntity<>(pedido, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedidoCriado = pedidoService.criarPedido(pedidoDTO);
        return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedidoAtualizado = pedidoService.atualizarPedido(id, pedidoDTO);
        return pedidoAtualizado != null ?
                new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/itens")
    public ResponseEntity<PedidoDTO> adicionarItemPedido(@PathVariable Long id, @RequestBody ItemPedidoDTO itemPedidoDTO) {
        PedidoDTO pedidoAtualizado = pedidoService.adicionarItemPedido(id, itemPedidoDTO);
        return pedidoAtualizado != null ?
                new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idPedido}/itens/{idItem}")
    public ResponseEntity<PedidoDTO> removerItemPedido(@PathVariable Long idPedido, @PathVariable Long idItem) {
        PedidoDTO pedidoAtualizado = pedidoService.removerItemPedido(idPedido, idItem);
        return pedidoAtualizado != null ?
                new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
