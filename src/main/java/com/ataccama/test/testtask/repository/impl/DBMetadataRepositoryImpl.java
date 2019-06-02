package com.ataccama.test.testtask.repository.impl;

import com.ataccama.test.testtask.factory.DBConnectionFactory;
import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;
import com.ataccama.test.testtask.repository.DBMetadataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Basic implementation of the SQL operations specified in the interface {@link DBMetadataRepository}
 * This class has to be extended for each database provider in order to provide correct SQL questions and the way to
 * work with results of those SQL questions
 */
public abstract class DBMetadataRepositoryImpl implements DBMetadataRepository {

    static final String SELECT_ALL_FROM = "SELECT * FROM %s.%s";

    private static final Logger logger = LoggerFactory.getLogger(DBMetadataRepositoryImpl.class);

    private DBConnectionFactory dbConnectionFactory;

    @Override
    public List<DBSchema> findAllSchemas(DBConnection dbConnection) throws SQLException {
        List<DBSchema> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(findAllSchemaQueryString(dbConnection));
            while (rs.next()) {
                result.add(extractDbSchema(rs));
            }
        } catch (SQLException e) {
            logger.error("Error happened while selecting schemas from database = " +
                    dbConnection.getDbName() + " with id = " + dbConnection.getId(), e);
            throw e;
        }
        return result;
    }

    /**
     * Method has to implemented by database providers in order to provide SQL query for selecting all schemas form its database
     *
     * @param dbConnection connection to use. In case any database provider needs it for creating a query
     * @return SQL query string
     */
    protected abstract String findAllSchemaQueryString(DBConnection dbConnection);

    /**
     * Method has to implemented by database providers in order to provide mechanism for processing
     * result of database schemas selection
     *
     * @param resultSet result of the query
     * @return processed result in form of the object
     * @throws SQLException thrown in case of incorrect {@link ResultSet} operation
     */
    protected abstract DBSchema extractDbSchema(ResultSet resultSet) throws SQLException;

    @Override
    public List<DBTable> findAllTables(DBConnection dbConnection, String schemaName) throws SQLException {
        List<DBTable> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(findAllTablesQueryString(dbConnection, schemaName));
            while (rs.next()) {
                result.add(extractDbTable(rs));
            }
        } catch (SQLException e) {
            logger.error("Error happened while selecting all tables from database = " +
                    dbConnection.getDbName() + " with id = " + dbConnection.getId() + ", schema = " + schemaName, e);
            throw e;
        }
        return result;
    }

    /**
     * Method has to implemented by database providers in order to provide SQL query for selecting all tables form its database
     *
     * @param dbConnection database connection properties
     * @param schemaName   name of the schema which tables has to be listed
     * @return SQL query string
     */
    protected abstract String findAllTablesQueryString(DBConnection dbConnection, String schemaName);

    /**
     * Method has to implemented by database providers in order to provide mechanism for processing
     * result of database tables selection
     *
     * @param resultSet result of the query
     * @return processed result
     * @throws SQLException thrown in case of incorrect {@link ResultSet} operation
     */
    protected abstract DBTable extractDbTable(ResultSet resultSet) throws SQLException;

    @Override
    public List<DBColumn> findAllColumns(DBConnection dbConnection, String schemaName, String tableName) throws SQLException {
        List<DBColumn> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(findAllColumnsQueryString(dbConnection, schemaName, tableName));
            while (rs.next()) {
                result.add(extractDbColumn(rs));
            }
        } catch (SQLException e) {
            logger.error("Error happened while selecting all columns from database = " +
                    dbConnection.getDbName() + ", with id = " + dbConnection.getId() +
                    ", schema = " + schemaName + ", table name = " + tableName, e);
            throw e;
        }
        return result;
    }

    /**
     * Method has to implemented by database providers in order to provide SQL query for selecting all columns from its database
     *
     * @param dbConnection database connection properties
     * @param schemaName   name of the schema which contains a table
     * @param tableName    name of the table which columns has to be selected
     * @return SQL query string
     */
    protected abstract String findAllColumnsQueryString(DBConnection dbConnection, String schemaName, String tableName);

    /**
     * Method has to implemented by database providers in order to provide mechanism for processing
     * result of database columns selection
     *
     * @param resultSet result of the query
     * @return processed result
     * @throws SQLException thrown in case of incorrect {@link ResultSet} operation
     */
    protected abstract DBColumn extractDbColumn(ResultSet resultSet) throws SQLException;

    @Override
    public List<Map<String, Object>> findDataPreview(DBConnection dbConnection,
                                                     String schemaName,
                                                     String tableName,
                                                     Integer count) throws SQLException {
        return findAllDataCommon(dbConnection, schemaName, tableName, count);
    }

    @Override
    public List<Map<String, Object>> findAllData(DBConnection dbConnection, String schemaName, String tableName) throws SQLException {
        return findAllDataCommon(dbConnection, schemaName, tableName, null);
    }

    private List<Map<String, Object>> findAllDataCommon(DBConnection dbConnection, String schemaName, String tableName, Integer count) throws SQLException {
        List<Map<String, Object>> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(getDataQueryString(dbConnection, schemaName, tableName));
            while (rs.next() && count > 0) {
                Map<String, Object> row = new HashMap<>();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsCount = rsmd.getColumnCount();
                for (int i = 1; i < columnsCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    row.put(columnName, columnValue);
                }
                result.add(row);
                count--;
            }
        } catch (SQLException e) {
            logger.error("Error happened while selecting all data from database = " +
                    dbConnection.getDbName() + ", with id = " + dbConnection.getId() +
                    ", schema = " + schemaName + ", table name = " + tableName, e);
            throw e;
        }
        return result;
    }

    protected abstract String getDataQueryString(DBConnection dbConnection, String schemaName, String tableName);

    @Autowired
    public void setDbConnectionFactory(DBConnectionFactory dbConnectionFactory) {
        this.dbConnectionFactory = dbConnectionFactory;
    }
}
