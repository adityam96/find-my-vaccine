package com.fmv;

import com.fmv.entities.Customer;
import com.fmv.entities.ICustomer;
import com.fmv.services.ICacheLoader;
import com.fmv.services.IPersistenceService;
import com.fmv.services.MySqlPersistenceService;
import com.fmv.utils.CustomerCacheLoader;
import com.google.inject.AbstractModule;
import io.dropwizard.hibernate.HibernateBundle;

public class DefaultCoreImplModule extends AbstractModule {

    private final HibernateBundle hibernateBundle;

    public DefaultCoreImplModule(HibernateBundle hibernate) {
        this.hibernateBundle = hibernate;
    }

    @Override
    public void configure() {
        bind(IPersistenceService.class).to(MySqlPersistenceService.class);
        bind(ICacheLoader.class).to(CustomerCacheLoader.class);
        bind(ICustomer.class).to(Customer.class);

        bind(HibernateBundle.class).toInstance(hibernateBundle);
    }
}
