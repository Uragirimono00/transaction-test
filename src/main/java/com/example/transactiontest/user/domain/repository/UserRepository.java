package com.example.transactiontest.user.domain.repository;

import com.example.transactiontest.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByName(String 형서);

    User findByName(String 형서);
}
