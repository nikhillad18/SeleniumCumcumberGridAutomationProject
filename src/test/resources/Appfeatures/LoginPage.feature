Feature: Salesforce LoginPage feature

Scenario: Salesforce Login page Login
Given user is on saleforce login page
When user enters username
And user enters password
And user clicks on submit button
Then user should be directed to SalesforceHomePage