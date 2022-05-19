package com.daecheve.core.stats.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author daecheve
 */
@Setter
@Getter
public class Stats {

    private long countMutantDna;
    private long countHumanDna;
    private double ratio;
}
