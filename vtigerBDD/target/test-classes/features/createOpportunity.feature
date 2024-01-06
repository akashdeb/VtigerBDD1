@regression
Feature: Creating Opportunity

  Scenario: To create an Opportunity and verify its details

    Given The user has created Organization
    And The user has created Campaign
    When The user Creates Opportunity
    Then The Opportunity details is verified
