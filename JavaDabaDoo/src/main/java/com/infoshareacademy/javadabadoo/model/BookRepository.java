package com.infoshareacademy.javadabadoo.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BookRepository {
    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
