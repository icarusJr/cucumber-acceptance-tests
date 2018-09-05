Feature: User registration 

@ws  
Scenario: Permissions verification: team lead 
	Given I am logged reservation api as team lead 
	When I try to register a new user 
	Then system should return only teacher can register message 
	
@ws  
Scenario: Permissions verification: team member 
	Given I am logged reservation api as team member 
	When I try to register a new user 
	Then system should return only teacher can register message

@ws	 	
Scenario: Permissions verification: teacher 
	Given I am logged reservation api as teacher 
	When I try to register a new user 
	Then the teacher should be authorised to add users

@ws	@temp @db	
Scenario: Verify existing user email 
	Given I am logged reservation api as teacher 
	When I try to register a new user with existing email
	Then user with same email exists message should be returned
	
	
	
	
	
	