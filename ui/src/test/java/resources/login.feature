@ui
Feature: UI Scenario

  Background:
    Given the user navigate to the Login page

    Scenario: User logs into Sauce labs
      When the user enter valid username
      And the user enter valid password
      And the user click on the login button
      Then the user should see page header value is 'Products'
      When the user adds the desire product 'Sauce Labs Backpack' to the cart
      And the user opens the cart
      Then the user should see page header is 'Your Cart'
      When the user clicks checkout button
#      And the user confirms the order
#      Then the user should see the order confirmation message