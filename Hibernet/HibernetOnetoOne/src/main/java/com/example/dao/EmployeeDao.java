package com.example.dao;

import com.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public void insert(Employee employee) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        System.out.println("Employee saved successfully");
        tx.commit();
        session.close();

    }

    public List<Employee> searchEmp() {
        List<Employee> empList = new ArrayList<>();
        System.out.println("Serching Employee");
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Employee");
        empList = query.list();
        System.out.println("get sucessfully");
        tx.commit();
        session.close();
        System.out.println(empList);
        return empList;
    }

    public List edit(Employee employee) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Employee where empId=" + employee.getEmpId());
        List empList = query.list();
        tx.commit();
        session.close();

        return empList;
    }

    public void update(Employee employee) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(employee);
        System.out.println("Employee updated successfully");
        tx.commit();
        session.close();
    }
}
