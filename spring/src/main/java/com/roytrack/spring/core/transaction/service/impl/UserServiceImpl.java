package com.roytrack.spring.core.transaction.service.impl;


import com.roytrack.spring.core.transaction.dao.IUserDao;
import com.roytrack.spring.core.transaction.model.UserModel;
import com.roytrack.spring.core.transaction.service.IAddressService;
import com.roytrack.spring.core.transaction.service.IUserService;
import com.roytrack.spring.core.transaction.util.TransactionTemplateUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class UserServiceImpl implements IUserService {
    
    private IUserDao userDao;

    private IAddressService addressService;
    
    private PlatformTransactionManager txManager;
    
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
    
    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }
    
    public void setAddressService(IAddressService addressService) {
        this.addressService = addressService;
    }
    
    @Override
    public void save(final UserModel user) {
        TransactionTemplate transactionTemplate =
            TransactionTemplateUtils.getDefaultTransactionTemplate(txManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                userDao.save(user);
                user.getAddress().setUserId(user.getId());
                addressService.save(user.getAddress());
            }
        });
        
    }

    @Override
    public int countAll() {
        return userDao.countAll();
    }

}
