Feature: Validating Login

	@Login
	Scenario: Verify if Login is successfully done
	Given login Payload with "<userEmail>"  "<userPassword>"
	When user calls "LoginAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "token" in response body is "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGU2NWMzMDc1M2VmYTQ2NTdlZDk5NzgiLCJ1c2VyRW1haWwiOiJnLmhhcml0aGEua0BnbWFpbC5jb20iLCJ1c2VyTW9iaWxlIjo4NjM5NjcwNzc4LCJ1c2VyUm9sZSI6ImN1c3RvbWVyIiwiaWF0IjoxNzAwMjcwODgwLCJleHAiOjE3MzE4Mjg0ODB9.AuBVU_YYEDpAEM-pyfjXYI8OoDwFiYugfpzlTmTJq8g"
	And "userId" in response body is "64e65c30753efa4657ed9978"
	
	
	@createproduct
	Scenario: Verify if createproduct functionality is working
	Given createproduct Payload with "<productName>"  "<productCategory>" "<productPrice>"	
	And verify productId created in web app to "<message>" using "createproductAPI"
	And verify the "productId" in response body
	
	
	@createorder
	Scenario: Verify if createorder functionality is working
	Given createorder Payload with "<productId>" "<country>"
	And verify orderId created in web app to "<message>" using "orderproductAPI"
	
	
	
	@Deleteproduct @Regression
	Scenario: Verify if deleteproduct functionality is working
	Given DeleteProduct Payload using "<productId>"
	When user calls "deleteproductId" with "DELETE" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	
	
	
	
	
	
	
	
	