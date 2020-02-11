package com.mbouhda.mongo.service;

import com.mbouhda.mongo.model.LegoSet;
import com.mbouhda.mongo.model.projection.AvgRating;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private MongoTemplate mongoTemplate;


    public ReportService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<AvgRating> getAvgRatings() {
        ProjectionOperation projection = Aggregation.project()
                .andExpression("name").as("legoSetName")
                .andExpression("{ $avg : '$reviews.rating' }").as("avgRating");
        Aggregation avgRatingAggregation = Aggregation.newAggregation(LegoSet.class, projection);

        return mongoTemplate.aggregate(avgRatingAggregation, LegoSet.class, AvgRating.class).getMappedResults();
    }
}
