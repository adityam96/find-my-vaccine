package com.fmv.services.impl;

import com.fmv.customer.CustomerRequest;
import com.fmv.customer.CustomerResponse;
import com.fmv.notification.NotifyCustomerRequest;
import com.fmv.notification.NotifyCustomerResponse;
import com.fmv.services.ICoreService;
import com.fmv.services.ICustomerService;
import com.fmv.services.INotificationService;
import com.fmv.services.ITrackingService;
import com.fmv.tracking.addTracking.AddTrackingRequest;
import com.fmv.tracking.addTracking.AddTrackingResponse;
import com.google.inject.Inject;

public class CoreService implements ICoreService {

    private final ICustomerService customerService;
    private final ITrackingService trackingService;
    private final INotificationService notificationService;

    @Inject
    public CoreService(ICustomerService customerService,
                       ITrackingService trackingService,
                       INotificationService notificationService) {
        this.customerService = customerService;
        this.trackingService = trackingService;
        this.notificationService = notificationService;
    }

    @Override
    public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
        return customerService.registerByPhoneNumber(customerRequest);
    }

    @Override
    public Object getByPhoneNumber(String phoneNumber) {
        return customerService.getByPhoneNumber(phoneNumber);
    }

    @Override
    public AddTrackingResponse addTracking(AddTrackingRequest addTrackingRequest) {
        return trackingService.addTracking(addTrackingRequest);
    }

    @Override
    public Object updateTracking(String customerId, String pinCode) {
        return trackingService.updateTrackingPinCode(customerId, pinCode);
    }

    @Override
    public Object removeTracking(String customerId) {
        return trackingService.removeTrackingPinCode(customerId);
    }

    @Override
    public Object getTrackingState(String customerId) {
        return trackingService.getTrackingPinCode(customerId);
    }

    @Override
    public NotifyCustomerResponse notifyCustomer(NotifyCustomerRequest request) {
        return notificationService.notifyCustomer(request);
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }
}
