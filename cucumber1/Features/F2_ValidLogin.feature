Feature: test the ksrtc applictn
@validscinario
Scenario: To test the valid login page of the ksrtc appln
    Given opn chrome browser & url of the application
    When enter teh invalidusername and validpassword and click ok
    Then login success