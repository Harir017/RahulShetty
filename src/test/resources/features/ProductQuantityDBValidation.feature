@db
Feature: Product quantity validation using DB and Store UI

  Scenario: Validate product quantity reduces after placing order
    Given product "Test Phone" exists in database
    And I capture the quantity of product "Test Phone" from database
    When user places an order for product "Test Phone" in store
    Then product quantity of "Test Phone" in database should reduce by 1
 