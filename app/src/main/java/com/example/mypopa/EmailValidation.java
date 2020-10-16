package com.example.mypopa;

public class EmailValidation {
    String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public boolean isEmailValid(String email){
        if(!email.trim().matches(email_pattern))
            return false;
        else
            return
            true;
    }

}
