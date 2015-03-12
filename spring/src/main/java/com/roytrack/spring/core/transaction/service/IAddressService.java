package com.roytrack.spring.core.transaction.service;


import com.roytrack.spring.core.transaction.model.AddressModel;

public interface IAddressService {
    
    public void save(AddressModel address);
    
    public int countAll();
}
