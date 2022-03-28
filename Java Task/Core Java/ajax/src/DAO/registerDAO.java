package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


import VO.registerVO;;

public class registerDAO {

	public void insert(registerVO v1)
	{
		try
			{
			
				SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.save(v1);
				
				transaction.commit();
				
				session.close();
			}
	
		catch(Exception ex)
			{
				ex.printStackTrace();
			}

	}
	
	public List search(registerVO v2)
	{

		List ls=new ArrayList();
		
		try
		{
			
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
			
			Session session = sessionFactory.openSession();
						
			Transaction transaction=session.beginTransaction();
						
						Query q=session.createQuery("from registerVO");
						
						ls=q.list();
						
			transaction.commit();
						
			session.close();

		}
			
				catch(Exception ex)
					{
						ex.printStackTrace();
					}
	return ls;
			}
}
