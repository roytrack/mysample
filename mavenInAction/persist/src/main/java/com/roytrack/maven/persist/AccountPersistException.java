package com.roytrack.maven.persist;

/**
 * Created by roytrack on 2015/5/8.
 */
public class AccountPersistException extends Exception {
  public AccountPersistException(String s, Exception e) {
    super(s, e);
  }
}
