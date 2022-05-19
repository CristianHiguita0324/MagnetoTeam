package com.daecheve.core.mutant.service;

import com.daecheve.core.mutant.port.MutantPort;
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
public class MutantServiceTest {

    @InjectMocks
    MutantService MutantService;

    @Mock
    MutantPort mutantPort;

    @Test
    void shouldIsMutantTrue() {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

        Boolean res = MutantService.isMutant(dna);

        assertThat(res).isTrue();
    }

    @Test
    void shouldIsMutantFalse() {
        String[] dna = {"TTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "TCCCTA", "TCACTG"};

        Boolean res = MutantService.isMutant(dna);

        assertThat(res).isFalse();
    }

    @Test
    void shouldIsMutantDnaError() {
        String[] dna = {"XTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "TCCCTA", "TCACTG"};

        Boolean res = MutantService.isMutant(dna);

        assertThat(res).isFalse();
    }

    @Test
    void shouldIsMutantDnaSizeZero() {
        String[] dna = {};

        Boolean res = MutantService.isMutant(dna);

        assertThat(res).isFalse();
    }

    @Test
    void shouldIsMutantDnaMatrizError() {
        String[] dna = {"TTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "TCCCTA"};

        Boolean res = MutantService.isMutant(dna);

        assertThat(res).isFalse();
    }

    @Test
    void shouldCountByIsMutant() {
        when(mutantPort.countByIsMutant(ArgumentMatchers.anyByte())).thenReturn((long) 15);

        long res = MutantService.countByIsMutant(Byte.parseByte("1"));

        assertThat(res).isGreaterThan(0);
    }
}
