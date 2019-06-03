package com.ataccama.test.testtask;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.Team;
import com.ataccama.test.testtask.service.DBConnectionService;
import com.ataccama.test.testtask.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }

    @Autowired
    private DBConnectionService dbConnectionService;

    @Autowired
    private TeamService teamService;

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

        DBConnection dbConnection1 = new DBConnection();
        dbConnection1.setProvider("postgresql");
        dbConnection1.setHost("localhost");
        dbConnection1.setPort(5432);
        dbConnection1.setDbName("surf_app");
        dbConnection1.setUsername("postgres");
        dbConnection1.setPassword("postgres");
        dbConnection1.setName("my test db connection");

        Team team1 = new Team();
        team1.setName("name1");
        team1.getDbConnections().add(dbConnection);
        team1.getDbConnections().add(dbConnection1);

        dbConnection.setTeam(team1);
        dbConnection1.setTeam(team1);

        teamService.add(team1);
    }
}
