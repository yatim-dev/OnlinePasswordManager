package com.project.passmanager.main.algorithms.PasswordCheckerCommand;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PasswordCheckCommandExecutor {

    private final List<IPasswordCheckCommand> commands = Arrays.asList(
            new CheckMinimumLengthPasswordCommand(),
            new CheckMediumLengthCommand(),
            new CheckDigitsPasswordCommand(),
            new CheckLowerCaseAndUpperCasePasswordCommand(),
            new CheckSpecialCharactersPasswordCommand(),
            new CheckCommonPasswordCommand()
    );

    private static PasswordCheckCommandExecutor instance;

    private PasswordCheckCommandExecutor() {
    }

    public static PasswordCheckCommandExecutor getInstance() {
        if (instance == null) {
            instance = new PasswordCheckCommandExecutor();
        }
        return instance;
    }

    public Integer evaluatePasswordStrength(String password) {

        var rating = new ArrayList<Integer>();

        for (IPasswordCheckCommand command : commands) {
            rating.add(command.execute(password));
        }

        return rating.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
