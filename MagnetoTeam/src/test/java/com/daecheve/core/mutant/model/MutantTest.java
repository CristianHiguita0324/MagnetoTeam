package com.daecheve.core.mutant.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author daecheve
 */
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class MutantTest {

    @Test
    void testMutant() {
        Mutant mutant = new Mutant();
        mutant.setId(0);
    }
}
