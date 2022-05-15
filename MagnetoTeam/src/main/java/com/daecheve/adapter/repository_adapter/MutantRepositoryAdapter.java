package com.daecheve.adapter.repository_adapter;

import com.daecheve.core.mutant.model.MutantModel;
import com.daecheve.core.mutant.port.MutantPort;
import com.daecheve.infraestructure.repository.MutantRepository;
import com.daecheve.infraestructure.repository.entity.MutantEntity;
import java.util.List;

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
    public MutantModel save(MutantModel mutantModel) {
        MutantEntity mutantEntity = new MutantEntity();
        mutantEntity.setDna(mutantModel.getDna());
        mutantEntity.setIsMutant(mutantModel.getIsMutant());

        MutantEntity mutantEntityAnswer = mutantRepository.save(mutantEntity);
        MutantModel mutantModelAnswer = new MutantModel();
        mutantModelAnswer.setId(mutantEntityAnswer.getId());
        mutantModelAnswer.setDna(mutantEntityAnswer.getDna());
        mutantModelAnswer.setIsMutant(mutantEntityAnswer.getIsMutant());

        return mutantModelAnswer;
    }

    @Override
    public List<MutantModel> findAll() {
        Iterable<MutantEntity> itMutant = mutantRepository.findAll();
        
        return null;
    }
}
