package com.fmv.services;

import com.fmv.dao.DaoException;
import com.fmv.dao.DaoUtils;
import com.fmv.dao.IGenericDao;
import com.fmv.dao.mysql.GenericDao;
import com.fmv.entities.Customer;
import com.fmv.entities.FmvEntity;
import com.fmv.entities.ICustomer;
import com.fmv.entities.IEntity;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Singleton
public class MySqlPersistenceService implements IPersistenceService {

    private Map<Class<? extends IEntity>, Class<? extends FmvEntity>> mapping = Maps.newHashMap();
    private final IGenericDao genericDao;

    @Inject
    public MySqlPersistenceService(GenericDao genericDao) {
        this.genericDao = genericDao;
        this.mapping.put(ICustomer.class, Customer.class);
    }

    @Override
    public <T extends IEntity> T createEntity(Class<T> klass, String user) {
        try {
            validateMapping(klass);
            FmvEntity entity = mapping.get(klass).newInstance();
            DaoUtils.setExternalId(entity);
            entity.setCreatedAt(DaoUtils.getCurrentDate());
            entity.setUpdatedAt(entity.getCreatedAt());
            entity.setCreatedByUser(user);
            entity.setLastUpdatedByUser(user);
            return (T) entity;
        } catch (Exception e) {
            throw new DaoException(500, "Unable to cretae entity");
        }
    }

    @Override
    public <T extends IEntity> void persistEntity(Class<T> klass, T entity, String user) {
        try {
            validateMapping(klass);
            entity.setUpdatedAt(DaoUtils.getCurrentDate());
            entity.setLastUpdatedByUser(user);
            genericDao.persistEntity((FmvEntity) entity);
        } catch (Exception e) {
            throw new DaoException(500, "Unable to persist");
        }
    }

    @Override
    public <T extends IEntity> Optional<T> findEntity(Class<T> klass, String externalId) {
        try {
            validateMapping(klass);
            Optional<? extends FmvEntity> entity = genericDao.findEntityByExternalId(mapping.get(klass), externalId);
            return Optional.ofNullable((T) entity.get());
        } catch (Exception e) {
            log.error("Unable to find");
            return Optional.empty();
        }
    }

    private <T extends IEntity> void validateMapping(Class<T> klass) {
        if (!mapping.containsKey(klass)) {
            throw new DaoException(500, "No class mapping found");
        }
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
    }
}
