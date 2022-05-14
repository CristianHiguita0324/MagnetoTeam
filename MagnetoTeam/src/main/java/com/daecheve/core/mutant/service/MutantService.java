package com.daecheve.core.mutant.service;

import com.daecheve.core.mutant.model.MutantModel;
import com.daecheve.core.mutant.port.MutantPort;

/**
 *
 * @author daecheve
 */
public class MutantService {

    private MutantPort mutantPort;

    public MutantService(MutantPort mutantPort) {
        this.mutantPort = mutantPort;
    }
    
    public Boolean isMutant(String[] dna) {

        MutantModel mutantModel = new MutantModel();
        mutantModel.setDna(dna.toString());
        mutantModel.setIsMutant(Byte.parseByte("1"));

        mutantPort.save(mutantModel);

        return true;
    }
}
