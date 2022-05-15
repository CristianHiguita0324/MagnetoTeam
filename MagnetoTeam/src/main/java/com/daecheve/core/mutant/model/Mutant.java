package com.daecheve.core.mutant.model;

import lombok.Data;

/**
 *
 * @author daecheve
 */
@Data
public class Mutant {

    private long id;
    private String dna;
    private byte isMutant;
}
