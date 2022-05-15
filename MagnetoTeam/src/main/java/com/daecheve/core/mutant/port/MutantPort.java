package com.daecheve.core.mutant.port;

import com.daecheve.core.mutant.model.Mutant;

/**
 *
 * @author daecheve
 */
public interface MutantPort {

    public Mutant save(Mutant mutant);

    public long countByIsMutant(byte isMutant);
}
