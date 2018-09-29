package com.roytrack.maven.email;


import com.roytrack.maven.exception.AccountEmailException;

/**
 * Created by roytrack on 2015/4/28.
 */
public interface AccountEmailService {

  void sendEmail(String to, String subject, String htmlText) throws AccountEmailException;
}