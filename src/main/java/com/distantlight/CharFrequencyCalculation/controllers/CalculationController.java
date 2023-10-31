package com.distantlight.CharFrequencyCalculation.controllers;

import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyRequest;
import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/text/analyze")
public class CalculationController {
    @PostMapping()
    public ResponseEntity<?> calculateCharFrequency(@RequestBody CharFrequencyRequest request){
        CharFrequencyResponse response = new CharFrequencyResponse();
        response.setResult(request.getText());
        return ResponseEntity.ok(response);
    }
}
