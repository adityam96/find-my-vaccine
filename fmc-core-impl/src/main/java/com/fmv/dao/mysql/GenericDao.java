package com.fmv.dao.mysql;

import com.fmv.dao.DaoException;
import com.fmv.entities.FmvEntity;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Singleton
public class GenericDao extends AbstractDAO<FmvEntity> {

    @Inject
    public GenericDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public <E extends FmvEntity> E createEntity(Class<E> entityClass) throws DaoException {
        try {
            E entity = entityClass.newInstance();
            setExternalId(entity);
            return entity;
        } catch (Exception e) {
            throw new DaoException(500, "Unable to create entity");
        }
    }

    public <E extends FmvEntity> E persistEntity(E entity) throws Exception {
        try {
            persist(entity);
        } catch (Exception e) {
            log.error("Unable to persist entity", e);
            throw new DaoException(500, "Unable to persist entity");
        }
        return entity;
    }

    public <E extends FmvEntity> Optional<E> findEntity(Class<E> entityClass, String externalId) throws Exception {
        try {
            return Optional.ofNullable((E) get(externalId));
        } catch (Exception e) {
            throw new DaoException(500, "Unable to find entity");
        }
    }

    public <E extends FmvEntity> List<E> list(Class<E> entityClass) {
        try {
            Session em = super.currentSession();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<E> cq = cb.createQuery(entityClass);
            Root<E> rootEntry = cq.from(entityClass);
            CriteriaQuery<E> all = cq.select(rootEntry);
            TypedQuery<E> allQuery = em.createQuery(all);
            return allQuery.getResultList();
        } catch (Exception e) {
            throw new DaoException(500, "Unable to list entities");
        }
    }

    private <E extends FmvEntity> void setExternalId(E entity) {
        LocalDateTime dateTime = LocalDateTime.now();
        Integer randomNumber = new Random().nextInt(100000);
        entity.setExternalId(entity.getPrefix()
                + dateTime.format(DateTimeFormatter.ofPattern("yyMMddHHmmssSS"))
                + String.format("%06d", randomNumber)
        );
    }


    public Date getCurrentDate() {
        return Date.valueOf(LocalDate.now());
    }
}
