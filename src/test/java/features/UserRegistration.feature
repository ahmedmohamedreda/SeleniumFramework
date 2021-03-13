Feature: Test the Registration functionality
  
  Scenario Outline: User Register with valid data. 
Given User in the home page and go to Registration page
When  fill out the form with valid data "<firstname>","<lastname>","<email>","<password>"
Then user should navigate to homepage After receive the success message

Examples:
   | firstname |lastname  | email | password |
   | Ahmed | REE11 | Ayy48@Test.com | 1234567 |
   | Mohmed | REE11 | Ree72@Test.com |1234567|