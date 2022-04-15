Feature: test the ksrtc app
Scenario: To test the invalid RegPage of the ksrtc application
    Given open chr browser & url of the appln
    When enter teh invalidRegusername and invalidpassword and click ok
    Then Reg unsuccess