package com.mbouhda.mongo.controller;

import com.mbouhda.mongo.model.LegoSet;
import com.mbouhda.mongo.repository.LegoSetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lego")
public class LegoController {

    private LegoSetRepository repository;

    public LegoController(LegoSetRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<LegoSet> getAll() {
        return repository.findAll();
    }

    @PostMapping
    void insert(@RequestBody LegoSet legoSet) {
        repository.insert(legoSet);
    }

    @PutMapping
    void update(@RequestBody LegoSet legoSet) {
        repository.save(legoSet);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
