package com.ataccama.test.testtask.service;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;

import java.util.List;

/**
 * Service for CRUD operations with database connections. Service adds some validation in create and update operations
 */
public interface DBConnectionService {

    /**
     * Lists all connections
     *
     * @return database connections
     */
    List<DBConnection> findAll();

    /**
     * Finds connection by id
     *
     * @param id id to search for
     * @return database connection
     */
    DBConnection findById(Long id);

    /**
     * Finds a connection by its name
     *
     * @param name name to search for
     * @return database connection
     */
    DBConnection findByName(String name);

    /**
     * Adds a connection to a database
     *
     * @param dbConnection connection to add
     * @return added connection
     * @throws ValidationException in case of the incorrect value of database connection properties
     */
    DBConnection add(DBConnection dbConnection) throws ValidationException;

    /**
     * Updates a connection in the database
     *
     * @param dbConnection connection to update
     * @return updated connection
     * @throws ValidationException in case of the incorrect value of database connection properties
     */
    DBConnection update(DBConnection dbConnection) throws ValidationException;

    /**
     * Deletes a connection in the database
     *
     * @param id if of the connection to delete
     */
    void delete(Long id);

    /**
     * Deletes all connections in the database
     */
    void deleteAll();
}
