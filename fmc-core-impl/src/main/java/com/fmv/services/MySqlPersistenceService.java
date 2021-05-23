package com.fmv.services;

import com.fmv.entities.FmvEntity;
import com.fmv.entities.IEntity;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

import java.util.Map;
import java.util.Optional;

public class MySqlPersistenceService implements IPersistenceService {

    private final PersistService jpaPersistenceService;
    private Map<Class<? extends IEntity>, Class<? extends FmvEntity>> mapping = Maps.newHashMap();

    @Inject
    public MySqlPersistenceService(PersistService jpaPersistenceService) {
        this.jpaPersistenceService = jpaPersistenceService;
    }

    @Override
    public <T extends IEntity> T createEntity(Class<T> klass, String user) {
        return null;
    }

    @Override
    public <T extends IEntity> void persistEntity(Class<T> klass, T entity, String user) {

    }

    @Override
    public <T extends IEntity> Optional<T> findEntity(Class<T> klass, T findObject) {
        return Optional.empty();
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }
}
