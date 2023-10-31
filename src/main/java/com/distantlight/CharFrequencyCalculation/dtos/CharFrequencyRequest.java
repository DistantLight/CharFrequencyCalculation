package com.distantlight.CharFrequencyCalculation.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharFrequencyRequest {
    @NotEmpty
    @NotNull
    @Size(max = 100)
    private String text;
}
