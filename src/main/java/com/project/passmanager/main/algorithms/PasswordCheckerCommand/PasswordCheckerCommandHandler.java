package com.project.passmanager.main.algorithms.PasswordCheckerCommand;


import java.util.Arrays;


public class PasswordCheckerCommandHandler {
    private static PasswordCheckerCommandHandler instance;

    private PasswordCheckerCommandHandler() {}

    public static PasswordCheckerCommandHandler getInstance() {
        if (instance == null) {
            instance = new PasswordCheckerCommandHandler();
        }
        return instance;
    }

    public Integer getMark(String password) {
        var runner = Arrays.asList(
                new CheckingMinimumLenPasswordCommand().execute(password),
                new CheckingMediumLenCommand().execute(password),
                new CheckingDigitsPasswordCommand().execute(password),
                new CheckingLowerCaseAndUpperCasePasswordCommand().execute(password),
                new CheckingSpecialCharactersPasswordCommand().execute(password),
                new CheckingCommonPasswordCommand().execute(password)
        );
        return runner.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
