package com.example.mypopa;

public class SimpleValidation {
    String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public boolean isValidEmail(String val){
        if(!val.trim().matches(email_pattern))
            return false;
        else
            return true;
    }

}
