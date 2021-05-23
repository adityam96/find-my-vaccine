package com.fmv.services;

import com.fmv.filters.IEntity;

import java.util.Optional;

public interface IPersistenceService extends IFmvService {

    <T extends IEntity> T createEntity(Class<T> klass, String user);

    <T extends IEntity> void persistEntity(Class<T> klass, T entity, String user);

    <T extends IEntity> Optional<T> findEntity(Class<T> klass, T findObject);
}
