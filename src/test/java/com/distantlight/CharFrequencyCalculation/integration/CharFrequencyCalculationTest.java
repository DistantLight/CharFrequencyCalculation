package com.distantlight.CharFrequencyCalculation.integration;

import com.distantlight.CharFrequencyCalculation.config.TestConfig;
import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyRequest;
import com.distantlight.CharFrequencyCalculation.dtos.CharFrequencyResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestConfig.class)
class CharFrequencyCalculationTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/v1/chars/counting";

    @Test
    public void getFrequencyForValidInput() {
        //given
        CharFrequencyRequest request = new CharFrequencyRequest();
        request.setText("aaaabbc");

        //when
        ResponseEntity<CharFrequencyResponse> response =
                restTemplate.postForEntity(URL, request, CharFrequencyResponse.class);

        //then
        assertEquals(200, response.getStatusCodeValue());
        CharFrequencyResponse body = response.getBody();
        assertEquals("'a': 4, 'b': 2, 'c': 1", body.getResult());
    }

    @Test
    public void getFrequencyForEmptyInput() {
        //given
        CharFrequencyRequest request = new CharFrequencyRequest();
        request.setText("");

        //when
        ResponseEntity<CharFrequencyResponse> response =
                restTemplate.postForEntity(URL, request, CharFrequencyResponse.class);

        //then
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void getFrequencyForInputMoreThenMaxSize() {
        //given
        CharFrequencyRequest request = new CharFrequencyRequest();
        request.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        //when
        ResponseEntity<CharFrequencyResponse> response =
                restTemplate.postForEntity(URL, request, CharFrequencyResponse.class);

        //then
        assertEquals(400, response.getStatusCodeValue());
    }
}