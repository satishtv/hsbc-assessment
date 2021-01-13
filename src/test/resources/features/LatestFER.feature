Feature: Latest foreign exchange rates end to end scenarios

    Scenario: Verify rates API response status
        When rates API is available
        Then the response status should be 200

    Scenario: Verify rates API base response details
        When rates API is available
        Then the response for rates API USD should match

    Scenario: Verify error for invalid rates API URL
        When rates API is available
        And user hits an invalid URL
        Then user should get error message



