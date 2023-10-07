package com.project.passmanager.main.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Singleton класс `PasswordGenerator` предоставляет возможность генерировать пароли с разными параметрами.
 * Пользователь может настроить включение/выключение использования нижнего регистра, верхнего регистра,
 * цифр и специальных символов при генерации пароля.
 */
public class PasswordGenerator {
    private static PasswordGenerator instance;
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    private boolean useLower = false;
    private boolean useUpper = false;
    private boolean useDigits = false;
    private boolean useSpecialCharacters = false;

    /**
     * Приватный конструктор, чтобы предотвратить создание экземпляров извне.
     */
    private PasswordGenerator() {}

    public static PasswordGenerator getInstance() {
        if (instance == null) {
            instance = new PasswordGenerator();
        }
        return instance;
    }

    /**
     * Включает использование символов нижнего регистра при генерации пароля.
     *
     * @return Объект `PasswordGenerator` с включенным использованием символов нижнего регистра.
     */
    public PasswordGenerator useLower() {
        this.useLower = true;
        return this;
    }

    /**
     * Включает использование символов верхнего регистра при генерации пароля.
     *
     * @return Объект `PasswordGenerator` с включенным использованием символов верхнего регистра.
     */
    public PasswordGenerator useUpper() {
        this.useUpper = true;
        return this;
    }

    /**
     * Включает использование цифр при генерации пароля.
     *
     * @return Объект `PasswordGenerator` с включенным использованием цифр.
     */
    public PasswordGenerator useDigits() {
        this.useDigits = true;
        return this;
    }

    /**
     * Включает использование специальных символов при генерации пароля.
     *
     * @return Объект `PasswordGenerator` с включенным использованием специальных символов.
     */
    public PasswordGenerator useSpecialCharacters() {
        this.useSpecialCharacters = true;
        return this;
    }

    /**
     * Генерирует пароль заданной длины с учетом настроек.
     *
     * @param length Длина генерируемого пароля.
     * @return Сгенерированный пароль.
     */
    public String build(int length) {
        if ((length <= 0) || (!useLower && !useUpper && !useDigits && !useSpecialCharacters)) {
            resetFlags();
            return "";
        }

        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

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

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        resetFlags();
        return new String(password);
    }

    /**
     * Сбрасывает все установленные флаги использования символов (нижний регистр, верхний регистр,
     * цифры, специальные символы) к исходному состоянию.
     */
    private void resetFlags() {
        this.useLower = false;
        this.useUpper = false;
        this.useDigits = false;
        this.useSpecialCharacters = false;
    }
}


