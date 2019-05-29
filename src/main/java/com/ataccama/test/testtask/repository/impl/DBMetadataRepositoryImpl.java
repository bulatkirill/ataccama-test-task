package com.ataccama.test.testtask.repository.impl;

import com.ataccama.test.testtask.factory.DBConnectionFactory;
import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;
import com.ataccama.test.testtask.model.PostgresqlDbTable;
import com.ataccama.test.testtask.repository.DBMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DBMetadataRepositoryImpl implements DBMetadataRepository {

    public static final String NSPNAME = "nspname";
    public static final String NSPOWNER = "nspowner";
    @Autowired
    private DBConnectionFactory dbConnectionFactory;


    @Override
    public List<DBSchema> findAllSchemas(DBConnection dbConnection) {
        List<DBSchema> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement();) {
            ResultSet rs = statement.executeQuery("select nspname, nspowner from pg_catalog.pg_namespace");
            while (rs.next()) {
                result.add(new DBSchema(rs.getString(NSPNAME), rs.getString(NSPOWNER)));
            }
        } catch (SQLException e) {
//            TODO logger
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DBTable> findAllTables(DBConnection dbConnection, String schemaName) {
        List<DBTable> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement();) {
            ResultSet rs = statement.executeQuery("select * from " + schemaName + ".tables");
            while (rs.next()) {
                result.add(new PostgresqlDbTable(
                        rs.getString("table_name"),
                        rs.getString("table_catalog"),
                        rs.getString("table_schema"),
                        rs.getString("table_type"),
                        rs.getString("self_referencing_column_name"),
                        rs.getString("reference_generation"),
                        rs.getString("user_defined_type_catalog"),
                        rs.getString("user_defined_type_schema"),
                        rs.getString("user_defined_type_name"),
                        rs.getBoolean("is_insertable_into"),
                        rs.getBoolean("is_typed"),
                        rs.getString("commit_action")
                ));
            }
        } catch (SQLException e) {
//            TODO logger
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DBColumn> findAllColumns(DBConnection dbConnection, String schemaName, String tableName) {
        List<DBColumn> result = new ArrayList<>();
        Connection conn = dbConnectionFactory.getConnection(dbConnection);
        try (Statement statement = conn.createStatement();) {
            ResultSet rs = statement.executeQuery("SELECT * FROM information_schema.columns WHERE table_schema = '"
                    + schemaName + "' AND  table_name = '" + tableName + "'");
            while (rs.next()) {
//                TODO
                result.add(new DBColumn(
//                        rs.getString("table_name"),
//                        rs.getString("table_catalog"),
//                        rs.getString("table_schema"),
//                        rs.getString("table_type"),
//                        rs.getString("self_referencing_column_name"),
//                        rs.getString("reference_generation"),
//                        rs.getString("user_defined_type_catalog"),
//                        rs.getString("user_defined_type_schema"),
//                        rs.getString("user_defined_type_name"),
//                        rs.getBoolean("is_insertable_into"),
//                        rs.getBoolean("is_typed"),
//                        rs.getString("commit_action")
                ));
            }
        } catch (SQLException e) {
//            TODO logger
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Map<String, String>> findAllData(DBConnection dbConnection, String schemaName, String tableId) {
        return null;
    }
}
