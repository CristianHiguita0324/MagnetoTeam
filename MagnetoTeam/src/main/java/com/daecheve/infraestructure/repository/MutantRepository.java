package com.daecheve.infraestructure.repository;

import com.daecheve.infraestructure.repository.entity.MutantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daecheve
 */
@Repository
public interface MutantRepository extends CrudRepository<MutantEntity, Integer> {

}
