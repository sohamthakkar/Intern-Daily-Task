package com.interntask.dao;

import com.interntask.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insert(Student student) {
        try {
       SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
           Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(student);
            tx.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Student> searchAll() throws SQLException {
        List<Student> studentList = new ArrayList<Student>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query createQuery = session.createQuery("from  Student");
        studentList = createQuery.list();
        System.out.println("Added sucessfully...");
        transaction.commit();
        session.close();
        System.out.println(studentList);
        return studentList;
    }



    public void update(Student user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        System.out.println("Updated SuccessFully!!");
        transaction.commit();
        session.close();
    }
    public void delete(Student user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);

        System.out.println("deleted SuccessFully!!");
        transaction.commit();
        session.close();
   }

    public List<Student> edit(Student student) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Student where id=" + student.getId());

        List list = query.list();
        transaction.commit();
        session.close();
        return list;


    }
}