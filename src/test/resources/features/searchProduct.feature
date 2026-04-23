Feature: Product search in Shopping Cart application
  As a logged-in user
  I want to search for products
  So I can find items to purchase

  Scenario: Search for a valid product
    Given Andrea is logged into the Shopping Cart application
    When she searches for the product "Mouse Gamer Logitech"
    Then she should see results related to "Mouse Gamer Logitech"