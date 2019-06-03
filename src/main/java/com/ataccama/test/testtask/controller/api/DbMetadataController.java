package com.ataccama.test.testtask.controller.api;

import com.ataccama.test.testtask.model.exception.UnsupportedProviderException;
import com.ataccama.test.testtask.model.metadata.DBColumn;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.model.metadata.DBTable;
import com.ataccama.test.testtask.service.DbMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST API controller contains operation for listing schemas of the specified DB connection, listing tables of the
 * specified schema, listing columns and their properties of the specified table, data preview
 */
@RestController
@RequestMapping("/api/v1/connection/{id}")
public class DbMetadataController {

    private DbMetadataService dbMetadataService;

    @GetMapping(value = "/schemas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DBSchema> getSchemas(@PathVariable("id") Long connectionId) throws UnsupportedProviderException {
        return dbMetadataService.findAllSchemas(connectionId);
    }

    @GetMapping(value = "/schemas/{schemaName}/tables", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DBTable> getTables(@PathVariable("id") Long connectionId,
                                   @PathVariable("schemaName") String schemaName) throws UnsupportedProviderException {
        return dbMetadataService.findAllTables(connectionId, schemaName);
    }

    @GetMapping(value = "/schemas/{schemaName}/tables/{tableName}/columns", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DBColumn> getColumns(@PathVariable("id") Long connectionId,
                                     @PathVariable("schemaName") String schemaName,
                                     @PathVariable("tableName") String tableName) throws UnsupportedProviderException {
        return dbMetadataService.findAllColumns(connectionId, schemaName, tableName);
    }

    @GetMapping(value = "/schemas/{schemaName}/tables/{tableName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Map<String, Object>> getDataPreview(@PathVariable("id") Long connectionId,
                                                    @PathVariable("schemaName") String schemaName,
                                                    @PathVariable("tableName") String tableName,
                                                    @RequestParam(required = false, defaultValue = "15") Integer count)
            throws UnsupportedProviderException {
        return dbMetadataService.findDataPreview(connectionId, schemaName, tableName, count);
    }

    @Autowired
    public void setDbConnectionService(DbMetadataService dbMetadataService) {
        this.dbMetadataService = dbMetadataService;
    }
}
