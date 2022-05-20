package com.daecheve.infraestructure.controller;

import com.daecheve.adapter.delivery.StatsDelivery;
import com.daecheve.core.stats.model.Stats;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daecheve
 */
@RestController
public class StatsController {

    Logger logger = LoggerFactory.getLogger(StatsController.class);

    @Autowired
    StatsDelivery statsDelivery;

    @Operation(summary = "Get all stats")
    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stats> getStats() {
        logger.info("Getting all stats");
        return new ResponseEntity<>(statsDelivery.getStats(), HttpStatus.OK);
    }
}
