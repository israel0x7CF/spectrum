package com.spectrun.spectrum.utils.exceptions;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
