package com.ataccama.test.testtask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DBConnection {

    /**
     * Entity id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Custom name of the database instance
     */
    private String name;

    /**
     * Provider identification
     */
    private String provider;

    /**
     * Host identification
     */
    private String host;

    /**
     * TCP port
     */
    private Integer port;

    /**
     * Name of the database
     */
    private String dbName;

    /**
     * Additional query params
     */
    private String queryParams;

    /**
     * Username to use for connection
     */
    private String username;

    /**
     * Password to use for connection
     */
    private String password;

    public DBConnection() {

    }

    public DBConnection(String name, String provider, String host, Integer port, String dbName, String queryParams, String username, String password) {
        this.name = name;
        this.provider = provider;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.queryParams = queryParams;
        this.username = username;
        this.password = password;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
