package com.banking.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataReader {

    public static Map<String, String> readTestData(String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            return objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<Map<String, String>>() {
                    }
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to read test data file: " + filePath,
                    e
            );
        }
    }
}