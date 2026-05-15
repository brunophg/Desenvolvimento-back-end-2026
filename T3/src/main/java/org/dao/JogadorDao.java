package org.dao;

import jakarta.persistence.EntityManager;
import org.model.Jogador;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class JogadorDao {

    private static final AtomicLong ID_SEQ = new AtomicLong(4000L);
    private EntityManager entityManager;

    // Cria um novo jogador
    public Jogador create(Jogador jogador) {
        entityManager.persist(jogador);
        return jogador;
    }

    // Busca um Jogador por ID
    public Jogador findById(long id) {
        return entityManager.find(Jogador.class, id);
    }

    // Lista todos os Jogadores.
    public List<Jogador> findAll() {
        return entityManager.createQuery("from Jogador", Jogador.class).getResultList();
    }

    // Atualiza os dados de um Jogador.
    public Jogador update(Jogador jogador) {
        return entityManager.merge(jogador);
    }

    // Remove um Item pelo ID e informa se a remoção ocorreu.
    public boolean deleteById(long id) {
        Jogador jogador = entityManager.find(Jogador.class, id);
        if (jogador == null) {
            return false;
        }
        entityManager.remove(jogador);
        return true;
    }

    // Retorna o próximo ID sequencial.
    public long nextId() {
        return ID_SEQ.incrementAndGet();
    }


}
