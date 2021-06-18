package in.mapping.one2many.util;

import java.util.Properties;
	
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import in.mapping.one2many.model.Cart;
import in.mapping.one2many.model.Category;
import in.mapping.one2many.model.Product;

public class HibernateUtil {
	

	
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory=null;
		ServiceRegistry registry=null;
		if(sessionFactory==null) {
		try {
			// Hibernate Configuration
			Configuration cfg=new Configuration();
			Properties properties=new Properties();
			
			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatetest");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "mySQL556677");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			properties.put(Environment.SHOW_SQL, "true");
			properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			properties.put(Environment.POOL_SIZE, "2");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			
			cfg.setProperties(properties);
			//Mapping the Entity Classes
			cfg.addAnnotatedClass(Product.class);
			cfg.addAnnotatedClass(Cart.class);
			cfg.addAnnotatedClass(Category.class);
			
			 registry=new StandardServiceRegistryBuilder()
										.applySettings(cfg.getProperties()).build();
			System.out.println("Service Rigistry Created!");
			sessionFactory=cfg.buildSessionFactory(registry);
			
		}catch(Exception e) {
			e.printStackTrace();
			
			if(registry!=null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		  }
		}
		
		return sessionFactory;
	}
	
	
	
	

}
