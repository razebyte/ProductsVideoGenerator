package entities;

public class Product {

	String name;
	String[] imageHrefs;
	String description;
	String url;
	
	public String getName() {
		return name;
	}
	
	public String[] getImageHrefs() {
		return imageHrefs;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getURL() {
		return url;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setImageHrefs(String[] imageHrefs) {
		this.imageHrefs = imageHrefs;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Name: " + getName() + "\n");
		stringBuilder.append("URL: " + getURL() + "\n");
		stringBuilder.append("Image Hrefs: " + getImageHrefs() + "\n");
		stringBuilder.append("Description: " + getDescription() + "\n");
		stringBuilder.append("\n");
		return stringBuilder.toString();
	}
	
}
