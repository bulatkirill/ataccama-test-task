package com.ataccama.test.testtask.service;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;

public interface DBConnectionValidationService {

    void validateAddDbConnection(DBConnection dbConnection) throws ValidationException;

    void validateUpdateDbConnection(DBConnection dbConnection) throws ValidationException;
}
