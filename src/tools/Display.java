package tools;

import java.util.List;

import entities.Product;

public class Display {

	public static void list(List<String> lst) {
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}
	}
	
	public static void products(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i].toString());
		}
	}
	
}
