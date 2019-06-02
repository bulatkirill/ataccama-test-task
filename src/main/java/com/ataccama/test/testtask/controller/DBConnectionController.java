package com.ataccama.test.testtask.controller;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;
import com.ataccama.test.testtask.service.DBConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connection")
public class DBConnectionController {

    private DBConnectionService dbConnectionService;

    @GetMapping
    public List<DBConnection> getAllConnections() {
        return dbConnectionService.findAll();
    }

    @GetMapping("/{id}")
    public DBConnection getConnection(@PathVariable("id") Long id) {
        return dbConnectionService.findById(id);
    }

    @GetMapping(params = "dbName")
    public DBConnection getConnection(@RequestParam("dbName") String dbName) {
        return dbConnectionService.findByName(dbName);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DBConnection addConnection(@RequestBody DBConnection dbConnection) throws ValidationException {
        return dbConnectionService.add(dbConnection);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DBConnection updateConnection(@RequestBody DBConnection dbConnection) throws ValidationException {
        return dbConnectionService.update(dbConnection);
    }

    @DeleteMapping("/{id}")
    public void deleteConnection(@PathVariable("id") Long id) {
        dbConnectionService.delete(id);
    }

    @Autowired
    public void setDbConnectionService(DBConnectionService dbConnectionService) {
        this.dbConnectionService = dbConnectionService;
    }
}
