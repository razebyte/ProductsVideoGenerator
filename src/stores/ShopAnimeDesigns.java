package stores;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import entities.Product;

public class ShopAnimeDesigns implements interfaces.Store{

	ChromeDriver webDriver;
	Product[] products;
	
	public ShopAnimeDesigns(ChromeDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	@Override
	public String getProductsURL(int page) {
		return "https://shopanimedesigns.com/product/page/" + page + "/";
	}

	public Product[] getProducts() {
		ArrayList<String> productLinks = getProductLinks();
		products = new Product[productLinks.size()];
		
		for (int i = 0; i < productLinks.size(); i++) {
			Product product = getProductInfo(productLinks.get(i));
			products[i] = product;
		}
		
		return products;
	}
	
	@Override
	public ArrayList<String> getProductLinks() {
		String xpath = "//div[@class='list_product']/div[REPLACE]/div/div/span/a";
		ArrayList<String> hrefs = new ArrayList<String>();
		int productIndex = 1;
		int page = 1;
		while (true) { // pages
			productIndex = 1;
			webDriver.get(getProductsURL(page));
			System.out.println("On page " + page);
			String pageSource = webDriver.getPageSource();
			if (pageSource.contains("404 Page not found.")) {
				break;
			}
			while (true) { // products
				String tempXPath = xpath.replace("REPLACE", productIndex+"");
				try {
					WebElement aProduct = webDriver.findElement(By.xpath(tempXPath));
					String href = aProduct.getAttribute("href");
					hrefs.add(href);
				} catch (org.openqa.selenium.NoSuchElementException e) {
					break;
				}
				productIndex += 1;
				break;
			}
			page += 1;
			break;
		}
		return hrefs;
	}

	public Product getProductInfo(String url) {
		webDriver.get(url);
		
		String nameXPath = "//h1[@itemprop='name']";
		String imagesXPath = "//img[@class='fotorama__img']";
		String descXPath = "//div[@itemprop='description']";
		
		WebElement nameElem = webDriver.findElement(By.xpath(nameXPath));
		String name = nameElem.getText();
		
		List<WebElement> imageElems = webDriver.findElements(By.xpath(imagesXPath));
		String[] imageHrefs = new String[imageElems.size()];
		for (int i = 0; i < imageElems.size(); i++) {
			WebElement elem = imageElems.get(i);
			String src = elem.getAttribute("src");
			src = src.replace("_220x220.jpg", "").trim();
			imageHrefs[i] = src;
		}
		
		WebElement descElem = webDriver.findElement(By.xpath(descXPath));
		String description = descElem.getText();
		
		Product product = new Product();
		product.setName(name);
		product.setImageHrefs(imageHrefs);
		product.setDescription(description);
		product.setURL(url);
		
		return product;
	}
	
}
