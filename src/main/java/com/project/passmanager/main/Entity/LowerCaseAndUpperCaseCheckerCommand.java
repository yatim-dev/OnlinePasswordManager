package com.project.passmanager.main.Entity;

public class LowerCaseAndUpperCaseCheckerCommand implements Command{
    EvaluatePasswordStrengthChecker checker;

    public LowerCaseAndUpperCaseCheckerCommand(EvaluatePasswordStrengthChecker checker) {
        this.checker = checker;
    }
    @Override
    public void execute(String password) {
        checker.lowerCaseAndUpperCaseChecker(password);
    }
}
