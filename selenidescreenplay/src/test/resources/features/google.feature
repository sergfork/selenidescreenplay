Feature: Verify search in Google

  Scenario: user can see searched keyword in title on an opened result page

    Given Serge is on the Google page
    When he searches by automation
    Then he opens the first link on search results page
    And he can see that title contains automation searched word

  Scenario: user can search expected domain on search result pages

    Given Serge is on the Google page
    When he searches by automation
    Then he can see that testautomationday.com domain is shown on searched results pages. Verify from 1 to 5