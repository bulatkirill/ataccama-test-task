package com.ataccama.test.testtask.service.impl;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;
import com.ataccama.test.testtask.service.DBConnectionValidationService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBConnectionValidationServiceImplTest {

    private DBConnectionValidationService dbConnectionValidationService;

    @Before
    public void before() {
        dbConnectionValidationService = new DBConnectionValidationServiceImpl();
    }

    /**
     * Basic test on validation of any of obligatory attribute of the dbConnection to add a record
     *
     * @throws ValidationException exception that has to be thrown
     */
    @Test(expected = ValidationException.class)
    public void validateAddDbConnection() throws ValidationException {
        DBConnection dbConnection = new DBConnection();
        dbConnectionValidationService.validateAddDbConnection(dbConnection);
    }

    /**
     * Basic test on validation obligatory Id attribute of the DbConnection to update a record
     * Checks correct text of the validation exception
     *
     * @throws ValidationException exception that has to be thrown
     */
    @Test(expected = ValidationException.class)
    public void validateUpdateDbConnection() throws ValidationException {
        DBConnection dbConnection = new DBConnection();
        dbConnection.setName("random name");
        dbConnection.setProvider("postgres");
        dbConnection.setHost("random host");
        dbConnection.setPort(5432);
        dbConnection.setDbName("random db name");
        dbConnection.setUsername("random username");
        dbConnection.setPassword("random password");
        try {
            dbConnectionValidationService.validateUpdateDbConnection(dbConnection);
        } catch (ValidationException e) {
            assertEquals("ID of record is missing. Cannot proceed in an update of the record.", e.getMessage());
            throw e;
        }
    }
}