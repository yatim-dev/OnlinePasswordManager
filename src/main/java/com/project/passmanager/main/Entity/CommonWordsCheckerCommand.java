package com.project.passmanager.main.Entity;

public class CommonWordsCheckerCommand implements Command{
    EvaluatePasswordStrengthChecker checker;

    public CommonWordsCheckerCommand(EvaluatePasswordStrengthChecker checker) {
        this.checker = checker;
    }

    @Override
    public void execute(String password) {
        checker.commonWordsChecker(password);
    }
}
