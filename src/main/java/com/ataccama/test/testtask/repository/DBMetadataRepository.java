package com.ataccama.test.testtask.repository;


import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Interface to access basic information of the specified database connection
 */
public interface DBMetadataRepository {

    /**
     * Method lists all schemas of the specified database connection
     *
     * @param dbConnection connection to use to list schemas
     * @return list of schemas found for this database connection
     * @throws SQLException thrown in case of unsuccessful connection to a database or unsuccessful SQL operation
     */
    List<DBSchema> findAllSchemas(DBConnection dbConnection) throws SQLException;

    /**
     * Method lists all tables of the specified schema and database connection
     *
     * @param dbConnection connection to use to list tables
     * @param schemaName   schema name to use to list tables
     * @return list of tables found for this database connection
     * @throws SQLException thrown in case of unsuccessful connection to a database or unsuccessful SQL operation
     */
    List<DBTable> findAllTables(DBConnection dbConnection,
                                String schemaName) throws SQLException;

    /**
     * Method lists all columns of the specified table and specified schema and database connection
     *
     * @param dbConnection connection to use to list columns
     * @param schemaName   name of schema
     * @param tableId      name of the table to use to list columns
     * @return list of columns
     * @throws SQLException thrown in case of unsuccessful connection to a database or unsuccessful SQL operation
     */
    List<DBColumn> findAllColumns(DBConnection dbConnection,
                                  String schemaName,
                                  String tableId) throws SQLException;

    /**
     * Method gets rows of the specified database table, which number is specified by the parameter of the method
     *
     * @param dbConnection connection to use to access data
     * @param schemaName   name of the schema
     * @param tableId      name of the table to get data preview
     * @param count        number of rows to get
     * @return list of database rows, where each row is represented as a map
     * @throws SQLException thrown in case of unsuccessful connection to a database or unsuccessful SQL operation
     */
    List<Map<String, Object>> findDataPreview(DBConnection dbConnection,
                                              String schemaName,
                                              String tableId,
                                              Integer count) throws SQLException;

    /**
     * Method gets all data from the database table specified in the parameters
     *
     * @param dbConnection connection to use
     * @param schemaName   name of the schema to use
     * @param tableId      name of the table to get data
     * @return list of database rows, where each row is represented as a map
     * @throws SQLException thrown in case of unsuccessful connection to a database or unsuccessful SQL operation
     */
    List<Map<String, Object>> findAllData(DBConnection dbConnection,
                                          String schemaName,
                                          String tableId) throws SQLException;

    /**
     * Method returns a type of database provider for which all database operations above were implemented
     *
     * @return name of the provider
     */
    String getProvider();
}
