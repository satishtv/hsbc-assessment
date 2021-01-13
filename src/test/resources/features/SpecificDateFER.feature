Feature: Specific date foreign exchange rates end to end scenarios

  @Smoke
  Scenario: Verify response status
    When specific date rates API is available
    Then specific date rates response status should be 200

#  Scenario: Verify rates API base response details
#    When rates API is available
#    Then the response for rates API USD should match
#
#  Scenario: Verify error for invalid rates API URL
#    When rates API is available
#    And user hits an invalid URL
#    Then user should get error message



