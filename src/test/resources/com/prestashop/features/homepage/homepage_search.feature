@search
Feature: home page search functionality
	
  Scenario: Verify search term
    Given the user is on the home page
    When the user enters a search term
    Then the search box should contain the search term

  Scenario: verify home page title
    Given the user is on the home page
    When the user gets the title of the page
    Then title should be Search - My Store
    