package com.roytrack.spring.core.transaction.dao;

;import com.roytrack.spring.core.transaction.model.UserModel;

public interface IUserDao {
    
    public void save(UserModel user);
    
    public int countAll();
    
}
