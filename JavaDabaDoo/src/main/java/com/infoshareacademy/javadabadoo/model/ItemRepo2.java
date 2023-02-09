package com.infoshareacademy.javadabadoo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo2 extends JpaRepository<Item, Long> {
}
