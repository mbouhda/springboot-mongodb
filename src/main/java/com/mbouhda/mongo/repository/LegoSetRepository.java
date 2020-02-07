package com.mbouhda.mongo.repository;

import com.mbouhda.mongo.model.LegoSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegoSetRepository extends MongoRepository<LegoSet, String> {

}
