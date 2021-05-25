package com.fmv.services;

import com.fmv.customer.CustomerRequest;
import com.fmv.customer.CustomerResponse;
import com.fmv.notification.NotifyCustomerRequest;
import com.fmv.notification.NotifyCustomerResponse;
import com.fmv.tracking.addTracking.AddTrackingRequest;
import com.fmv.tracking.addTracking.AddTrackingResponse;

public interface ICoreService extends IFmvService {
    CustomerResponse registerCustomer(CustomerRequest customerRequest);

    CustomerResponse getByPhoneNumber(String phoneNumber);

    AddTrackingResponse addTracking(AddTrackingRequest addTrackingRequest);

    Object updateTracking(String customerId, String pinCode);

    Object removeTracking(String customerId);

    Object getTrackingState(String customerId);

    NotifyCustomerResponse notifyCustomer(NotifyCustomerRequest request);
}
