package com.distantlight.CharFrequencyCalculation.services;

import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyRequest;
import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalculationServiceImpl implements CalculationService {
    @Override
    public CharFrequencyResponse getCharFrequency(CharFrequencyRequest request){
        String inputString = request.getText();
        String resultString = calculateCharFrequency(inputString);

        CharFrequencyResponse response = new CharFrequencyResponse();
        response.setResult(resultString);
        return response;
    }

    private static String calculateCharFrequency(String inputString) {
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for(char c : inputString.toCharArray()) {
            if(!charFrequencies.containsKey(c)) {
                charFrequencies.put(c, 0);
            }
            charFrequencies.put(c, charFrequencies.get(c) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedChars = new ArrayList<>(charFrequencies.entrySet());
        sortedChars.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder result = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : sortedChars) {
            result.append("'").append(entry.getKey()).append("': ").append(entry.getValue()).append(", ");
        }

        return result.substring(0, result.length() - 2);
    }
}
