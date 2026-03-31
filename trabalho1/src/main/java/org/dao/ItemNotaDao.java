package org.dao;

import jakarta.persistence.EntityManager;
import org.config.JpaConnection;
import org.model.ItemNota;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ItemNotaDao {
    private static final AtomicLong ID_SEQ = new AtomicLong(2000L);

    // Salva uma nova empresa.
    public ItemNota create(ItemNota itemNota) {
        return JpaConnection.executeInTransaction(entityManager -> {
            entityManager.persist(itemNota);
            return itemNota;
        });
    }

    // Busca uma empresa pelo ID.
    public ItemNota findById(long id) {
        EntityManager entityManager = JpaConnection.getEntityManager();
        try {
            return entityManager.find(ItemNota.class, id);
        } finally {
            entityManager.close();
        }
    }

    // Lista todos as empresas.
    public List<ItemNota> findAll() {
        EntityManager entityManager = JpaConnection.getEntityManager();
        try {
            return entityManager.createQuery("from Curso", ItemNota.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Atualiza os dados de uma empresa.
    public ItemNota update(ItemNota itemNota) {
        return JpaConnection.executeInTransaction(entityManager -> entityManager.merge(itemNota));
    }

    // Remove uma empresa pelo ID e informa se a remoção ocorreu.
    public boolean deleteById(long id) {
        return JpaConnection.executeInTransaction(entityManager -> {
            ItemNota itemNota = entityManager.find(ItemNota.class, id);
            if (itemNota == null) {
                return false;
            }
            entityManager.remove(itemNota);
            return true;
        });
    }

    // Remove todos as empresas e retorna a quantidade apagada.
    public int deleteAll() {
        return JpaConnection.executeInTransaction(entityManager ->
                entityManager.createQuery("delete from ItemNota").executeUpdate()
        );
    }

    // Retorna o próximo ID sequencial.
    public long nextId() {
        return ID_SEQ.incrementAndGet();
    }
}
