package com.ataccama.test.testtask.factory;

import com.ataccama.test.testtask.model.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DBConnectionFactory {

    private static final String JDBC = "jdbc";
    private static final String COLON = ":";
    private static Map<DBConnection, Connection> cachedConnections = new HashMap<>();

    public Connection getConnection(DBConnection dbConnection) {
        Connection connection = cachedConnections.get(dbConnection);
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection(getDbConnectionString(dbConnection),
                        dbConnection.getUsername(),
                        dbConnection.getPassword());
            } catch (SQLException e) {
//                TODO logger, cannot connect to specified database, throw new exception and so on
                e.printStackTrace();
            }
            cachedConnections.put(dbConnection, connection);
        }
        return connection;
    }

    private String getDbConnectionString(DBConnection dbConnection) {
        StringBuilder urlBuilder = new StringBuilder(JDBC);
        urlBuilder.append(COLON).
                append(dbConnection.getProvider()).
                append(COLON).
                append("//").
                append(dbConnection.getHost());
        Integer port = dbConnection.getPort();
        if (port != null) {
            urlBuilder.append(COLON).
                    append(dbConnection.getPort());
        }
        urlBuilder.append("/").
                append(dbConnection.getDbName());
        return urlBuilder.toString();
    }
}
