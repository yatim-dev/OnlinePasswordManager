package com.project.passmanager.main.Entity;

public class DigitsCheckerCommand implements Command{
    EvaluatePasswordStrengthChecker checker;

    public DigitsCheckerCommand(EvaluatePasswordStrengthChecker checker) {
        this.checker = checker;
    }
    @Override
    public void execute(String password) {
        checker.digitsChecker(password);
    }
}
