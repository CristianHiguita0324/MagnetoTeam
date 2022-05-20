package com.daecheve.adapter.repository_adapter;

import com.daecheve.core.mutant.model.Mutant;
import com.daecheve.infraestructure.repository.MutantRepository;
import com.daecheve.infraestructure.repository.entity.MutantEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author daecheve
 */
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class MutantRepositoryAdapterTest {

    @InjectMocks
    MutantRepositoryAdapter mutantRepositoryAdapter;

    @Mock
    MutantRepository mutantRepository;

    @Test
    void shouldSave() {
        Mutant mutant = new Mutant();
        mutant.setDna("ACGT");
        mutant.setIsMutant(Byte.parseByte("1"));

        MutantEntity mutantEntity = new MutantEntity();
        mutantEntity.setId(1);
        mutantEntity.setDna("ACGT");
        mutantEntity.setIsMutant(Byte.parseByte("1"));

        when(mutantRepository.save(ArgumentMatchers.any())).thenReturn(mutantEntity);

        Mutant res = mutantRepositoryAdapter.save(mutant);

        assertThat(res).isNotNull();
    }

    @Test
    void shouldCountByIsMutant() {
        when(mutantRepository.countByIsMutant(Byte.parseByte("1"))).thenReturn((long) 15);

        long res = mutantRepositoryAdapter.countByIsMutant(Byte.parseByte("1"));

        assertThat(res).isGreaterThan(0);
    }
}
