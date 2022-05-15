package com.daecheve.infraestructure.controller;

import com.daecheve.adapter.delivery.StatsDelivery;
import com.daecheve.core.stats.model.Stats;
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

    @Autowired
    StatsDelivery statsDelivery;

    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stats> getStats() {
        return new ResponseEntity<>(statsDelivery.getStats(), HttpStatus.OK);
    }
}
