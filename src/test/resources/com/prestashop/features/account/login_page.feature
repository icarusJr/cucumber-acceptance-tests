@login 
Feature: login 

@smoke 
Scenario: login link 
	Given the user is on the home page 
	When the user clicks on the Sign in link 
	Then username and password fields should be displayed 
@smoke	
Scenario: verify user name and last name 
	Given the user is on the login page 
	When I login using username "nitoyey@dumoac.net" and password "password" 
	Then users full name "John" "Smith" should be displayed 
	
	#break
@amazon_check 	@regression
Scenario: verify goes to different site first 
	Given the user amazon 
	And user gets prices for "Printed Chiffon Dress" 
	When the user is on the home page 
	Then the price for "Printed Chiffon Dress" should be cheaper 
	