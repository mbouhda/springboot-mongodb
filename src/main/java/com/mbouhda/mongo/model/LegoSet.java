package com.mbouhda.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "legosets")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class LegoSet {

    @Id
    private String id;

    @TextIndexed
    private String name;
    private LegoSetDifficulty difficulty;

    @Indexed
    private String theme;
    private List<ProductReview> reviews = new ArrayList<>();

    @Field("delivery")
    private DeliveryInfo deliveryInfo;

}
