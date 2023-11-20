package resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Pojo.OrderDetail;
import Pojo.Orders;
import Pojo.createproduct;
import Pojo.loginRequest;



public class TestDataBuild {
	
	static String userId;

	
	public loginRequest loginrequestPayLoad(String userEmail, String userPassword)
	
	{
		
	
			loginRequest l =new loginRequest();
			l.setUserEmail("g.haritha.k@gmail.com");
			l.setUserPassword("Yash@2114");
			return l;
			
		
	}
	
	
public createproduct createproductPayLoad(String productName, String productCategory, String productPrice )
	
{
	 String baseImagePath = "C:\\\\Users\\\\uday2\\\\OneDrive\\\\Desktop\\\\IEvolve_Issue.png"; // Set the base directory for images
	    String productImagePath = baseImagePath + productName;
	
	createproduct c =new createproduct();
	c.setProductSubCategory("shirts");
	c.setProductPrice("11500");
	c.setProductName("Laptop");
	c.setProductFor("men");
	c.setProductDescription("Lenova");
	c.setProductCategory("shirts");
	c.setProductAddedBy(userId);
	
	    
    // Add the image file as a multi-part form data
    c.setproductImage(productImagePath);

    return c;
	
	
}

public OrderDetail orderdetailPayLoad(String productId, String country )

{
	 
	
	OrderDetail o =new OrderDetail();
	
	o.setCountry("India");
	o.setProductOrderedId(productId);
	
	List<OrderDetail> orderDetailList = new ArrayList<OrderDetail> ();
	orderDetailList.add(o);
	
	Orders orders = new Orders();
	orders.setOrders(orderDetailList);

    return o;
	
	
}


	
}
