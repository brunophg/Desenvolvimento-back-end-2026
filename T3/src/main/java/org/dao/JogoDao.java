package org.dao;

import jakarta.persistence.EntityManager;
import org.model.Jogo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// DAO responsável pelas operações CRUD da entidade Jogo.
@Repository
public class JogoDao {

    private static final AtomicLong ID_SEQ = new AtomicLong(4000L);
    private EntityManager entityManager;

    // Cria um novo jogo
    public Jogo create(Jogo jogo) {
        entityManager.persist(jogo);
        return jogo;
    }

    // Busca um Jogo pelo ID.
    public Jogo findById(long id) {
        return entityManager.find(Jogo.class, id);
    }

    // Lista todos os Jogos.
    public List<Jogo> findAll() {
        return entityManager.createQuery("from Jogo", Jogo.class).getResultList();
    }

    // Atualiza os dados de um Jogos.
    public Jogo update(Jogo Jogo) {
        return entityManager.merge(Jogo);
    }

    // Remove um Jogo pelo ID e informa se a remoção ocorreu.
    public boolean deleteById(long id) {
        Jogo Jogo = entityManager.find(Jogo.class, id);
        if (Jogo == null) {
            return false;
        }
        entityManager.remove(Jogo);
        return true;
    }

    // Remove todos os Jogos e retorna a quantidade apagada.
    public int deleteAll() {
        return entityManager.createQuery("delete from Jogo").executeUpdate();
    }

    // Retorna o próximo ID sequencial.
    public long nextId() {
        return ID_SEQ.incrementAndGet();
    }
}

