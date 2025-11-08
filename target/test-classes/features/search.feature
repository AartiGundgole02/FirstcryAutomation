Feature: Product Search on FirstCry

  Scenario: Verify search functionality
    Given user is on FirstCry homepage
    When user searches for "footwear"
    Then product results should be displayed
    
    Scenario: Select the product from displayed options
    Given user is in footware page
    When user navigates on all categories and selects "sneakers" from "Footwear" section
    Then Kids sneakers should display on the page
    
