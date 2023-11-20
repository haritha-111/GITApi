package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import org.testng.annotations.Test;

import Pojo.OrderDetail;
import Pojo.Orders;
import Pojo.LoginResponse;
import Pojo.loginRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	RequestSpecification addProductBaseReq;
	RequestSpecification createOrderBaseReq;
	RequestSpecification deleteProdBaseReq;
	TestDataBuild data =new TestDataBuild();
	Response response;
	static String token;
	static String userId;
	static String productId;
	
	
	@Given("login Payload with {string}  {string} ")
	public void login_Payload_with(String userEmail, String userPassword) throws IOException {
		    // Write code here that turns the phrase above into concrete actions
		
			 
			
						
					
					res = given().spec(requestSpecification())
							.body(data.loginrequestPayLoad(userEmail, userPassword));
					/* System.out.println(loginResponse.getToken());
					String token = loginResponse.getToken();
					System.out.println(loginResponse.getUserId());
					String userId =loginResponse.getUserId(); */
					
		}
	
	
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		    // Write code here that turns the phrase above into concrete actions
	//constructor will be called with value of resource which you pass
			APIResources resourceAPI=APIResources.valueOf(resource);
			System.out.println(resourceAPI.getResource());
			
			resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
			if(method.equalsIgnoreCase("POST"))
				 response =res.when().post(resourceAPI.getResource());
				else if(method.equalsIgnoreCase("GET"))
					 response =res.when().get(resourceAPI.getResource());
			
				else if(method.equalsIgnoreCase("DELETE"))
					 response =res.when().get(resourceAPI.getResource());
				
	
}
	
	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	  
	 assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	@Then("verify token created to {string} using {string}")
	public void verify_token_created_to_using(String expectedName, String resource) throws IOException {
	
	   // requestSpec
	     token=getJsonPath(response,"token");
	     
	     userId = getJsonPath(response,"userId");
	       
	    
	}
	@Given("createproduct Payload with {string}  {string} {string} {string}")
	public void createproduct_with(String productName, String productCategory, String productPrice, String resource) throws IOException {
		    // Write code here that turns the phrase above into concrete actions
		
		
		if (token != null) {
		    addProductBaseReq = given().spec(requestSpecification()).
		    		header("authorization", token)
		        .body(data.createproductPayLoad(productName, productCategory, productPrice));
		} else {
		    // Handle the case when the token is null
		    System.out.println("Token is null. Please check token initialization.");
		    
		}
		
		user_calls_with_http_request(resource,"POST");
		
		productId=getJsonPath(response,"productId");
		
		
		
		}
		
		
		
	@Then("{string} in response body is {string}")
	public void productId_created_to(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	  
	 assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	
	@Given("createorder Payload with {string}  {string} {string} ")
	public void createorder_with(String productId, String country, String resource) throws IOException {
		    // Write code here that turns the phrase above into concrete actions
		
		createOrderBaseReq = given().spec(requestSpecification()).
		    		header("authorization", token)
		        .body(data.orderdetailPayLoad(productId, country));
		
		
		
		user_calls_with_http_request(resource,"POST");
		
		
		

		
		}
	@Then("{string} in response body is {string}")
	public void orderId_created_to(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	  
	 assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	
	
	@Given("deleteproduct Payload with {string}")
	public void deleteproduct_with(String productId, String resource ) throws IOException {
		    // Write code here that turns the phrase above into concrete actions
		
		deleteProdBaseReq=	given().spec(requestSpecification()).
		    		header("authorization", token)
		    		.pathParam("productId",productId);
				
			user_calls_with_http_request(resource,"DELETE");
								
		
		}
	
	
	}


