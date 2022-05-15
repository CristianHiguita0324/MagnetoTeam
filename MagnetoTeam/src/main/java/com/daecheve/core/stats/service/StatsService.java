package com.daecheve.core.stats.service;

import com.daecheve.core.mutant.service.MutantService;
import com.daecheve.core.stats.model.Stats;

/**
 *
 * @author daecheve
 */
public class StatsService {

    private MutantService mutantService;

    public StatsService(MutantService mutantService) {
        this.mutantService = mutantService;
    }

    public Stats getStats() {
        Stats stats = new Stats();
        stats.setCountMutantDna(mutantService.countByIsMutant(Byte.parseByte("1")));
        stats.setCountHumanDna(mutantService.countByIsMutant(Byte.parseByte("0")));
        stats.setRatio((double) stats.getCountMutantDna() / stats.getCountHumanDna());
        return stats;
    }
}
