package in.mapping.one2many.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.mapping.one2many.model.Category;
import in.mapping.one2many.util.HibernateUtil;

public class CategoryDao {

	public void insertCategory(Category c1) {

		Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction =session.beginTransaction();
			session.save(c1);
			transaction.commit();
			
		}catch(Exception e)
		{
				
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		
	
		
	}
	

}
