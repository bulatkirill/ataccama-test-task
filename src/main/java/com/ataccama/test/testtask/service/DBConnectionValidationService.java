package com.ataccama.test.testtask.service;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;

/**
 * Simple service to make some simple validation on added or updated connections in the database
 */
public interface DBConnectionValidationService {

    /**
     * Validates adding of a new connection to a database. Validates properties of the specified connection
     *
     * @param dbConnection connection to add
     * @throws ValidationException in case of incorrect value of any property pf the connection
     */
    void validateAddDbConnection(DBConnection dbConnection) throws ValidationException;

    /**
     * Validates updating of the connection. Validates properties of the specified connection
     *
     * @param dbConnection connection to update
     * @throws ValidationException in case of incorrect value of any property pf the connection
     */
    void validateUpdateDbConnection(DBConnection dbConnection) throws ValidationException;
}
