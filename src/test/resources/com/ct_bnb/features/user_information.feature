Feature: User information


@ws @temp
Scenario: Verify information about the logged in user
	Given I am logged reservation api using "teachervamikemarcus@gmail.com" and "mikemarcus"
	When I get the current user information using the me endpoint
	Then the information about current user should be returned