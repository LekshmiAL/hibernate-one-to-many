package in.mapping.one2many.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinTable(name="cart_details")
	@JoinColumn(name = "cart_id")
	private List<Product> products;
	
	public Cart() {
	}

	public Cart(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + products.toString() + "]";
	}
	
	
}
