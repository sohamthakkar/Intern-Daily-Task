package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import VO.stateVO;
import VO.countryVO;

public class stateDAO {
	
	public List search(stateVO v2,countryVO v1)
	{

		List ls=new ArrayList();
		
		try
		{
			
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
			
			Session session = sessionFactory.openSession();
						
			Transaction transaction=session.beginTransaction();
						
						Query q=session.createQuery("from stateVO where countryId="+v1.getCountryId());
						
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
