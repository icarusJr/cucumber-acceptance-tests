Feature: Complete product information


Scenario: Product details
	Given the user is on the home page
	When the user selects "Printed Summer Dress" 
	Then product name should be "Printed Summer Dress"
	Then correct default count should be 1 
	
Scenario: Product details with map
	Given the user is on the home page
	When the user selects "Printed Summer Dress"
	Then the system should display the product information:
		|name	  |	Printed Summer Dress  |
		|count    |	1					  |
		|condition|	New					  |
		|size	  |	S					  |
		|price    | 	$28.98		  	      |
	@smoke	
Scenario: Product details with map 2
	Given the user is on the home page
	When the user selects "Printed Dress"
	Then the system should display the product information:
		|name	  |	Printed Dress   |
		|count    |	1				|
		|condition|	New				|
		|size	  |	S				|
		|price    | 	$26.00		  	|		
		
		
		
		
		
		
		
		