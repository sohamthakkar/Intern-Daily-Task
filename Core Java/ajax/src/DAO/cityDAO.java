package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import VO.cityVO;
import VO.stateVO;

public class cityDAO {
	
	public List search(cityVO v3,stateVO v2)
	{

		List ls=new ArrayList();
		
		try
		{
			
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
			
			Session session = sessionFactory.openSession();
						
			Transaction transaction=session.beginTransaction();
						
						Query q=session.createQuery("from cityVO where stateId="+v2.getStateId());
						
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
