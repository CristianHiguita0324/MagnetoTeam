package com.daecheve.infraestructure.controller;

import com.daecheve.adapter.delivery.MutantDelivery;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author daecheve
 */
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class MutantControllerTest {

    @InjectMocks
    MutantController mutantController;

    @Mock
    MutantDelivery mutantDelivery;

    @Test
    void shouldIsMutantTrue() {
        when(mutantDelivery.isMutant(ArgumentMatchers.any())).thenReturn(true);

        ResponseEntity<Boolean> res = mutantController.isMutant(new String[1]);

        assertThat(res.getStatusCode().value()).isEqualTo(200);
    }

    @Test
    void shouldIsMutantFalse() {
        when(mutantDelivery.isMutant(ArgumentMatchers.any())).thenReturn(false);

        ResponseEntity<Boolean> res = mutantController.isMutant(new String[1]);

        assertThat(res.getStatusCode().value()).isEqualTo(403);
    }
}
