package com.example.transactiontest.team.domain.repository;

import com.example.transactiontest.team.domain.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
