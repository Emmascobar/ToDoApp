package com.ohmycode.test.repository;

import com.ohmycode.test.models.entities.ToDo;
import com.ohmycode.test.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username like %?1")
    public List<User> findByUsernameEquals(String username);

}