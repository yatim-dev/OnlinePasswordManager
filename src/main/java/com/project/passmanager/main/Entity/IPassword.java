package com.project.passmanager.main.Entity;

public interface IPassword {

    String encrypt(String password);


    Boolean isMatch(String candidate, String hashed);
}
