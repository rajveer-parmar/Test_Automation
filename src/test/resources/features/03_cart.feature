@e2e
Feature: Cart functionality

  Scenario: User adds product to cart and verifies
    And user adds a backpack to the cart
    And user clicks on cart icon
    Then cart should contain "Sauce Labs Backpack"
