package com.project.passmanager.main.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    private boolean useLower = false;
    private boolean useUpper = false;
    private boolean useDigits = false;
    private boolean useSpecialCharacters = false;

    public PasswordGenerator useLower(){
        this.useLower = true;
        return this;
    }

    public PasswordGenerator useUpper(){
        this.useUpper = true;
        return this;
    }

    public PasswordGenerator useDigits(){
        this.useDigits = true;
        return this;
    }

    public PasswordGenerator useSpecialCharacters(){
        this.useSpecialCharacters = true;
        return this;
    }

    public String build(int length){
        if (length <= 0) {
            return "";
        }

        // Variables.
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        // Collect the categories to use.
        List<String> charCategories = new ArrayList<>(4);
        if (useLower) {
            charCategories.add(LOWERCASE);
        }
        if (useUpper) {
            charCategories.add(UPPERCASE);
        }
        if (useDigits) {
            charCategories.add(DIGITS);
        }
        if (useSpecialCharacters) {
            charCategories.add(SPECIAL_CHARACTERS);
        }

        // Build the password.
        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        useLower = false;
        useUpper = false;
        useDigits = false;
        useSpecialCharacters = false;

        return new String(password);
    }
}


