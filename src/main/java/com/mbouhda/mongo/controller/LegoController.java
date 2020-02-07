package com.mbouhda.mongo.controller;

import com.mbouhda.mongo.model.LegoSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lego")
public class LegoController {

    private MongoTemplate mongoTemplate;

    public LegoController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping
    void insert(@RequestBody LegoSet legoSet) {
        mongoTemplate.insert(legoSet);
    }

    @GetMapping
    List<LegoSet> getAll() {
        return mongoTemplate.findAll(LegoSet.class);
    }
}
