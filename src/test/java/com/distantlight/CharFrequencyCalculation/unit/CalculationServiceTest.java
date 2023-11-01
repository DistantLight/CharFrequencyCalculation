package com.distantlight.CharFrequencyCalculation.unit;

import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyRequest;
import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyResponse;
import com.distantlight.CharFrequencyCalculation.services.CalculationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {
    @InjectMocks
    private CalculationServiceImpl calculationService;

    @Test
    void shouldCalculateFrequencyCorrectly() {
        //given
        CharFrequencyRequest request = new CharFrequencyRequest();
        request.setText("aaaabbc");

        //when
        CharFrequencyResponse response = calculationService.getCharFrequency(request);

        //then
        assertEquals("'a': 4, 'b': 2, 'c': 1", response.getResult());
    }

}