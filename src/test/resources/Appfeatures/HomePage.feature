Feature: Select Application from AppLauncher

Background: 
Given User is already logged into Salesforce Application

Scenario: Selection of Application from AppLauncher
Given user is on saleforce Home page
When user clicks on the AppLauncher button
And user enters Application name in the seatch box
|Service|
And user Selects the application retrieved from the drop down list
|Service|
Then user should be directed to Application Page
|Service|
