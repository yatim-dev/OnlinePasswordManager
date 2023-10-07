package com.project.passmanager.main.Entity;

public interface IPasswordHandler {

    String encrypt(String password);


    Boolean isMatch(String candidate, String hashed);
}
