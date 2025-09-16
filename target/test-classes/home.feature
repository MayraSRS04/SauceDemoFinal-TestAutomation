Feature: Home page

  Background: User login into Sauce demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario Outline: Verify that all products are displayed in home page
      When The home page should be displayed
      Then The product "<product>" should be displayed
      Examples:
        | product                 |
        | Sauce Labs Backpack     |
        | Sauce Labs Bike Light   |
        | Sauce Labs Bolt T-Shirt |



  Scenario: Remove button functionality removes item from cart
    When The home page should be displayed
    And I add the "Sauce Labs Backpack" to the cart
    When I click on the cart icon
    Then The product "Sauce Labs Backpack" should be displayed
    When I click the remove button for the "Sauce Labs Backpack"
    Then the "Sauce Labs Backpack" should be removed from the cart


  Scenario: Filter sorts products from high to low price
    When The home page should be displayed
    When I select the "Price (high to low)" filter option
    Then the products should be sorted by price in descending order
    And the first product should have the highest price
    And the last product should have the lowest price

  Scenario: Filter sorts products from Z to A
    Given The home page should be displayed
    When I select the "Name (Z to A)" filter option
    Then the products should be sorted by name in descending order
    And the first product should start with the last letter
    And the last product should start with the first letter
