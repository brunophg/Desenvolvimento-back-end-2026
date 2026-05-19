package org.api.partida;

import io.swagger.v3.oas.annotations.Operation;
import org.dao.JogadorDao;
import org.dao.JogoDao;
import org.dao.PartidaDao;
import org.dto.partida.PartidaRequest;
import org.dto.partida.PartidaResponse;
import org.model.Jogador;
import org.model.Jogo;
import org.model.Partida;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaDao partidaDao;
    private final JogadorDao jogadorDao;
    private final JogoDao jogoDao;

    public PartidaController(PartidaDao partidaDao, JogadorDao jogadorDao, JogoDao jogoDao) {
        this.partidaDao = partidaDao;
        this.jogadorDao = jogadorDao;
        this.jogoDao = jogoDao;
    }

    @GetMapping
    public List<PartidaResponse> listarTodos() {
        return partidaDao.findAll()
                .stream()
                .map(PartidaResponse::fromEntity)
                .toList();
    }
    @GetMapping("/{id}")
    public PartidaResponse buscarPorId(@PathVariable long id) {
        Partida partida = partidaDao.findById(id);
        if (partida == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada");
        }
        return PartidaResponse.fromEntity(partida);
    }
    @GetMapping("/next-id")
    public long proximoId() {
        return partidaDao.nextId();
    }
    @PostMapping
    public ResponseEntity<PartidaResponse> criar (@RequestBody PartidaRequest request) {
        Partida partida = request.toEntity();
        if (request.id() == null) {
            partida.setId(partidaDao.nextId());
        }
        Jogador jogador = jogadorDao.findById(request.idJogador());
        Jogo jogo = jogoDao.findById(request.idJogo());

        if (jogador == null || jogo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id do Jogador ou do Jogo invalido");
        }
        partida.setJogador(jogador);
        partida.setJogo(jogo);

        Partida partidaCriada = partidaDao.create(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(PartidaResponse.fromEntity(partidaCriada));
    }

    @PostMapping("/update")
    public PartidaResponse atualizar(@RequestBody PartidaRequest request) {
        if (request.id() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id obrigatorio para atualização");
        }

        Partida partida = request.toEntity();
        Jogador jogador = jogadorDao.findById(request.idJogador());
        Jogo jogo = jogoDao.findById(request.idJogo());

        if (jogador == null || jogo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id do Jogador ou do Jogo invalido");
        }
        partida.setJogador(jogador);
        partida.setJogo(jogo);

        return PartidaResponse.fromEntity(partidaDao.update(request.toEntity()));
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> removerPorId(@PathVariable long id) {
        if (!partidaDao.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida nao encontrada");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/delete-all")
    public int removerTodos() {
        return 0;
    }


}
