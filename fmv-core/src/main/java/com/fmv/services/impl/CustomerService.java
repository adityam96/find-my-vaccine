package com.fmv.services.impl;

import com.fmv.TrackingState;
import com.fmv.customer.CustomerRequest;
import com.fmv.customer.CustomerResponse;
import com.fmv.entities.ICustomer;
import com.fmv.helper.CustomerMapper;
import com.fmv.services.ICacheLoader;
import com.fmv.services.ICustomerService;
import com.fmv.services.IPersistenceService;
import com.google.inject.Inject;
import org.mapstruct.factory.Mappers;

public class CustomerService implements ICustomerService {

    private final IPersistenceService persistenceService;
    private final ICacheLoader cacheLoader;
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Inject
    public CustomerService(IPersistenceService persistenceService, ICacheLoader cacheLoader) {
        this.persistenceService = persistenceService;
        this.cacheLoader = cacheLoader;
    }

    @Override
    public CustomerResponse registerByPhoneNumber(CustomerRequest request) {
        ICustomer customer = persistenceService.createEntity(ICustomer.class, "");
        customerMapper.setCustomerFromRequest(request, customer);
        customer.setTrackingState(TrackingState.INIT.name());
        persistenceService.persistEntity(ICustomer.class, customer, "");
        return customerMapper.getResponse(customer);
    }

    @Override
    public CustomerResponse getByPhoneNumber(String phoneNumber) {
        ICustomer customer = cacheLoader.getCustomerByPhoneNumber(phoneNumber).get();
        return customerMapper.getResponse(customer);
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }
}
