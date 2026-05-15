package org.dao;

import jakarta.persistence.EntityManager;
import org.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemDao {
    private static final AtomicLong ID_SEQ = new AtomicLong(4000L);
    private EntityManager entityManager;

    // Cria um novo Item
    public Item create(Item item) {
        entityManager.persist(item);
        return item;
    }

    // Busca um Item pelo ID.
    public Item findById(long id) {
        return entityManager.find(Item.class, id);
    }

    // Lista todos os Items.
    public List<Item> findAll() {
        return entityManager.createQuery("from Item", Item.class).getResultList();
    }

    // Atualiza os dados de um Item.
    public Item update(Item item) {
        return entityManager.merge(item);
    }

    // Remove um Item pelo ID e informa se a remoção ocorreu.
    public boolean deleteById(long id) {
        Item item = entityManager.find(Item.class, id);
        if (item == null) {
            return false;
        }
        entityManager.remove(item);
        return true;
    }

    // Retorna o próximo ID sequencial.
    public long nextId() {
        return ID_SEQ.incrementAndGet();
    }
}
