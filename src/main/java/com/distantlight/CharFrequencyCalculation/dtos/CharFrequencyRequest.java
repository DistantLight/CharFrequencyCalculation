package com.distantlight.CharFrequencyCalculation.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharFrequencyRequest {
    private String text;
}
