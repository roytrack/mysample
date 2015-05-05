package com.roytrack.maven.exception;

/**
 * Created by ruanchangming on 2015/4/28.
 */
public class AccountEmailException extends Exception {
    public AccountEmailException(String s, Exception e){
        super(s,e);
    }
}
