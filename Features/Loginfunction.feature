Feature: Login Functionality


@Sanity
  Scenario: Successful login with valid credentials
    Given user launch the browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enter email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on logout button
    Then page title should be1 "Admin ";
    And close the browser
@Regression
  Scenario Outline: Login data driven
    Given user launch the browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enter email as "<email>" and password as "<password>"
    And click on login button
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on logout button
    Then page title should be1 "Admin area demo";
    And close the browser

    Examples: 
      | email                | password |
      | admin@yourstore.com1  | admin    |
      | admin@yourstore.com | admin   |
