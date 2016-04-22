package com.atuts.app.hibernate;

import com.atuts.app.dao.GenericDao;
import com.atuts.app.dao.SearchException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.io.Serializable;
import java.util.*;

/**
 * Generic class for handle hibernate generic methods.
 *
 * @param <T>
 * @param <PK>
 */
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {

    protected final Log log = LogFactory.getLog(getClass());
    private Class<T> persistentClass;
    @Autowired
    private SessionFactory sessionFactory;

    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public Session getSession() throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        if (session == null) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<T> getAll() {
        Session session = getSession();
        return session.createCriteria(persistentClass).list();
    }

    @Override
    public List<T> getAllDistinct() {
        Collection<T> result = new LinkedHashSet<T>(getAll());
        return new ArrayList<T>(result);
    }

    @Override
    public List<T> search(String searchTerm) throws SearchException {
        return Collections.emptyList();
    }

    @Override
    public T get(PK id) {
        Session session = getSession();
        IdentifierLoadAccess byId = session.byId(persistentClass);
        T entity = (T) byId.load(id);

        if (entity == null) {
            log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }

        return entity;
    }

    @Override
    public boolean exists(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        return entity != null;
    }

    @Override
    public T save(T object) {
        Session sess = getSession();
        return (T) sess.merge(object);
    }

    @Override
    public void remove(T object) {
        Session sess = getSession();
        sess.delete(object);
    }

    @Override
    public void remove(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        sess.delete(entity);
    }

    @Override
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        Session sess = getSession();
        Query namedQuery = sess.getNamedQuery(queryName);
        for (Map.Entry entry : queryParams.entrySet()) {
            Object val = queryParams.get(entry.getKey().toString());
            if (val instanceof Collection) {
                namedQuery.setParameterList(entry.getKey().toString(), (Collection) val);
            } else {
                namedQuery.setParameter(entry.getKey().toString(), val);
            }
        }
        return namedQuery.list();
    }

    @Override
    public void reindex() {
        //Reindex database tables
    }

    @Override
    public void reindexAll(boolean async) {
        //Reindex whole database
    }
}
