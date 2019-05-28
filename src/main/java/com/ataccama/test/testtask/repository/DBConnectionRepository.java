package com.ataccama.test.testtask.repository;

import com.ataccama.test.testtask.model.DBConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBConnectionRepository extends JpaRepository<DBConnection, Long> {

    DBConnection findByName(String name);
}
