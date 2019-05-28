package com.ataccama.test.testtask.service;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;

import java.util.List;

public interface DBConnectionService {

    List<DBConnection> findAll();

    DBConnection findById(Long id);

    DBConnection findByName(String name);

    DBConnection add(DBConnection dbConnection) throws ValidationException;

    DBConnection update(DBConnection dbConnection) throws ValidationException;

    void delete(Long id);

    void deleteAll();
}
