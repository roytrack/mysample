package com.roytrack.spring.core.transaction.service;


import com.roytrack.spring.core.transaction.model.UserModel;

public interface IUserService {
    
    public void save(UserModel user);
    
    public int countAll();
}
