package com.fmv.services.impl;

import com.fmv.Pair;
import com.fmv.TrackingState;
import com.fmv.customer.CustomerRequest;
import com.fmv.customer.CustomerResponse;
import com.fmv.entities.ICustomer;
import com.fmv.helper.CustomerMapper;
import com.fmv.services.ICustomerService;
import com.fmv.services.IPersistenceService;
import com.google.common.base.Preconditions;
import com.google.inject.Inject;

public class CustomerService implements ICustomerService {

    private final IPersistenceService persistenceService;
    private final CustomerMapper customerMapper;

    @Inject
    public CustomerService(IPersistenceService persistenceService, CustomerMapper customerMapper) {
        this.persistenceService = persistenceService;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse registerByPhoneNumber(CustomerRequest request) {
        Preconditions.checkNotNull(request);
        validateRegisterRequest(request);
        ICustomer customer = persistenceService.createEntity(ICustomer.class, "");
        customerMapper.setCustomerFromRequest(request, customer);
        customer.setTrackingState(TrackingState.INIT);
        persistenceService.persistEntity(ICustomer.class, customer, "");
        return customerMapper.getResponse(customer);
    }

    private Pair<Boolean, String> validateRegisterRequest(CustomerRequest request) {
        Preconditions.checkNotNull(request.getPhoneNumber());
        return new Pair<>(Boolean.TRUE, "");
    }

    @Override
    public CustomerResponse getByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }
}
