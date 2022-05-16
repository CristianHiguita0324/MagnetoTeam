package com.daecheve.core.stats.model;

import lombok.Data;

/**
 *
 * @author daecheve
 */
@Data
public class Stats {

    private long countMutantDna;
    private long countHumanDna;
    private double ratio;
}