package com.ataccama.test.testtask.service.impl;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.ValidationException;
import com.ataccama.test.testtask.repository.DBConnectionRepository;
import com.ataccama.test.testtask.service.DBConnectionService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBConnectionServiceImplTest {

    @Autowired
    private DBConnectionService dbConnectionService;

    @Autowired
    DBConnectionRepository dbConnectionRepository;

    @Before
    public void beforeEachTest() {
        DBConnection dbConnection1 = new DBConnection("custom name 1", "postgres", "localhost",
                5431, "dbName 1", null, "username 1", "password 1");
        DBConnection dbConnection2 = new DBConnection("custom name 2", "mysql", "localhost",
                5432, "dbName 2", null, "username 2", "password 2");
        DBConnection dbConnection3 = new DBConnection("custom name 3", "h2", "localhost",
                5433, "dbName 3", null, "username 3", "password 3");
        DBConnection dbConnection4 = new DBConnection("custom name 4", "myOwnProvider", "localhost",
                5434, "dbName 4", null, "username 4", "password 4");
        List<DBConnection> dbConnections = new ArrayList<>(4);
        dbConnections.add(dbConnection1);
        dbConnections.add(dbConnection2);
        dbConnections.add(dbConnection3);
        dbConnections.add(dbConnection4);
        dbConnectionRepository.saveAll(dbConnections);
    }

    @After
    public void afterEachTest() {
        dbConnectionRepository.deleteAll();
    }

    @Test
    public void findById() {
        List<DBConnection> dbConnections = dbConnectionService.findAll();
        assertNotNull(dbConnections);

        DBConnection dbConnection = dbConnectionService.findById(dbConnections.get(0).getId());
        assertNotNull(dbConnection);

        dbConnection = dbConnectionService.findById(-1L);
        assertNull(dbConnection);
    }

    @Test
    public void findAll() {
        List<DBConnection> dbConnections = dbConnectionService.findAll();
        assertNotNull(dbConnections);
        assertEquals(4, dbConnections.size());
    }

    @Test
    public void findByName() {
        DBConnection dbConnection = dbConnectionService.findByName("custom name 1");
        assertNotNull(dbConnection);

        dbConnection = dbConnectionService.findByName("not existing name");
        assertNull(dbConnection);
    }

    @Test
    public void add() throws ValidationException {
        DBConnection dbConnection5 = new DBConnection("custom name 5", "myOwnProvider", "localhost",
                5435, "dbName 5", null, "username 5", "password 5");
        DBConnection addedConnection = dbConnectionService.add(dbConnection5);
        assertNotNull(addedConnection);
        assertNotNull(addedConnection.getId());

        List<DBConnection> dbConnections = dbConnectionService.findAll();
        assertNotNull(dbConnections);
        assertEquals(5, dbConnections.size());
    }

    @Test
    public void update() throws ValidationException {
        List<DBConnection> dbConnections = dbConnectionService.findAll();
        assertNotNull(dbConnections);
        DBConnection dbConnection4 = new DBConnection("updated name 4", "myOwnProvider", "localhost",
                5434, "updated dbName 4", null, "updated username 4", "updated password 4");
        Long idToUpdate = dbConnections.get(0).getId();
        dbConnection4.setId(idToUpdate);
        DBConnection updatedConnection = dbConnectionService.update(dbConnection4);
        assertNotNull(updatedConnection);
        assertNotNull(updatedConnection.getId());

        dbConnections = dbConnectionService.findAll();
        assertNotNull(dbConnections);
        assertEquals(4, dbConnections.size());

        updatedConnection = dbConnectionService.findById(idToUpdate);
        assertNotNull(updatedConnection);
        assertEquals("updated name 4", updatedConnection.getName());
        assertEquals("updated dbName 4", updatedConnection.getDbName());
        assertEquals("updated username 4", updatedConnection.getUsername());
        assertEquals("updated password 4", updatedConnection.getPassword());
    }

    @Test
    public void delete() {
    }
}