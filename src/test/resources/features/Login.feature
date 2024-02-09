@Login @regression
Feature: Validate Successful And Unsuccessful Login

  Background:
    Given Access to webdriver university login page

  Scenario: Validate Successful Login
    When I enter username webdriver
    And I enter password webdriver123
    And I click login button
    Then Pop up appears to validate success

  Scenario: Validate Unsuccessful Login
    When I enter username webdriver
    And I enter password webdriver001
    And I click login button
    Then Pop up appears to validate unsuccess

    @login1
  Scenario Outline: Validate - Successful and Unsuccessful Login
    When I enter username <username>
    And I enter password <password>
    And I click login button
    Then I should be presented with the following Login validation <LoginValidationMessage>

    Examples:
      | username  | password     | LoginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | John      | webdriver00  | validation failed      |
      | Mase      | webdriver0   | validation failed      |