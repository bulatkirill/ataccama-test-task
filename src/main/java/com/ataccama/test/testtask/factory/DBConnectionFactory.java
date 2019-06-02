package com.ataccama.test.testtask.factory;

import com.ataccama.test.testtask.model.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Bean defines an interface for providing connections by its properties
 */
public interface DBConnectionFactory {

    /**
     * Factory method provides a connection to a database with specified properties in {@link DBConnection}
     *
     * @param dbConnection properties for providing a connection
     * @return connection to a specified database
     * @throws SQLException exception in case database connection was not established correctly
     */
    Connection getConnection(DBConnection dbConnection) throws SQLException;

}
