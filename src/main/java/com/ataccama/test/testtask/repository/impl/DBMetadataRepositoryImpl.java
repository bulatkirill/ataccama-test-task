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

public abstract class DBMetadataRepositoryImpl implements DBMetadataRepository {

    private static final String SELECT_ALL_FROM = "SELECT * FROM %s.%s";

    private static final Logger logger = LoggerFactory.getLogger(DBMetadataRepositoryImpl.class);

    @Autowired
    private DBConnectionFactory dbConnectionFactory;

    @Override
    public List<DBSchema> findAllSchemas(DBConnection dbConnection) throws SQLException {
        List<DBSchema> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement();) {
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

    protected abstract String findAllSchemaQueryString(DBConnection dbConnection);

    protected abstract DBSchema extractDbSchema(ResultSet resultSet) throws SQLException;

    @Override
    public List<DBTable> findAllTables(DBConnection dbConnection, String schemaName) throws SQLException {
        List<DBTable> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement();) {
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

    protected abstract String findAllTablesQueryString(DBConnection dbConnection, String schemaName);

    protected abstract DBTable extractDbTable(ResultSet resultSet) throws SQLException;

    @Override
    public List<DBColumn> findAllColumns(DBConnection dbConnection, String schemaName, String tableName) throws SQLException {
        List<DBColumn> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement();) {
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

    protected abstract String findAllColumnsQueryString(DBConnection dbConnection, String schemaName, String tableName);

    protected abstract DBColumn extractDbColumn(ResultSet resultSet) throws SQLException;

    @Override
    public final List<Map<String, Object>> findAllData(DBConnection dbConnection, String schemaName, String tableName) throws SQLException {
        List<Map<String, Object>> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(String.format(SELECT_ALL_FROM, schemaName, tableName));
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsCount = rsmd.getColumnCount();
                for (int i = 0; i < columnsCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    row.put(columnName, columnValue);
                }
                result.add(row);
            }
        } catch (SQLException e) {
            logger.error("Error happened while selecting all data from database = " +
                    dbConnection.getDbName() + ", with id = " + dbConnection.getId() +
                    ", schema = " + schemaName + ", table name = " + tableName, e);
            throw e;
        }
        return result;
    }
}
