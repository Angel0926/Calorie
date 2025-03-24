package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateTest {

    @Test
    void testLocalDateSerialization() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        LocalDate date = LocalDate.now();
        String json = objectMapper.writeValueAsString(date);
        System.out.println(json);
    }
}
