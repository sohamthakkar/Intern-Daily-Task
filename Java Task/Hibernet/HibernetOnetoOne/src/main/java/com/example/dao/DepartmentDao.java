package com.example.dao;

import com.example.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    public void insertDept(Department dept) throws Exception {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(dept);
        System.out.println("Department saved successfully");
        tx.commit();
        session.close();
    }

    public List<Department> searchAll() {
        List<Department> deptList = new ArrayList<Department>();
        System.out.println("search from Dao");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("searching ...");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query createQuery = session.createQuery("from  Department");
        deptList = createQuery.list();
        System.out.println("Added sucessfully");
        transaction.commit();
        session.close();
        System.out.println(deptList);
        return deptList;


    }
}
