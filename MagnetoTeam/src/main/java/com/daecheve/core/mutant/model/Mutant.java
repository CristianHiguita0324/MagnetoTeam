package com.daecheve.core.mutant.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author daecheve
 */
@Getter
@Setter
public class Mutant {

    private long id;
    private String dna;
    private byte isMutant;
}
