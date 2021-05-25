package com.fmv.services;

import com.fmv.entities.ICustomer;

import java.util.Optional;

public abstract class ICacheLoader {
    public abstract Optional<ICustomer> getCustomerByPhoneNumber(String phoneNumber);
}
