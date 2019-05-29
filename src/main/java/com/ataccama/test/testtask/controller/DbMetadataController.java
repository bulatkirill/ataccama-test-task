package com.ataccama.test.testtask.controller;

import com.ataccama.test.testtask.service.DBConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/v1/connection/{id}")
public class DbMetadataController {

    private DBConnectionService dbConnectionService;

    @GetMapping("/schemas")
    public void getSchemas(@PathVariable("id") Long connectionId) {
//        TODO
    }

    @GetMapping("/schemas/{schemaName}/tables")
    public void getTables(@PathVariable("id") Long connectionId, @PathVariable("schemaName") String schemaName) {
//        TODO
    }

    @GetMapping("/schemas/{schemaName}/tables/{tableName}/columns")
    public void getColumns(@PathVariable("id") Long connectionId,
                           @PathVariable("schemaName") String schemaName,
                           @PathVariable("tableName") String tableName) {
//        TODO
    }

    @GetMapping("/schemas/{schemaName}/tables/{tableName}")
    public void getDataPreview(@PathVariable("id") Long connectionId,
                               @PathVariable("schemaName") String schemaName,
                               @PathVariable("tableName") String tableName,
                               @RequestParam(required = false, defaultValue = "15") Integer count) {
//        TODO
    }

    @Autowired
    public void setDbConnectionService(DBConnectionService dbConnectionService) {
        this.dbConnectionService = dbConnectionService;
    }
}
