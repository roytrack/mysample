package com.roytrack.maven.persist;

/**
 * Created by roytrack on 2015/5/8.
 */
public interface AccountPersistService {
    Account createAccount(Account account)throws  AccountPersistException;
    Account readAccount(String id)throws  AccountPersistException;
    Account updateAccount(Account account)throws  AccountPersistException;
    void deleteAccount(String id)throws  AccountPersistException;
}
