package com.distantlight.CharFrequencyCalculation.services;

import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyRequest;
import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyResponse;

public interface CalculationService {
    CharFrequencyResponse getCharFrequency(CharFrequencyRequest request);
}
