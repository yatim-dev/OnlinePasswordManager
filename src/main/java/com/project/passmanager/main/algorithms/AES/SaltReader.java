package com.project.passmanager.main.algorithms.AES;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaltReader {

    private final String filePath = "src/main/resources/salts.txt";

    public String getSalt(String randomSaltNum) throws IOException {
        List<String> salts = readSaltsFromFile();
        var lineNumber = Integer.parseInt(randomSaltNum) % salts.size();
        return salts.get(lineNumber - 1);
    }

    private List<String> readSaltsFromFile() throws IOException {
        List<String> salts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                salts.add(line);
            }
        }

        return salts;
    }
}
