Feature: Product information 

Background: 
	Given the user is on the home page 

@product
Scenario: Display the correct product name 
	When the user selects Printed Summer Dress 
	Then product information page should be displayed 
	And product name should be Printed Summer Dress 
	
@regression @product
Scenario: Default count and size information 
	When the user selects Printed Summer Dress 
	Then correct default count size should be displayed 
		
@regression
Scenario: Display the correct product name by name 
	When the user selects "Printed Summer Dress" 
	Then product page title should contain "Printed Summer Dress" 
	And product name should be "Printed Summer Dress" 
	
Scenario: Display the correct product name by name 2 
	When the user selects "Printed Chiffon Dress" 
	Then product page title should contain "Printed Chiffon Dress" 
	And product name should be "Printed Chiffon Dress" 
	
Scenario: Change item count 
	When the user selects "Printed Chiffon Dress" 
	Then correct default count should be 1 
	And the user should be able to toggle the count 
	
	
	
		