package com.ataccama.test.testtask.repository;


import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DBMetadataRepository {

    List<DBSchema> findAllSchemas(DBConnection dbConnection) throws SQLException;

    List<DBTable> findAllTables(DBConnection dbConnection, String schemaName) throws SQLException;

    List<DBColumn> findAllColumns(DBConnection dbConnection, String schemaName, String tableId) throws SQLException;

    List<Map<String, Object>> findAllData(DBConnection dbConnection, String schemaName, String tableId) throws SQLException;

    String getProvider();
}
