import java.util.ArrayList;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import entities.Product;
import stores.ShopAnimeDesigns;
import tools.Display;

public class Start {

	public static void main (String[] args) {
		
		//String pc = "D:/Program Files x64/Selenium/WebDrivers/chromedriver.exe";
		String lt = "C:/Selenium/WebDrivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", lt);
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		
		ShopAnimeDesigns sad = new ShopAnimeDesigns(new ChromeDriver(options));
		Product[] products = sad.getProducts();
		Display.products(products);
		
	}
	
}
