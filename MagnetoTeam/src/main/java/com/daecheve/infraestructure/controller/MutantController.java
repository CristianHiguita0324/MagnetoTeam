package com.daecheve.infraestructure.controller;

import com.daecheve.adapter.delivery.MutantDelivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daecheve
 */
@RestController
public class MutantController {

    Logger logger = LoggerFactory.getLogger(MutantController.class);

    @Autowired
    MutantDelivery mutantDelivery;

    @PostMapping(value = "/mutant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isMutant(@RequestBody String[] dna) {
        logger.info("Check DNA isMutant");
        Boolean answer = mutantDelivery.isMutant(dna);
        return new ResponseEntity<>(answer, Boolean.TRUE.equals(answer)
                ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }
}
