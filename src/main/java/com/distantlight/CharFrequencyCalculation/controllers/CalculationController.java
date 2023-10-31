package com.distantlight.CharFrequencyCalculation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/text/analyze")
public class CalculationController {
    @PostMapping()
    public ResponseEntity<?> calculateCharFrequency(@RequestBody String string){
        return ResponseEntity.ok("hey");
    }
}
