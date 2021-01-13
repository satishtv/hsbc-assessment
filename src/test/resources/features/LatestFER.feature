Feature: Latest foreign exchange rates end to end scenarios

  @Smoke
  Scenario: Verify rates API response status
    When rates API is available
    Then the response status should be 200

  @Smoke
  Scenario: Verify rates API base response details
    When rates API is available
    Then the response for rates API USD should match

  @Regression
  Scenario: Verify error for invalid rates API URL
    When rates API is available
    And user hits an invalid URL
    Then user should get error message



