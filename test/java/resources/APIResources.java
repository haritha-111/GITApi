package resources;

public enum APIResources {
	
	
	loginAPI("/api/ecom/auth/login"),
	createproductAPI("/api/ecom/product/add-product"),
	orderproductAPI("/api/ecom/user/add-to-cart"),
	deleteproductAPI("/api/ecom/product/delete-product");
	
private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	
	public String getResource()
	{
		return resource;
	}

}
