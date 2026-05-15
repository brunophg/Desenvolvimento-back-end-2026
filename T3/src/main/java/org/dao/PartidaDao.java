package org.dao;

import jakarta.persistence.EntityManager;
import org.model.Partida;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PartidaDao {
    private static final AtomicLong ID_SEQ = new AtomicLong(4000L);
    private EntityManager entityManager;

    // Cria um novo Partida
    public Partida create(Partida partida) {
        entityManager.persist(partida);
        return partida;
    }

    // Busca um Partida pelo ID.
    public Partida findById(long id) {
        return entityManager.find(Partida.class, id);
    }

    // Lista todos os Partidas.
    public List<Partida> findAll() {
        return entityManager.createQuery("from Partida", Partida.class).getResultList();
    }

    // Atualiza os dados de um Partida.
    public Partida update(Partida partida) {
        return entityManager.merge(partida);
    }

    // Remove um Partida pelo ID e informa se a remoção ocorreu.
    public boolean deleteById(long id) {
        Partida partida = entityManager.find(Partida.class, id);
        if (partida == null) {
            return false;
        }
        entityManager.remove(partida);
        return true;
    }

    // Retorna o próximo ID sequencial.
    public long nextId() {
        return ID_SEQ.incrementAndGet();
    }
}
