Feature: Product Page

#acts as beforeMethod
Background:
Given user has already logged in
|	username	|	password	|
|	standard_user	|	secret_sauce	|

Scenario: Add Product to cart
Given user is on products page
When user add backpack to cart
And user click on cart
Then user get the cart detail


