package com.infoshareacademy.javadabadoo.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AudioBookRepository {
    private final EntityManager entityManager;

    public AudioBookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
