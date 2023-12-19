package com.project.passmanager.main.algorithms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordSettings {
    private int passwordLength;
    private boolean useLower;
    private boolean useUpper;
    private boolean useDigits;
    private boolean useSpecialCharacters;
}
