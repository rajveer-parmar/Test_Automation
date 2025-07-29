@e2e
Feature: SauceDemo Login

  Scenario: Successful login
    Given user is on the SauceDemo login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to the inventory page