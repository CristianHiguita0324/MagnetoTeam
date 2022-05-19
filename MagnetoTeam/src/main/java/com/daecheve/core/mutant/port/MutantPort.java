package com.daecheve.core.mutant.port;

import com.daecheve.core.mutant.model.Mutant;

/**
 *
 * @author daecheve
 */
public interface MutantPort {

    Mutant save(Mutant mutant);

    long countByIsMutant(byte isMutant);
}
