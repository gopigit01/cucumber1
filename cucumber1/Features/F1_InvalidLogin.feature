Feature: test the ksrtc application
Scenario: To test the invalidlogin page of the ksrtc application
    Given open chrome browser & url of the appln
    When enter teh invalidusername and invalidpassword and click ok
    Then login unsuccess