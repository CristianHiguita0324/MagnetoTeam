package com.daecheve.adapter.delivery;

import com.daecheve.core.mutant.service.MutantService;
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
public class MutantDeliveryTest {

    @InjectMocks
    MutantDelivery mutantDelivery;

    @Mock
    MutantService mutantService;

    @Test
    void shouldIsMutant() {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

        when(mutantService.isMutant(ArgumentMatchers.any())).thenReturn(true);

        Boolean res = mutantDelivery.isMutant(dna);

        assertThat(res).isTrue();
    }
}
