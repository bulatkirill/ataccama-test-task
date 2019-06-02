package com.ataccama.test.testtask.repository;

import com.ataccama.test.testtask.model.DBConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring repository for CRUD operations with DBConnection
 */
@Repository
public interface DBConnectionRepository extends JpaRepository<DBConnection, Long> {

    /**
     * Method to find a database connection by its name
     *
     * @param name name of the connection to search
     * @return database connection with specified name
     */
    DBConnection findByName(String name);
}
