package com.project.passmanager.main.algorithms.PasswordCheckerCommand;

public class CheckingMediumLenCommand implements IPasswordCheckerCommand {
    @Override
    public int execute(String password) {
        if (password.length() >= 12) return 8;
        else return 0;
    }
}
