@ui
Feature: Orders

  Background:
    Given the user navigates to the Login page
    And the user login with credentials

  Scenario: Successful Order
    When the user navigates to the inventory screen
    And the user add product to the cart
    And the user navigates to the cart
    And the user clicks checkout button
    And the user fill in the required information for checkout
    And the user finishes the order
    Then receipt for successful order submission is displayed