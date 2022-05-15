package com.daecheve.core.stats.service;

import com.daecheve.core.mutant.model.MutantModel;
import com.daecheve.core.mutant.service.MutantService;
import com.daecheve.core.stats.model.StatsModel;
import java.util.List;

/**
 *
 * @author daecheve
 */
public class StatsService {

    private MutantService mutantService;

    public StatsService(MutantService mutantService) {
        this.mutantService = mutantService;
    }

    public List<StatsModel> getStats() {
        List<MutantModel> listMutant = mutantService.findAllMutant();
        return null;
    }
}
