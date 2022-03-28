package com.example.dao;

import com.example.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProjectDao {
    public void add(Project project) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(project);
        System.out.println("Project name added successfully");
        tx.commit();
        session.close();
        System.out.println("data saved");
    }
}
