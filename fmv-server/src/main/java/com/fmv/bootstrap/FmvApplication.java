package com.fmv.bootstrap;

import com.fmv.DefaultCoreImplModule;
import com.fmv.DefaultCoreModule;
import com.fmv.resources.CustomerResource;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.List;

public class FmvApplication extends Application<FmvConfiguration> {

    private HibernateBundle<FmvConfiguration> hibernate;

    public static void main(String[] args) throws Exception {
        new FmvApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<FmvConfiguration> bootstrap) {
        super.initialize(bootstrap);
        hibernate = new ScanningHibernateBundle<FmvConfiguration>("com.fmv.entities") {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(FmvConfiguration fmvConfiguration) {
                return fmvConfiguration.getDataSourceFactory();
            }
        };
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(FmvConfiguration fmvConfiguration, Environment environment) throws Exception {
        Injector injector = createInjector(environment);
        environment.jersey().register(injector.getInstance(CustomerResource.class));
        environment.lifecycle().manage(injector.getInstance(AppLifeCycleManager.class));
    }

    private Injector createInjector(Environment environment) {
        List<Module> modulesList = Lists.newArrayList(
                new FmvModule(),
                new DefaultCoreModule(),
                new DefaultCoreImplModule(hibernate)
        );
        return Guice.createInjector(modulesList);
    }
}