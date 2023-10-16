package com.project.passmanager.main.algorithms;

public class PasswordSettings {
    private int passwordLength;
    private boolean useLower;
    private boolean useUpper;
    private boolean useDigits;
    private boolean useSpecialCharacters;

    public int getPasswordLength() {
        return passwordLength;
    }

    public boolean isUseLower() {
        return useLower;
    }

    public boolean isUseUpper() {
        return useUpper;
    }

    public boolean isUseDigits() {
        return useDigits;
    }

    public boolean isUseSpecialCharacters() {
        return useSpecialCharacters;
    }

    /**
     * Включает использование символов нижнего регистра при генерации пароля.
     *
     * @return Объект `PasswordGenerator` с включенным использованием символов нижнего регистра.
     */

    public PasswordSettings useLower() {
        this.useLower = true;
        return this;
    }

    /**
     * Включает использование символов верхнего регистра при генерации пароля.
     *
     * @return Объект `PasswordGenerator` с включенным использованием символов верхнего регистра.
     */
    public PasswordSettings useUpper() {
        this.useUpper = true;
        return this;
    }

    /**
     * Включает использование цифр при генерации пароля.
     *
     * @return Объект `PasswordGenerator` с включенным использованием цифр.
     */
    public PasswordSettings useDigits() {
        this.useDigits = true;
        return this;
    }

    /**
     * Включает использование специальных символов при генерации пароля.
     *
     * @return Объект `PasswordGenerator` с включенным использованием специальных символов.
     */
    public PasswordSettings useSpecialCharacters() {
        this.useSpecialCharacters = true;
        return this;
    }

    public PasswordSettings passwordLength(int passwordLength) {
        this.passwordLength = passwordLength;
        return this;
    }
}
