package org.api.inventario;

import org.dao.InventarioDao;
import org.dao.ItemDao;
import org.dao.JogadorDao;
import org.dto.inventario.InventarioRequest;
import org.dto.inventario.InventarioResponse;
import org.model.Inventario;
import org.model.Item;
import org.model.Jogador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioDao inventarioDao;
    private final JogadorDao jogadorDao;
    private final ItemDao itemDao;

    public InventarioController(InventarioDao inventarioDao, JogadorDao jogadorDao, ItemDao itemDao) {
        this.inventarioDao = inventarioDao;
        this.jogadorDao = jogadorDao;
        this.itemDao = itemDao;
    }

    @GetMapping
    public List<InventarioResponse> listarTodos() {
        return inventarioDao.findAll()
                .stream()
                .map(InventarioResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public InventarioResponse buscarPorId(@PathVariable long id) {
        Inventario inventario = inventarioDao.findById(id);
        if (inventario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de inventario invalido");
        }
        return InventarioResponse.fromEntity(inventario);
    }

    @GetMapping("/next-id")
    public long proximoId() {
        return inventarioDao.nextId();
    }

    @PostMapping
    public ResponseEntity<InventarioResponse> criar(@RequestBody InventarioRequest request) {
        Inventario inventario = request.toEntity();
        if (request.id() == null) {
            inventario.setId(inventarioDao.nextId());
        }
        Jogador jogador = jogadorDao.findById(request.idJogador());
        Item item = itemDao.findById(request.idItem());

        if (jogador == null || item == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id do Jogador ou do Item invalido");
        }
        inventario.setJogador(jogador);
        inventario.setItem(item);

        Inventario inventario1 = inventarioDao.create(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(InventarioResponse.fromEntity(inventario1));
    }

    @PostMapping("/update")
    public InventarioResponse atualizar(@RequestBody InventarioRequest request) {
        if (request.id() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id obrigatorio para atualização");
        }

        Inventario inventario = request.toEntity();
        Jogador jogador = jogadorDao.findById(request.idJogador());
        Item item = itemDao.findById(request.idItem());

        if (jogador == null || item == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id do Jogador ou do Item invalido");
        }
        inventario.setJogador(jogador);
        inventario.setItem(item);

        return InventarioResponse.fromEntity(inventarioDao.update(request.toEntity()));
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> removerPorId(@PathVariable long id) {
        if (!inventarioDao.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventario nao encontrado");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/delete-all")
    public int removerTodos() {
        return 0;
    }
}
