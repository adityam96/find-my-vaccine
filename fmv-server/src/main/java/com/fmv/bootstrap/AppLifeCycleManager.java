package com.fmv.bootstrap;

import com.fmv.services.ICoreService;
import com.fmv.services.ICustomerService;
import com.fmv.services.IFmvService;
import com.fmv.services.IPersistenceService;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.dropwizard.lifecycle.Managed;

import java.util.List;

public class AppLifeCycleManager implements Managed {

    private final List<IFmvService> fmvServices;

    @Inject
    public AppLifeCycleManager(Injector injector) {
        fmvServices = Lists.newArrayList(
                injector.getInstance(ICoreService.class),
                injector.getInstance(ICustomerService.class),
                injector.getInstance(IPersistenceService.class)
        );
    }

    @Override
    public void start() throws Exception {
        fmvServices.forEach((service) -> {
            try {
                service.start();
            } catch (Exception e) {
                // Log as unable to start service
            }
        });
    }

    @Override
    public void stop() throws Exception {
        fmvServices.forEach((service) -> {
            try {
                service.stop();
            } catch (Exception e) {
                // Log as unable to start service
            }
        });
    }
}
