package models;

import java.util.*;

public class Product {
	
	public Integer id;
	public String name;
	public String description;

	private static Set<Product> products;
	static {products = new HashSet<Product>();}

	public Product() {
		//
	}

	public Product(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String toString() {
		return String.format("%s - %s", id, name);
	}

	public static Set<Product> findAll() {
		return new HashSet<Product>(products);
	}

	public static Product findById(Integer id) {
		for (Product candidate : products) {
			if (candidate.id.equals(id)) {
				return candidate;
			}
		}
		return null;
	}

	public static Set<Product> findByName(String term) {
		final Set<Product> results = new HashSet<Product>();
		for (Product candidate : products) {
			if(candidate.name.toLowerCase().contains(term.toLowerCase())){
				results.add(candidate);
			}
		}
		return results;
	}

	public static boolean remove(Product product) {
		return products.remove(product);
	}

	public static void add(Product product) {
		products.add(product);
	}
}
