package com.ataccama.test.testtask.service;

import com.ataccama.test.testtask.model.exception.UnsupportedProviderException;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;

import java.util.List;
import java.util.Map;

public interface DbMetadataService {

    List<DBSchema> findAllSchemas(Long dbConnectionId) throws UnsupportedProviderException;

    List<DBTable> findAllTables(Long dbConnectionId, String schemaName) throws UnsupportedProviderException;

    List<DBColumn> findAllColumns(Long dbConnectionId, String schemaName, String tableId) throws UnsupportedProviderException;

    List<Map<String, Object>> findDataPreview(Long dbConnectionId, String schemaName, String tableId, Integer count) throws UnsupportedProviderException;

    List<Map<String, Object>> findAllData(Long dbConnectionId, String schemaName, String tableId) throws UnsupportedProviderException;


}
