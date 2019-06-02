package com.ataccama.test.testtask.factory;

import com.ataccama.test.testtask.model.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of {@link DBConnectionFactory} providing connection to database
 * and implementing basic cached mechanism to reduce number of created connections
 */
@Component
public class CachedDbConnectionFactory implements DBConnectionFactory {
    private static final Logger logger = LoggerFactory.getLogger(DBConnectionFactory.class);

    private static final String JDBC = "jdbc";
    private static final String COLON = ":";

    /**
     * Map is used to store cached connections
     */
    private static final Map<DBConnection, Connection> cachedConnections = new HashMap<>();

    public Connection getConnection(DBConnection dbConnection) throws SQLException {
//        try to find if connection is already created and cached
        Connection connection = cachedConnections.get(dbConnection);
        String dbConnectionString = null;
        if (connection != null) {
            return connection;
        } else {
//            if not cached create new connection
            try {
                dbConnectionString = getDbConnectionString(dbConnection);
                connection = DriverManager.getConnection(dbConnectionString,
                        dbConnection.getUsername(),
                        dbConnection.getPassword());
            } catch (SQLException e) {
                logger.error("Connection to the database with id = " + dbConnection.getId() +
                        "was not successful. Connection string = " + dbConnectionString, e);
                throw e;
            }
            cachedConnections.put(dbConnection, connection);
        }
        return connection;
    }


    /**
     * Method creates database connection string
     *
     * @param dbConnection parameters of the connection
     * @return connection string
     */
    private String getDbConnectionString(DBConnection dbConnection) {
        StringBuilder urlBuilder = new StringBuilder(JDBC);
        urlBuilder.append(COLON).
                append(dbConnection.getProvider()).
                append(COLON).
                append("//").
                append(dbConnection.getHost());
        Integer port = dbConnection.getPort();
//        check if there is a port to use
        if (port != null) {
            urlBuilder.append(COLON).
                    append(dbConnection.getPort());
        }
        urlBuilder.append("/").
                append(dbConnection.getDbName());
        return urlBuilder.toString();
    }
}
