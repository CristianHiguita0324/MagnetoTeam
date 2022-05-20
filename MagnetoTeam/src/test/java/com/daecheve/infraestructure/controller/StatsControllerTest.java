package com.daecheve.infraestructure.controller;

import com.daecheve.adapter.delivery.StatsDelivery;
import com.daecheve.core.stats.model.Stats;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author daecheve
 */
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class StatsControllerTest {

    @InjectMocks
    StatsController statsController;

    @Mock
    StatsDelivery statsDelivery;

    @Test
    void shouldGetStats() {
        Stats stats = new Stats();
        stats.setCountMutantDna(15);
        stats.setCountHumanDna(20);
        stats.setRatio(0.75);

        when(statsDelivery.getStats()).thenReturn(stats);

        ResponseEntity<Stats> res = statsController.getStats();

        assertThat(res.getStatusCode().value()).isEqualTo(200);
    }
}
