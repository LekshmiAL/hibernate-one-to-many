package in.mapping.one2many.main;

import java.util.Arrays;

import in.mapping.one2many.dao.CartDao;
import in.mapping.one2many.dao.CategoryDao;
import in.mapping.one2many.dao.ProductDao;
import in.mapping.one2many.model.Cart;
import in.mapping.one2many.model.Category;
import in.mapping.one2many.model.Product;

public class Application {

	public static void main(String[] args) {
		
		
		Category c1 = new Category("stationary");
		
		Product p1 = new Product("pen", 20, c1);
		Product p2 = new Product("book", 50, c1);
		Product p3 = new Product("pencil", 10, c1);
		
		Cart cart1 = new Cart(Arrays.asList(p1,p2));
		Cart cart2 = new Cart(Arrays.asList(p3));
		
		ProductDao productDao = new ProductDao();
		productDao.insertProduct(Arrays.asList(p1,p2,p3));
		
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.insertCategory(c1);
		
		
		CartDao cartDao = new CartDao();
		cartDao.insertCart(cart1);
		cartDao.insertCart(cart2);
		
	}

}
