package com.ataccama.test.testtask.controller;

import com.ataccama.test.testtask.service.DBConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/connection/{id}")
public class DBConnectionExplorerController {

    @Autowired
    private DBConnectionService dbConnectionService;

    @GetMapping("/tables")
    public void getTables(@PathVariable("id") Long id) {

    }

}
