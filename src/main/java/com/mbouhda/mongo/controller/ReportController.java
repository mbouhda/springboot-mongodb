package com.mbouhda.mongo.controller;

import com.mbouhda.mongo.model.projection.AvgRating;
import com.mbouhda.mongo.service.ReportService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/lego/reports")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/avgRatings")
    List<AvgRating> getAll() {
        Sort sortByThemeAsc = Sort.by("theme").ascending();
        return reportService.getAvgRatings();
    }
}
