Feature: the-internet

Scenario: Validate title
	Given I access the page "https://the-internet.herokuapp.com/"
	And I click in the "Add/Remove Elements"
	When I click the button "Add Element"
	And I click "Delete"
	Then I hope the button is not shown "Delete"
