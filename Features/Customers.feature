Feature: Customers

 Background:
    Given user launch the browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enter email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then user can view Dashboard

@P2
  Scenario: Add a new customer
 
    When user click on the customers menu
    And click on customers menu item
    And click on add new button
    Then user can view add new customer page
    When user enter customer info
    And  click on save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close the browser
    
    
@P3
    Scenario: search  customer by email
 
    When user click on the customers menu
    And click on customers menu item
    And Enter customer Email
    When click on search button
    Then user should found emaill in the search table 
    And close the browser
    
@P4
    Scenario: search  customer by firsLastname
    When user click on the customers menu
    And click on customers menu item
    And Enter customer firstname
    And Enter customer lastname
    When click on search button
    Then user should found Firstname in the search table 
    And close the browser