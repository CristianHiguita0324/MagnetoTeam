package com.daecheve.adapter.repository_adapter;

import com.daecheve.infraestructure.repository.MutantRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
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
    void shouldCountByIsMutant() {
        when(mutantRepository.countByIsMutant(Byte.parseByte("1"))).thenReturn((long) 15);

        long res = mutantRepositoryAdapter.countByIsMutant(Byte.parseByte("1"));

        assertThat(res).isGreaterThan(0);
    }
}
