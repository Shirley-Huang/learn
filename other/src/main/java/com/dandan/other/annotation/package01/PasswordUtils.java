package com.dandan.other.annotation.package01;

import java.util.List;

/**
 * Created by dandan On 十月 14 2019
 */
public class PasswordUtils {

    @UseCase(id=46, description = "passwords must contain at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w"));
    }


    @UseCase(id=48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id=49,description="new passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prePasswords, String password){
        return !prePasswords.contains(password);
    }

    public String show(){
        return "this is show method,no annotation";
    }

}
