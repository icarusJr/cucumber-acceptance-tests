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

@ws	@temp 	
Scenario: Permissions verification: teacher 
	Given I am logged reservation api as teacher 
	When I try to register a new user 
	Then the teacher should be authorised to add users
	