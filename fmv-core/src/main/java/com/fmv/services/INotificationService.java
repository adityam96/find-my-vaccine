package com.fmv.services;

import com.fmv.notification.NotifyCustomerRequest;
import com.fmv.notification.NotifyCustomerResponse;

public interface INotificationService extends IFmvService {

    NotifyCustomerResponse notifyCustomer(NotifyCustomerRequest request);

}
