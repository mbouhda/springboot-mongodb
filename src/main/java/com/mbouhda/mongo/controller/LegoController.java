package com.mbouhda.mongo.controller;

import com.mbouhda.mongo.model.LegoSet;
import com.mbouhda.mongo.model.QLegoSet;
import com.mbouhda.mongo.repository.LegoSetRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
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
        Sort sortByThemeAsc = Sort.by("theme").ascending();
        return repository.findAll(sortByThemeAsc);
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

    @GetMapping("/{id}")
    LegoSet byId(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/byTheme/{theme}")
    List<LegoSet> allByTheme(@PathVariable String theme) {
        return repository.findAllByThemeContains(theme);
    }

    @GetMapping("/byDeliveryFeeLessThan/{fee}")
    List<LegoSet> byDeliveryFeeLessThan(@PathVariable int fee) {
        return repository.findByDeliveryFeeLessThan(fee);
    }

    @GetMapping("/all/bestSoldSets")
    List<LegoSet> getBestSets() {
        QLegoSet legoSet = new QLegoSet("query");

        Predicate isInStock = legoSet.deliveryInfo.inStock.isTrue();
        Predicate deliveryFeeFilter = legoSet.deliveryInfo.deliveryFee.lt(4);
        Predicate hasGoodReviews = legoSet.reviews.any().rating.between(7, 10);

        Predicate bestSetsFilter = ((BooleanExpression) isInStock)
                .and(deliveryFeeFilter)
                .and(hasGoodReviews);

        return (List<LegoSet>) repository.findAll(bestSetsFilter);
    }

    @GetMapping("fullTextSearch/{text}")
    List<LegoSet> fullTextSearch(@PathVariable String text) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(text);
        return repository.findAllBy(textCriteria);
    }

}
