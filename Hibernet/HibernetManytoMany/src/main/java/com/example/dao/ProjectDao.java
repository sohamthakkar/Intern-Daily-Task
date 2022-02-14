package com.example.dao;

import com.example.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectDao {
    public void insert(Project project) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(project);
        tx.commit();
        session.close();
        System.out.println("Project added successfully");
    }

    public List search() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Project");
        List<Project> list = query.list();
        tx.commit();
        session.close();
        System.out.println(list);
        return list;
    }

    public void update(Project project) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(project);
        tx.commit();
        session.close();
        System.out.println("Project saved successfully");
    }
}
