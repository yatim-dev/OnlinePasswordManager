package com.project.passmanager.main.algorithms.PasswordCheckerCommand;

public class CheckingCommonPasswordCommand implements IPasswordCheckerCommand {

    /**
     * Проверяет, содержит ли пароль стандартные слова.
     *
     * @param password Пароль для проверки.
     * @return -40, если пароль содержит общие слова, иначе - 15.
     */
    @Override
    public int execute(String password) {
        // Список известных общих паролей
        String[] commonPasswords = {"password", "admin", "123456", "qwerty", "letmein", "welcome", "123456789"};

        // Приведем пароль к нижнему регистру для сравнения без учета регистра
        password = password.toLowerCase();

        // Проверяем, содержится ли пароль в списке известных общих паролей
        for (String commonPassword : commonPasswords) {
            if (password.contains(commonPassword)) {
                return -40;
            }
        }

        return 15;
    }
}
