package com.pingplusplus.exception;

public abstract class PingppException extends Exception {

  private static final long serialVersionUID = 1L;

  public PingppException(String message) {
    super(message, null);
  }

  public PingppException(String message, Throwable e) {
    super(message, e);
  }

}
