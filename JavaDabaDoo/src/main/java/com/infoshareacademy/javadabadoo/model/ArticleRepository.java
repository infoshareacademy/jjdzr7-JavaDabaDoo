package com.infoshareacademy.javadabadoo.model;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ArticleRepository {
    private final EntityManager entityManager;

    public ArticleRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Article article){
        entityManager.persist(article);
    }
}
