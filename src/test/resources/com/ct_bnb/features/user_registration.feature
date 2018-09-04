Feature: User registration
 
 @ws @db @temp
Scenario: Permissions verification: team lead
	Given  I am logged reservation api as team lead
	When I try to register a new user
	Then system should return only teacher can register message