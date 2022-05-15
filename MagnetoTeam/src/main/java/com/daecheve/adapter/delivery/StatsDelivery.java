package com.daecheve.adapter.delivery;

import com.daecheve.core.stats.model.StatsModel;
import com.daecheve.core.stats.service.StatsService;
import java.util.List;

/**
 *
 * @author daecheve
 */
public class StatsDelivery {

    private StatsService statsService;

    public StatsDelivery(StatsService statsService) {
        this.statsService = statsService;
    }

    public List<StatsModel> getStats() {
        return statsService.getStats();
    }
}
