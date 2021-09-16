Feature: the-internet

Scenario: Validate title
	Given I access page "https://the-internet.herokuapp.com/"
	When I click in "A/B Testing"
	Then I see the title "A/B Test Variation 1"
	
	
  

