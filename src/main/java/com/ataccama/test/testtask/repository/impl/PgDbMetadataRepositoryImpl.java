package com.ataccama.test.testtask.repository.impl;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.metadata.*;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.postgresql.PgDbColumn;
import com.ataccama.test.testtask.model.metadata.DBTable;
import com.ataccama.test.testtask.model.metadata.postgresql.PgDbSchema;
import com.ataccama.test.testtask.model.metadata.postgresql.PgDbTable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Qualifier("PgDbMetadataRepositoryImpl")
public class PgDbMetadataRepositoryImpl extends DBMetadataRepositoryImpl {

    private static final String NSPNAME = "nspname";
    private static final String NSPOWNER = "nspowner";
    private static final String POSTGRESQL = "postgresql";

    @Override
    protected String findAllSchemaQueryString(DBConnection dbConnection) {
        return "select nspname, nspowner from pg_catalog.pg_namespace";
    }

    @Override
    protected DBSchema extractDbSchema(ResultSet resultSet) throws SQLException {
        return new PgDbSchema(resultSet.getString(NSPNAME), resultSet.getString(NSPOWNER));
    }

    @Override
    protected String findAllTablesQueryString(DBConnection dbConnection, String schemaName) {
        return "select * from information_schema.tables where table_schema = '" + schemaName + "'";
    }

    @Override
    protected DBTable extractDbTable(ResultSet resultSet) throws SQLException {
        return new PgDbTable(
                resultSet.getString("table_name"),
                resultSet.getString("table_catalog"),
                resultSet.getString("table_schema"),
                resultSet.getString("table_type"),
                resultSet.getString("self_referencing_column_name"),
                resultSet.getString("reference_generation"),
                resultSet.getString("user_defined_type_catalog"),
                resultSet.getString("user_defined_type_schema"),
                resultSet.getString("user_defined_type_name"),
                resultSet.getBoolean("is_insertable_into"),
                resultSet.getBoolean("is_typed"),
                resultSet.getString("commit_action")
        );
    }

    @Override
    protected String findAllColumnsQueryString(DBConnection dbConnection, String schemaName, String tableName) {
        return "SELECT * FROM information_schema.columns WHERE table_schema = '"
                + schemaName + "' AND  table_name = '" + tableName + "'";
    }

    @Override
    protected DBColumn extractDbColumn(ResultSet resultSet) throws SQLException {
        return new PgDbColumn(
                resultSet.getString("table_schema"),
                resultSet.getString("table_name"),
                resultSet.getString("column_name"),
                resultSet.getString("data_type"),
                resultSet.getString("column_default"),
                resultSet.getBoolean("is_nullable"),
                resultSet.getInt("character_maximum_length"),
                resultSet.getInt("numeric_precision"),
                resultSet.getInt("numeric_precision_radix"),
                resultSet.getBoolean("is_updatable"),
                resultSet.getInt("ordinal_position")
        );
    }


    @Override
    public String getProvider() {
        return POSTGRESQL;
    }
}
