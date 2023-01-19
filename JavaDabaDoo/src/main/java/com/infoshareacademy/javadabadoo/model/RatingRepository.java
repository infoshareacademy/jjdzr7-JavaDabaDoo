package com.infoshareacademy.javadabadoo.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RatingRepository {
    private final EntityManager entityManager;


    public RatingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
