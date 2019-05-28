package com.ataccama.test.testtask.factory;

import com.ataccama.test.testtask.model.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBConnectionFactory {

    private static final String JDBC = "jdbc";
    private static final String COLON = ":";
    private static Map<DBConnection, Connection> cachedConnections = new HashMap<>();

    public static Connection getConnection(DBConnection dbConnection) {
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

    private static String getDbConnectionString(DBConnection dbConnection) {
        StringBuilder urlBuilder = new StringBuilder(JDBC);
        urlBuilder.append(COLON).
                append(dbConnection.getProvider()).
                append(COLON).
                append("//").
                append(dbConnection.getHost()).
                append(COLON).
//                TODO if there is no port specified - potentialy a problem can occur
        append(dbConnection.getPort()).
                append("/").
                append(dbConnection.getDbName());
        return urlBuilder.toString();
    }
}
