package com.fmv.bootstrap;

import com.fmv.resources.CustomerResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FmvApplication extends Application<FmvConfiguration> {

    public static void main(String[] args) throws Exception {
        new FmvApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<FmvConfiguration> bootstrap) {

    }

    @Override
    public void run(FmvConfiguration fmvConfiguration, Environment environment) throws Exception {
        Injector injector = createInjector(environment);
        environment.jersey().register(injector.getInstance(CustomerResource.class));
    }

    private Injector createInjector(Environment environment) {
        return Guice.createInjector(new FmvModule());
    }
}