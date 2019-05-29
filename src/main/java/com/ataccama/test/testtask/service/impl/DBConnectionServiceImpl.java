package com.ataccama.test.testtask.service.impl;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;
import com.ataccama.test.testtask.repository.DBConnectionRepository;
import com.ataccama.test.testtask.service.DBConnectionService;
import com.ataccama.test.testtask.service.DBConnectionValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBConnectionServiceImpl implements DBConnectionService {

    private DBConnectionRepository dbConnectionRepository;

    private DBConnectionValidationService dbConnectionValidationService;

    @Override
    public List<DBConnection> findAll() {
        return dbConnectionRepository.findAll();
    }

    @Override
    public DBConnection findById(Long id) {
        return dbConnectionRepository.findById(id).orElse(null);
    }

    @Override
    public DBConnection findByName(String name) {
        return dbConnectionRepository.findByName(name);
    }

    @Override
    public DBConnection add(DBConnection dbConnection) throws ValidationException {
        dbConnectionValidationService.validateAddDbConnection(dbConnection);
        return dbConnectionRepository.save(dbConnection);
    }

    @Override
    public DBConnection update(DBConnection dbConnection) throws ValidationException {
        dbConnectionValidationService.validateUpdateDbConnection(dbConnection);
        return dbConnectionRepository.save(dbConnection);
    }

    @Override
    public void delete(Long id) {
        dbConnectionRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        dbConnectionRepository.deleteAll();
    }

    @Autowired
    public void setDbConnectionRepository(DBConnectionRepository dbConnectionRepository) {
        this.dbConnectionRepository = dbConnectionRepository;
    }

    @Autowired
    public void setDbConnectionValidationService(DBConnectionValidationService dbConnectionValidationService) {
        this.dbConnectionValidationService = dbConnectionValidationService;
    }
}
