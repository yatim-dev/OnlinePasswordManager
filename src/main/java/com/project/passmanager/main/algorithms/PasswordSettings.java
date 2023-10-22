package com.project.passmanager.main.algorithms;

public class PasswordSettings {
    private int passwordLength;
    private boolean useLower;
    private boolean useUpper;
    private boolean useDigits;
    private boolean useSpecialCharacters;

    public PasswordSettings(int passwordLength, boolean useLower, boolean useUpper, boolean useDigits, boolean useSpecialCharacters) {
        this.passwordLength = passwordLength;
        this.useLower = useLower;
        this.useUpper = useUpper;
        this.useDigits = useDigits;
        this.useSpecialCharacters = useSpecialCharacters;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public boolean isUseLower() {
        return useLower;
    }

    public boolean isUseUpper() {
        return useUpper;
    }

    public boolean isUseDigits() {
        return useDigits;
    }

    public boolean isUseSpecialCharacters() {
        return useSpecialCharacters;
    }
}
