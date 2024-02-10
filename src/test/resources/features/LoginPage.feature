Feature: Login Page

Scenario: Login Page Title
Given User is landing page
When User gets title of the page
Then Page title should be contains "Swag Labs"

Scenario: Login with correct credentials
Given User is on login page
When User enters username "standard_user"
And User enters password "secret_sauce"
And User clicks on login 
Then User gets the span title page "Products"
