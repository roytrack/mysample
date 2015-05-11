package com.roytrack.maven.persist;

import org.dom4j.DocumentException;

/**
 * Created by roytrack on 2015/5/8.
 */
public class AccountPersistException extends  Exception {
    public AccountPersistException(String s, Exception e) {
        super(s,e);
    }
}
