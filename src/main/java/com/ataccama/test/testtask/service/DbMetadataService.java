package com.ataccama.test.testtask.service;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.UnsupportedProviderException;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DbMetadataService {

    List<DBSchema> findAllSchemas(DBConnection dbConnection) throws SQLException, UnsupportedProviderException;

    List<DBTable> findAllTables(DBConnection dbConnection, String schemaName) throws SQLException, UnsupportedProviderException;

    List<DBColumn> findAllColumns(DBConnection dbConnection, String schemaName, String tableId) throws SQLException, UnsupportedProviderException;

    List<Map<String, Object>> findAllData(DBConnection dbConnection, String schemaName, String tableId) throws SQLException, UnsupportedProviderException;


}
