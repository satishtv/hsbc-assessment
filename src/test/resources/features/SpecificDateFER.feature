Feature: Specific date foreign exchange rates end to end scenarios

  @Smoke
  Scenario: Verify response status
    When specific date rates API is available
    Then specific date rates response status should be 200



