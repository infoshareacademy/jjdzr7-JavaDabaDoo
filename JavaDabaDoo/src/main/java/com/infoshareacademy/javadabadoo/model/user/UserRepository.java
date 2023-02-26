package com.infoshareacademy.javadabadoo.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean deleteUserById(Long id);

    <List> List getAllUsers();

    User updateUserById(Long id, User user);

    User getUserById(Long id);

    User createUser(User user);
}
