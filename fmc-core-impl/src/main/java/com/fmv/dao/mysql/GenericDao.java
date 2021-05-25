package com.fmv.dao.mysql;

import com.fmv.dao.DaoException;
import com.fmv.dao.IGenericDao;
import com.fmv.entities.FmvEntity;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.HibernateBundle;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Slf4j
@Singleton
public class GenericDao implements IGenericDao {

    private final SessionFactory sessionFactory;

    @Inject
    public GenericDao(HibernateBundle bundle) {
        this.sessionFactory = bundle.getSessionFactory();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public <E extends FmvEntity> void persistEntity(E entity) {
        try {
            Session session = getCurrentSession();
            session.persist(entity);
        } catch (Exception e) {
            log.error("Unable to persist entity", e);
            throw new DaoException(500, "Unable to persist entity");
        }
    }

    @Override
    public <E extends FmvEntity> Optional<E> findEntityByExternalId(Class<E> klass, String externalId) {
        try {
            return Optional.ofNullable((E) getCurrentSession().createQuery("SELECT entity FROM " + klass.getSimpleName() + " entity WHERE externalId = :externalId").setParameter("externalId", externalId).getSingleResult());
        } catch (Exception e) {
            log.error("Unable to persist entity", e);
            return Optional.empty();
        }
    }

    @Override
    public <E extends FmvEntity> List<E> list(Class<E> entityClass) {
        try {
            Session em = getCurrentSession();
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

}
