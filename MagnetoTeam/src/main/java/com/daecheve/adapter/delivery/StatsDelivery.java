package com.daecheve.adapter.delivery;

import com.daecheve.core.stats.model.Stats;
import com.daecheve.core.stats.service.StatsService;

/**
 *
 * @author daecheve
 */
public class StatsDelivery {

    private StatsService statsService;

    public StatsDelivery(StatsService statsService) {
        this.statsService = statsService;
    }

    public Stats getStats() {
        return statsService.getStats();
    }
}
