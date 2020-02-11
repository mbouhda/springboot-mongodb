package com.mbouhda.mongo.model.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AvgRating {

    private String id;
    private int avgRating;
    private String legoSetName;
}
