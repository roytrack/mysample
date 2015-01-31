package com.roytrack.spring.core.transaction.dao;


import com.roytrack.spring.core.transaction.model.AddressModel;

public interface IAddressDao {
    
    public void save(AddressModel address);

    public int countAll();
}
