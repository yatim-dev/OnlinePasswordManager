package com.project.passmanager.main.Entity;

public class MinimumLenCheckerCommand implements Command{
    EvaluatePasswordStrengthChecker checker;

    public MinimumLenCheckerCommand(EvaluatePasswordStrengthChecker checker) {
        this.checker = checker;
    }
    @Override
    public void execute(String password) {
        checker.minimumLenChecker(password);
    }
}
