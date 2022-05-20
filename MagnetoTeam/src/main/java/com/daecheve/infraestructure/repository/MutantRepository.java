package com.daecheve.infraestructure.repository;

import com.daecheve.infraestructure.repository.entity.MutantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daecheve
 */
@Repository
public interface MutantRepository extends JpaRepository<MutantEntity, Long> {

    long countByIsMutant(byte isMutant);
}
