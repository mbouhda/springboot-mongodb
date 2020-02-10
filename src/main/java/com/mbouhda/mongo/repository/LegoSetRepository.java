package com.mbouhda.mongo.repository;

import com.mbouhda.mongo.model.LegoSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegoSetRepository extends MongoRepository<LegoSet, String>, QuerydslPredicateExecutor<LegoSet> {

    List<LegoSet> findAllByThemeContains(String theme);

    @Query("{'delivery.deliveryFee' : {$lt : ?0}}")
    List<LegoSet> findByDeliveryFeeLessThan(int fee);
}
