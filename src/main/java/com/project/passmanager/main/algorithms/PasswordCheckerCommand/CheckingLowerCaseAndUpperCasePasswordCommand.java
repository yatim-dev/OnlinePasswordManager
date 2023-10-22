package com.project.passmanager.main.algorithms.PasswordCheckerCommand;

public class CheckingLowerCaseAndUpperCasePasswordCommand implements IPasswordCheckerCommand {

    /**
     * Проверяет, содержит ли пароль буквы в верхнем и нижнем регистре.
     *
     * @param password Пароль для проверки.
     * @return 12, если пароль содержит буквы в обоих регистрах, иначе - 0.
     */
    @Override
    public int execute(String password) {
        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) return 12;
        else return 0;
    }
}
