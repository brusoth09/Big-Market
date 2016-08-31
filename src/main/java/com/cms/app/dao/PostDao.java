package com.cms.app.dao;

import com.cms.app.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by burusothman on 8/31/16.
 */
@Repository
public class PostDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Post saveOrUpdate(Post post) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(post);
        tx.commit();
        session.close();
        return post;
    }

    public List<Post> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
//        session.createQuery("from blog_posts");

        tx.commit();
        session.close();
        return post;
    }
}
