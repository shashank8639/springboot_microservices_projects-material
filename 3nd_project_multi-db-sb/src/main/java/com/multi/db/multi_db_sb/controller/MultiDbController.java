package com.multi.db.multi_db_sb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.multi.db.multi_db_sb.service.MultiDbService;

@RestController
@RequestMapping("/api/databases")
public class MultiDbController {

    private final MultiDbService service;

    public MultiDbController(MultiDbService service) {
        this.service = service;
    }

    @PostMapping("/tables")
    public String createTables() {
        service.createTables();
        return "Tables created successfully";
    }

    @PostMapping("/insert")
    public String insertData() {
        service.insertData();
        return "Data inserted successfully";
    }

    @GetMapping("/customers")
    public Map<String, List<Map<String, Object>>> customers() {
        return service.fetchData();
    }
}