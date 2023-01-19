package com.infoshareacademy.javadabadoo.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ItemRepository {
    private final EntityManager entityManager;

    public ItemRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
