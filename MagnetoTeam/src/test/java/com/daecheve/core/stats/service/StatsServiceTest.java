package com.daecheve.core.stats.service;

import com.daecheve.core.mutant.service.MutantService;
import com.daecheve.core.stats.model.Stats;
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
public class StatsServiceTest {

    @InjectMocks
    StatsService statsService;

    @Mock
    MutantService mutantService;

    @Test
    void shouldGetStats() {
        when(mutantService.countByIsMutant(ArgumentMatchers.anyByte())).thenReturn((long) 15);

        Stats res = statsService.getStats();

        assertThat(res).isNotNull();
    }

    @Test
    void shouldGetStatsZero() {
        when(mutantService.countByIsMutant(ArgumentMatchers.anyByte())).thenReturn((long) 0);

        Stats res = statsService.getStats();

        assertThat(res).isNotNull();
    }
}
