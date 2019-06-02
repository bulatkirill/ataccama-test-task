package com.ataccama.test.testtask.model.metadata;

/**
 * Basic representation of database table
 * Contains basic properties of a table representation of different database providers
 * Can be extended to add properties for concrete database provider
 */
public class DBTable {

    private String name;

    public DBTable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
