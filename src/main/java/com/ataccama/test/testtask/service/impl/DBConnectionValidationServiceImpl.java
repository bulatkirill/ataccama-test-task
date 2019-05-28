package com.ataccama.test.testtask.service.impl;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;
import com.ataccama.test.testtask.service.DBConnectionValidationService;
import org.springframework.stereotype.Service;

@Service
public class DBConnectionValidationServiceImpl implements DBConnectionValidationService {

    private final static String ATTRIBUTE_MISSING_EXCEPTION =
            "Attribute %s is missing. Cannot continue in creation/update of record.";
    private static final String PROVIDER = "provider";
    private static final String HOST = "host";
    private static final String PORT = "port";
    private static final String DB_NAME = "dbName";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public void validateAddDbConnection(DBConnection dbConnection) throws ValidationException {
        validateAddUpdateDbConnection(dbConnection);
    }

    @Override
    public void validateUpdateDbConnection(DBConnection dbConnection) throws ValidationException {
        validateAddUpdateDbConnection(dbConnection);
        if (dbConnection.getId() == null) {
            throw new ValidationException("ID of record is missing. Cannot proceed in an update of the record.");
        }
    }

    private void validateAddUpdateDbConnection(DBConnection dbConnection) throws ValidationException {
        if (dbConnection == null) {
            throw new ValidationException("DBConnection is null. Cannot proceed in creation/update of a record.");
        }
        if (dbConnection.getProvider() == null) {
            throw new ValidationException(String.format(ATTRIBUTE_MISSING_EXCEPTION, PROVIDER));
        }
        if (dbConnection.getHost() == null) {
            throw new ValidationException(String.format(ATTRIBUTE_MISSING_EXCEPTION, HOST));
        }
        if (dbConnection.getPort() == null) {
            throw new ValidationException(String.format(ATTRIBUTE_MISSING_EXCEPTION, PORT));
        }
        if (dbConnection.getDbName() == null) {
            throw new ValidationException(String.format(ATTRIBUTE_MISSING_EXCEPTION, DB_NAME));
        }
        if (dbConnection.getUsername() == null) {
            throw new ValidationException(String.format(ATTRIBUTE_MISSING_EXCEPTION, USERNAME));
        }
        if (dbConnection.getPassword() == null) {
            throw new ValidationException(String.format(ATTRIBUTE_MISSING_EXCEPTION, PASSWORD));
        }
    }
}
