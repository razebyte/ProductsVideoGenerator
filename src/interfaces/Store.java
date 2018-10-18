package interfaces;

import java.util.ArrayList;

import entities.Product;

public interface Store {

	public String getProductsURL(int page);
	public Product[] getProducts();
	public ArrayList<String> getProductLinks();
	public Product getProductInfo(String url);
	
}
