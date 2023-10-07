package com.project.passmanager.main.Entity;

public interface Password {
    byte[] generateSalt(int length);
    String hashPassword(String password, byte[] salt);

}
