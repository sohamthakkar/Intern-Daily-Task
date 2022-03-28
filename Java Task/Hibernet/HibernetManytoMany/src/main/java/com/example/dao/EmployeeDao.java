package com.example.dao;

import com.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDao {
    public void insert(Employee name) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(name);
        tx.commit();
        session.close();
        System.out.println("Employee Inserted");
    }

    public List search() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Employee ");
        List<Employee> list = query.list();
        tx.commit();
        session.close();
        System.out.println(list);
        return list;
    }

    public List edit(String id) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Employee where employeeId = " + id);
        List<Employee> list = query.list();
        tx.commit();
        session.close();
//        System.out.println(list);
        return list;
    }

    public void update(Employee emp) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(emp);
        tx.commit();
        session.close();
        System.out.println("Employee Updated");
    }
}
