package com.ataccama.test.testtask.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    /**
     * Entity id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<DBConnection> dbConnections;

    public Team() {
        dbConnections = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DBConnection> getDbConnections() {
        return dbConnections;
    }

    public void setDbConnections(List<DBConnection> dbConnections) {
        this.dbConnections = dbConnections;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
