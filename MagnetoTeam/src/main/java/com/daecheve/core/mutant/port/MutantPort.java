package com.daecheve.core.mutant.port;

import com.daecheve.core.mutant.model.MutantModel;
import java.util.List;

/**
 *
 * @author daecheve
 */
public interface MutantPort {

    public MutantModel save(MutantModel mutantModel);

    public List<MutantModel> findAll();
}
