package com.fmv;

import com.fmv.services.*;
import com.fmv.services.impl.CoreService;
import com.fmv.services.impl.CustomerService;
import com.fmv.services.impl.NotificationService;
import com.fmv.services.impl.TrackingService;
import com.google.inject.AbstractModule;

public class DefaultCoreModule extends AbstractModule {
    @Override
    public void configure() {
        bind(ICoreService.class).to(CoreService.class);
        bind(ICustomerService.class).to(CustomerService.class);
        bind(ITrackingService.class).to(TrackingService.class);
        bind(INotificationService.class).to(NotificationService.class);
    }
}
