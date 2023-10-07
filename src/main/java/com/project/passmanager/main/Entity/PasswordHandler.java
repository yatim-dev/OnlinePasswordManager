package com.project.passmanager.main.Entity;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Класс `PasswordHandler` представляет собой реализацию интерфейса `IPasswordHandler` и предназначен для работы с паролями.
 * Он предоставляет методы для шифрования паролей и проверки соответствия хешированных паролей открытому.
 */
public class PasswordHandler implements IPasswordHandler {

    private static PasswordHandler instance;

    /**
     * Приватный конструктор, чтобы предотвратить создание экземпляров извне.
     */
    private PasswordHandler() {
    }

    public static PasswordHandler getInstance() {
        if (instance == null) {
            instance = new PasswordHandler();
        }
        return instance;
    }

    /**
     * Шифрует переданный пароль с использованием хеширования BCrypt и добавляет к нему случайно сгенерированные "перец" (pepper).
     *
     * @param password пароль, который нужно зашифровать
     * @return хешированный пароль с добавленным "перцем"
     */
    @Override
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt() + getPepper());
    }

    /**
     * Генерирует и возвращает случайно сгенерированные "перец" (pepper), которое может быть добавлено к хешированному паролю.
     *
     * @return случайно сгенерированные "перец"
     */
    private String getPepper() {
        return RandomStringUtils.random((int) (Math.random() * 100), true, true);
    }

    /**
     * Проверяет, соответствует ли заданный кандидат хешированному паролю.
     *
     * @param candidate кандидат на соответствие
     * @param hashed    хешированный пароль, с которым нужно сравнить кандидата
     * @return true, если кандидат соответствует хешированному паролю, иначе - false
     */
    @Override
    public Boolean isMatch(String candidate, String hashed) {
        return BCrypt.checkpw(candidate, hashed);
    }

    /**
     * Оценивает сложность пароля на основе нескольких критериев и возвращает баллы.
     *
     * @param password Пароль для оценки.
     * @return Баллы, оценивающие сложность пароля.
     */
    public int evaluatePasswordStrength(String password) {
        int strength = 0;

        // Критерий 1: Длина пароля
        if (password.length() >= 8) {
            strength += 2;
        }

        // Критерий 2: Дополнительный балл за более длинный пароль
        if (password.length() >= 12) {
            strength += 3;
        }

        // Критерий 3: Наличие цифр
        if (containsDigits(password)) {
            strength += 2;
        }

        // Критерий 4: Наличие букв в верхнем и нижнем регистре
        if (containsLowerCaseAndUpperCase(password)) {
            strength += 2;
        }

        // Критерий 5: Наличие специальных символов
        if (containsSpecialCharacters(password)) {
            strength += 3;
        }

        // Критерий 6: Отсутствие стандартных слов в пароле
        if (!containsCommonWords(password)) {
            strength += 4;
        }

        return strength;
    }

    /**
     * Проверяет, содержит ли пароль цифры.
     *
     * @param password Пароль для проверки.
     * @return true, если пароль содержит цифры, иначе - false.
     */
    private static boolean containsDigits(String password) {
        return password.matches(".*\\d.*");
    }

    /**
     * Проверяет, содержит ли пароль буквы в верхнем и нижнем регистре.
     *
     * @param password Пароль для проверки.
     * @return true, если пароль содержит буквы в обоих регистрах, иначе - false.
     */
    private boolean containsLowerCaseAndUpperCase(String password) {
        return password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");
    }

    /**
     * Проверяет, содержит ли пароль специальные символы.
     *
     * @param password Пароль для проверки.
     * @return true, если пароль содержит специальные символы, иначе - false.
     */
    private boolean containsSpecialCharacters(String password) {
        return password.matches(".*[!@#$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?].*");
    }


    /**
     * Проверяет, содержит ли пароль стандартные слова.
     *
     * @param password Пароль для проверки.
     * @return true, если пароль содержит общие слова, иначе - false.
     */
    private boolean containsCommonWords(String password) {
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
