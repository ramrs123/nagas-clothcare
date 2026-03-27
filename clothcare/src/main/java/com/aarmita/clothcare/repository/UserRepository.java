package com.aarmita.clothcare.repository;

import com.aarmita.clothcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    Optional<User> getUserByUsername(@Param("username") String username);
}
