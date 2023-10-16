package com.project.passmanager.main.Entity;

public class MediumLenCheckerCommand implements Command{
    EvaluatePasswordStrengthChecker checker;

    public MediumLenCheckerCommand(EvaluatePasswordStrengthChecker checker) {
        this.checker = checker;
    }
    @Override
    public void execute(String password) {
        checker.mediumLenChecker(password);
    }
}
