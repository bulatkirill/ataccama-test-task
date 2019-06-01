package com.ataccama.test.testtask;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.service.DBConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }

    @Autowired
    private DBConnectionService dbConnectionService;

    @Override
    public void run(String... args) throws Exception {
        DBConnection dbConnection = new DBConnection();
        dbConnection.setProvider("postgresql");
        dbConnection.setHost("localhost");
        dbConnection.setPort(5432);
        dbConnection.setDbName("surf_app");
        dbConnection.setUsername("postgres");
        dbConnection.setPassword("postgres");
        dbConnection.setName("my test db connection");
        dbConnectionService.add(dbConnection);
    }
}
