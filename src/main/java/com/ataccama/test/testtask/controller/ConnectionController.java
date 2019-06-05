package com.ataccama.test.testtask.controller;

import com.ataccama.test.testtask.model.DBConnection;
import com.ataccama.test.testtask.model.exception.UnsupportedProviderException;
import com.ataccama.test.testtask.model.metadata.DBSchema;
import com.ataccama.test.testtask.service.DBConnectionService;
import com.ataccama.test.testtask.service.DbMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ConnectionController {

    private DBConnectionService dbConnectionService;

    private DbMetadataService dbMetadataService;


    @GetMapping("/connections")
    public String getConnections(Model model) {
        List<DBConnection> dbConnections = dbConnectionService.findAll();
        model.addAttribute("connections", dbConnections);
        return "connections";
    }

    @GetMapping(value = "/connections/{id}")
    public String getConnectionById(@PathVariable("id") Long id, Model model) throws UnsupportedProviderException {
        DBConnection dbConnection = dbConnectionService.findById(id);
        List<DBSchema> dbSchema = dbMetadataService.findAllSchemas(id);
        model.addAttribute("connection", dbConnection);
        model.addAttribute("schemas", dbSchema);
        return "connection";
    }


    @Autowired
    public void setDbConnectionService(DBConnectionService dbConnectionService) {
        this.dbConnectionService = dbConnectionService;
    }

    @Autowired
    public void setDbMetadataService(DbMetadataService dbMetadataService) {
        this.dbMetadataService = dbMetadataService;
    }
}
