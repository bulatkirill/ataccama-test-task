package com.ataccama.test.testtask.repository;

import com.ataccama.test.testtask.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
