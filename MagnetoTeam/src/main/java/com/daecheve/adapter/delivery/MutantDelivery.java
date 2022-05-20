package com.daecheve.adapter.delivery;

import com.daecheve.core.mutant.service.MutantService;

/**
 *
 * @author daecheve
 */
public class MutantDelivery {

    private MutantService mutantService;

    public MutantDelivery(MutantService mutantService) {
        this.mutantService = mutantService;
    }

    public Boolean isMutant(String[] dna) {
        return mutantService.isMutant(dna);
    }
}
