Feature: Verify search in Google

  Scenario: user can see searched keyword in title on an opened result page

    Given Serge is on the Google page
    When he searches by automation
    Then he opens the first link on search results page
    And he can see that title contains automation searched word
