Feature: Latest foreign exchange rates end to end scenarios

    Scenario: Verify rates API response status
        When rates API is available
        Then the response status should be 200

    Scenario: Verify rates API base response details
        When rates API is available
        Then the response for rates API USD should match



