package in.mapping.one2many.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.mapping.one2many.model.Cart;
import in.mapping.one2many.util.HibernateUtil;

public class CartDao {
	public void insertCart(Cart cart) {
		Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction =session.beginTransaction();
			session.save(cart);
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
