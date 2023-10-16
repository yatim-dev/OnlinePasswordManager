package com.project.passmanager.main.Entity;

public class CommandHandler {
    Command checkMinimumLen;
    Command checkMediumLen;
    Command checkDigit;
    Command checkLowerCaseAndUpperCase;
    Command checkSpecialCharacters;

    Command checkCommonWords;

    public CommandHandler(Command checkMinimumLen, Command checkMediumLen,
                          Command checkDigit, Command checkLowerCaseAndUpperCase,
                          Command checkSpecialCharacters, Command checkCommonWords) {
        this.checkMinimumLen = checkMinimumLen;
        this.checkMediumLen = checkMediumLen;
        this.checkDigit = checkDigit;
        this.checkLowerCaseAndUpperCase = checkLowerCaseAndUpperCase;
        this.checkSpecialCharacters = checkSpecialCharacters;
        this.checkCommonWords = checkCommonWords;
    }

    public void checkMinimumLen(String password){
        checkMinimumLen.execute(password);
    }

    public void checkMediumLen(String password){
        checkMediumLen.execute(password);
    }

    public void checkDigit(String password){
        checkDigit.execute(password);
    }
    public void checkLowerCaseAndUpperCase(String password){
        checkLowerCaseAndUpperCase.execute(password);
    }
    public void checkSpecialCharacters(String password){
        checkSpecialCharacters.execute(password);
    }
    public void checkCommonWords(String password){
        checkCommonWords.execute(password);
    }
}
