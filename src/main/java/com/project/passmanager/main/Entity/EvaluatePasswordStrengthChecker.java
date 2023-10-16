package com.project.passmanager.main.Entity;

public class EvaluatePasswordStrengthChecker {

    public boolean minimumLenChecker(String password){
        return password.length() >= 8;
    }

    public boolean mediumLenChecker(String password){
        return password.length() >= 12;
    }

    /**
     * Проверяет, содержит ли пароль цифры.
     *
     * @param password Пароль для проверки.
     * @return true, если пароль содержит цифры, иначе - false.
     */
    public boolean digitsChecker(String password){ return password.matches(".*\\d.*"); }

    /**
     * Проверяет, содержит ли пароль буквы в верхнем и нижнем регистре.
     *
     * @param password Пароль для проверки.
     * @return true, если пароль содержит буквы в обоих регистрах, иначе - false.
     */
    public boolean lowerCaseAndUpperCaseChecker(String password){
        return password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");
    }

    /**
     * Проверяет, содержит ли пароль специальные символы.
     *
     * @param password Пароль для проверки.
     * @return true, если пароль содержит специальные символы, иначе - false.
     */
    public boolean specialCharactersChecker(String password){
        return password.matches(".*[!@#\\$%\\^&\\*\\(\\)_\\+\\-=<>\\?].*");
    }

    /**
     * Проверяет, содержит ли пароль стандартные слова.
     *
     * @param password Пароль для проверки.
     * @return true, если пароль содержит общие слова, иначе - false.
     */
    public boolean commonWordsChecker(String password){
        // Список известных общих паролей
        String[] commonPasswords = {"password", "admin", "123456", "qwerty", "letmein", "welcome", "123456789"};

        // Приведем пароль к нижнему регистру для сравнения без учета регистра
        password = password.toLowerCase();

        // Проверяем, содержится ли пароль в списке известных общих паролей
        for (String commonPassword : commonPasswords) {
            if (password.contains(commonPassword)) {
                return true;
            }
        }

        return false;
    }
}
