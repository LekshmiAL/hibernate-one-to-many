package in.mapping.one2many.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.mapping.one2many.model.Product;
import in.mapping.one2many.util.HibernateUtil;

public class ProductDao {

	public void insertProduct(List<Product> products) {
		Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction =session.beginTransaction();
			products.forEach(product -> session.save(product));
			transaction.commit();
			
		}catch(Exception e){	
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
