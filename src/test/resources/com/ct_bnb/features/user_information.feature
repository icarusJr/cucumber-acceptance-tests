Feature: User information 


@ws 
Scenario: Verify information about the logged in user 
	Given I am logged reservation api using "teachervamikemarcus@gmail.com" and "mikemarcus" 
	When I get the current user information using the me endpoint 
	Then the information about current user should be returned 
	
	
@ws @temp 
Scenario: Verify user by id 
	Given  I am logged reservation api as teacher 
	When I get the user information by id 40 using the student endpoint 
	Then the correct user information should be returned by the student endpoint 
		|id		  |40				|
		|firstName|Angie				|
		|lastName |Coatham			|
		|role	  |student-team-member|

	