package com.distantlight.CharFrequencyCalculation.controllers;

import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyRequest;
import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyResponse;
import com.distantlight.CharFrequencyCalculation.services.CalculationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chars/counting")
public class CalculationController {
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping()
    public CharFrequencyResponse getCharFrequency(@Valid @RequestBody CharFrequencyRequest request){
        return calculationService.getCharFrequency(request);
    }
}
