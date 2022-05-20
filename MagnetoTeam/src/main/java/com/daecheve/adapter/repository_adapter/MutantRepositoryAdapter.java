package com.daecheve.adapter.repository_adapter;

import com.daecheve.adapter.utility.ModelMapperUtility;
import com.daecheve.core.mutant.model.Mutant;
import com.daecheve.core.mutant.port.MutantPort;
import com.daecheve.infraestructure.repository.MutantRepository;
import com.daecheve.infraestructure.repository.entity.MutantEntity;

/**
 *
 * @author daecheve
 */
public class MutantRepositoryAdapter implements MutantPort {

    private MutantRepository mutantRepository;

    public MutantRepositoryAdapter(MutantRepository mutantRepository) {
        this.mutantRepository = mutantRepository;
    }

    @Override
    public Mutant save(Mutant mutant) {
        return ModelMapperUtility.map(mutantRepository.save
        (ModelMapperUtility.map(mutant, MutantEntity.class)), Mutant.class);
    }

    @Override
    public long countByIsMutant(byte isMutant) {
        return mutantRepository.countByIsMutant(isMutant);
    }
}
