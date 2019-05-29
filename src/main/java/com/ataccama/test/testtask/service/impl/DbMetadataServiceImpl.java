package com.ataccama.test.testtask.service.impl;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;
import com.ataccama.test.testtask.repository.DBMetadataRepository;
import com.ataccama.test.testtask.service.DbMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DbMetadataServiceImpl implements DbMetadataService {


    @Autowired
    @Qualifier("PostgresqlDbMetadataRepositoryImpl")
    private DBMetadataRepository dbMetadataRepository;

    private static Map<String, DBMetadataRepository> repositoryMap = new HashMap<>();

    @PostConstruct
    public void postConstruct() {
//        TODO initialization of map
    }

    @Override
    public List<DBSchema> findAllSchemas(DBConnection dbConnection) throws SQLException {
        return null;
    }

    @Override
    public List<DBTable> findAllTables(DBConnection dbConnection, String schemaName) throws SQLException {
        return null;
    }

    @Override
    public List<DBColumn> findAllColumns(DBConnection dbConnection, String schemaName, String tableId) throws SQLException {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllData(DBConnection dbConnection, String schemaName, String tableId) throws SQLException {
        return null;
    }
}
