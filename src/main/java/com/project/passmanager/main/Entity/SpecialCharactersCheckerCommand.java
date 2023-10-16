package com.project.passmanager.main.Entity;

public class SpecialCharactersCheckerCommand implements Command {
    EvaluatePasswordStrengthChecker checker;

    public SpecialCharactersCheckerCommand(EvaluatePasswordStrengthChecker checker) {
        this.checker = checker;
    }
    @Override
    public void execute(String password) {
        checker.specialCharactersChecker(password);
    }
}
