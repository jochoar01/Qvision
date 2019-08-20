#Author: ingdavidayala1996@gmail.com

@BuyFeature
Feature: Login in new tours page
	As registered user
  I want to go the home page of Computrabajo
  and log in with my email and password

  @GoodLogin
  Scenario: Succesful login
    Given that I go to Sale dresses home page
    When  I'm going to look for a dress in the store 
    Then  will buy the most expensive dress and send to clara's father 
