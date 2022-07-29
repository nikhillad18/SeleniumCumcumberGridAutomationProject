Feature: Create Record in Account Object

Background:
Given user is present on the service page

Scenario: Create Record in Account Object
Given user is on saleforce Home page
When user clicks on Account Tab
And user clicks on New Button
And user enters Account Name in create Account Pop up
And user selects Account type in create Account Pop up
And user selects Industry in create Account Pop up
And user clicks on save button in create Account Pop up
Then Record should be successfuly created in Account object