package com.fmv.utils;

import com.fmv.entities.ICustomer;
import com.fmv.services.ICacheLoader;
import com.fmv.services.IPersistenceService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Singleton
public class CustomerCacheLoader extends ICacheLoader {

    private final LoadingCache<String, Optional<ICustomer>> customerCache;
    private final CacheLoader<String, Optional<ICustomer>> loader;

    private static final int EXPIRE_TIME_MINUTES = 1;

    @Inject
    public CustomerCacheLoader(IPersistenceService persistenceService) {
        loader = new CacheLoader<String, Optional<ICustomer>>() {
            @Override
            public Optional<ICustomer> load(String externalId) throws Exception {
                try {
                    return persistenceService.findEntity(ICustomer.class, externalId);
                } catch (Exception e) {
                    log.error("Error: ", e);
                    return Optional.empty();
                }
            }
        };
        customerCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_TIME_MINUTES, TimeUnit.MINUTES).build(loader);
    }

    @Override
    public Optional<ICustomer> getCustomerByPhoneNumber(String phoneNumber) {
        return customerCache.getUnchecked(phoneNumber);
//        return customerCache.asMap().values().stream()
//                .filter((customer) -> customer.isPresent() && phoneNumber.equals(customer.get().getPhoneNumber()))
//                .map(Optional::get)
//                .findAny();
    }
}
