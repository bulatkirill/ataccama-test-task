package com.ataccama.test.testtask.service;

import com.ataccama.test.testtask.model.exception.UnsupportedProviderException;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;

import java.util.List;
import java.util.Map;

/**
 * Service to access metadata of the database
 */
public interface DbMetadataService {

    /**
     * Lists all schemas
     *
     * @param dbConnectionId id of the database connection to use to list schemas
     * @return list of schemas
     * @throws UnsupportedProviderException thrown in case database provider is not supported
     */
    List<DBSchema> findAllSchemas(Long dbConnectionId) throws UnsupportedProviderException;

    /**
     * Lists all tables
     *
     * @param dbConnectionId id of the database connection to use to list tables
     * @param schemaName     name of the schema to list tables
     * @return list of tables
     * @throws UnsupportedProviderException thrown in case database provider is not supported
     */
    List<DBTable> findAllTables(Long dbConnectionId, String schemaName) throws UnsupportedProviderException;

    /**
     * List all columns
     *
     * @param dbConnectionId id of the database connection to use to list columns
     * @param schemaName     name of the schema to list columns
     * @param tableName      name of the table to list columns
     * @return list of columns
     * @throws UnsupportedProviderException thrown in case database provider is not supported
     */
    List<DBColumn> findAllColumns(Long dbConnectionId, String schemaName, String tableName) throws UnsupportedProviderException;

    /**
     * Gets data preview
     *
     * @param dbConnectionId id of the database connection to use to get data preview
     * @param schemaName     name of the schema to get data preview
     * @param tableName      name of the table to get data preview
     * @param count          number of rows to get in the preview
     * @return data preview
     * @throws UnsupportedProviderException thrown in case database provider is not supported
     */
    List<Map<String, Object>> findDataPreview(Long dbConnectionId, String schemaName, String tableName, Integer count) throws UnsupportedProviderException;

    /**
     * Gets all data
     *
     * @param dbConnectionId id of the database connection to use to get all data
     * @param schemaName     name of the schema to get all data
     * @param tableName      name of the table to get all data
     * @return all data in the table
     * @throws UnsupportedProviderException thrown in case database provider is not supported
     */
    List<Map<String, Object>> findAllData(Long dbConnectionId, String schemaName, String tableName) throws UnsupportedProviderException;


}
