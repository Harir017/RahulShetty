Feature: Practise Page Testing 
 Scenario: Verify each radio button can be selected individually
    Given user is on Automation Practice Page
    When user selects Radio1
    Then only Radio1 should be selected
    When user selects Radio2
    Then only Radio2 should be selected
    When user selects Radio3
    Then only Radio3 should be selected
 