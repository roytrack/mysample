package com.roytrack.maven.exception;

/**
 * Created by roytrack on 2015/4/28.
 */
public class AccountEmailException extends Exception {
    public AccountEmailException(String s, Exception e){
        super(s,e);
    }
}
