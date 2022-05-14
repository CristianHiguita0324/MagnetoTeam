package com.daecheve.infraestructure.repository.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author daecheve
 */
@Data
@Table(name = "mutant")
@Entity
public class MutantEntity implements Serializable {

    @Id
    private int id;
    private String dna;
    private byte isMutant;
}
