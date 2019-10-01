Feature: Verify search in Google looking for a domain in the results.

  Scenario: user can search expected domain on search result pages

    Given Serge is on the Google page
    When he searches by automation
    Then he can see that testautomationday.com domain is shown on searched results pages. Verify from 1 to 5