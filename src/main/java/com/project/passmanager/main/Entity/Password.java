package com.project.passmanager.main.Entity;

public interface Password {
    /**
     * Шифрует пароль.
     *
     * @param plaintext Пароль в открытом тексте.
     * @return Зашифрованный пароль.
     */
    String encrypt(String plaintext);

    /**
     * Дешифрует пароль.
     *
     * @param encrypted Зашифрованный пароль.
     * @return Пароль в открытом тексте.
     */
    String decrypt(String encrypted);

    /**
     * Создает соль для пароля.
     *
     * @return Соль для пароля.
     */
    String generateSalt();

    /**
     * Получает хэш пароля с использованием соли.
     *
     * @param password Пароль в открытом тексте.
     * @param salt     Соль для пароля.
     * @return Хэш пароля.
     */
    String hashPassword(String password, String salt);
}
