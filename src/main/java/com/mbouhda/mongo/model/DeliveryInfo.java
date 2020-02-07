package com.mbouhda.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {

    private LocalDate deliveryDate;
    private int deliveryFee;
    private boolean inStock;
}
