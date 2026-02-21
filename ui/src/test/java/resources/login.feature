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
      Then the user should see cart page header is 'Your Cart'
      When the user clicks checkout button
      Then the user should see checkout page header is 'Checkout: Your Information'
      When the user enters his first name
      And the user enters his last name
      And the user enters his postal code
      And the user clicks the continue button
      Then the user should see final checkout page header is 'Checkout: Overview'
      When the user clicks on the finish button
      Then confirmation receipt should be displayed to the user