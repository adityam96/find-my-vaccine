package com.fmv.dao;

import com.fmv.entities.FmvEntity;

import java.util.List;
import java.util.Optional;

public interface IGenericDao {

    <E extends FmvEntity> void persistEntity(E entity);

    <E extends FmvEntity> Optional<E> findEntityByExternalId(Class<E> klass, String externalId);

    <E extends FmvEntity> List<E> list(Class<E> entityClass);
}
