package com.project.passmanager.main.algorithms.AES;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SaltReader {

    private final String filePath = "src/main/resources/salts.txt";

    public String getSalt() throws IOException {
        List<String> salts = readSaltsFromFile();
        var lineNumber = getRandomLine() % salts.size();
        return salts.get(lineNumber - 1);
    }

    private Integer getRandomLine() {
        var random = new Random();
        return random.nextInt(1000) + 1;
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
