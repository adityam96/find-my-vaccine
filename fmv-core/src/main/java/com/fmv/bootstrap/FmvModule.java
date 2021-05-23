package com.fmv.bootstrap;

import com.fmv.services.ICoreService;
import com.fmv.services.ICustomerService;
import com.fmv.services.ITrackingService;
import com.fmv.services.impl.CoreService;
import com.fmv.services.impl.CustomerService;
import com.fmv.services.impl.TrackingService;
import com.google.inject.AbstractModule;

public class FmvModule extends AbstractModule {

    @Override
    public void configure() {
        bind(ICoreService.class).to(CoreService.class);
        bind(ICustomerService.class).to(CustomerService.class);
        bind(ITrackingService.class).to(TrackingService.class);
    }
}
