package com.cms.app.dao;

import com.cms.app.model.Role;
import com.cms.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by burusothman on 8/31/16.
 */
@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDao() {
    }

    @Transactional
    public User save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();
        return userList;
    }

    public Role saveRole(Role role) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(role);
        tx.commit();
        session.close();
        return role;
    }
}
