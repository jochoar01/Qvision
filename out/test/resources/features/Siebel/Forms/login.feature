@tag
Feature: Make login in Siebel application
 As a user
 I want to make login in the Siebel application


Scenario Outline: Do login in the application
Given we are a user
When we make login with "<username>" and "<password>"
Then the login is succesful

Examples:
| username   | password |
| parendon | 10Cibercafeopen2018 |
