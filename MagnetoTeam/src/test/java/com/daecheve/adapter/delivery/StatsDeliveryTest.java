package com.daecheve.adapter.delivery;

import com.daecheve.core.stats.model.Stats;
import com.daecheve.core.stats.service.StatsService;
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
public class StatsDeliveryTest {

    @InjectMocks
    StatsDelivery statsDelivery;

    @Mock
    StatsService statsService;

    @Test
    void shouldGetStats() {
        when(statsService.getStats()).thenReturn(new Stats());

        Stats res = statsDelivery.getStats();

        assertThat(res).isNotNull();
    }
}
