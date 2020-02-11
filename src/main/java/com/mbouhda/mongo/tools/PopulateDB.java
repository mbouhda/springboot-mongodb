package com.mbouhda.mongo.tools;

import com.mbouhda.mongo.model.DeliveryInfo;
import com.mbouhda.mongo.model.LegoSet;
import com.mbouhda.mongo.model.LegoSetDifficulty;
import com.mbouhda.mongo.model.ProductReview;
import com.mbouhda.mongo.repository.LegoSetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class PopulateDB implements CommandLineRunner {

    private final static Logger LOG = LoggerFactory.getLogger(PopulateDB.class);

    private LegoSetRepository repository;

    public PopulateDB(LegoSetRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
        LOG.info("Legoset database was cleaned.");

        LegoSet car = LegoSet.builder()
                .name("Police Car")
                .difficulty(LegoSetDifficulty.MEDIUM)
                .theme("city")
                .reviews(Arrays.asList(new ProductReview("John", 7),
                        new ProductReview("Doe", 9) ))
                .deliveryInfo(new DeliveryInfo(LocalDate.now(), 5, true))
                .build();

        LegoSet scooter = LegoSet.builder()
                .name("Fire Rescue Water Scooter")
                .difficulty(LegoSetDifficulty.HARD)
                .theme("city")
                .reviews(Arrays.asList(new ProductReview("Jack", 7),
                        new ProductReview("Maa", 4) ))
                .deliveryInfo(new DeliveryInfo(LocalDate.now(), 2, true))
                .build();

        LegoSet fighter = LegoSet.builder()
                .name("Poe Dameron's X-wing Fighter")
                .difficulty(LegoSetDifficulty.MEDIUM)
                .theme("star wars")
                .reviews(Arrays.asList(new ProductReview("Jacky", 7),
                        new ProductReview("Chan", 6) ))
                .deliveryInfo(new DeliveryInfo(LocalDate.now(), 3, true))
                .build();

        List<LegoSet> legoSets = Arrays.asList(car, scooter, fighter);
        repository.insert(legoSets);
        LOG.info("Legoset database was populated.");
    }
}
