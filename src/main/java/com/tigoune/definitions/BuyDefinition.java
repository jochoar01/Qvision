package com.tigoune.definitions;

import com.tigoune.steps.BuySteps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Clase que describe la definición para realizar el inicio de sesión en la aplicación Siebel
 */
public class BuyDefinition {
	
	@Steps
	BuySteps buySteps;
	@Given("^that I go to Sale dresses home page$")
	public void that_I_go_to_Sale_dresses_home_page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		BuySteps.openBrowserAndLogin();
	}


	@When("^I'm going to look for a dress in the store$")
	public void i_m_going_to_look_for_a_dress_in_the_store() throws Exception {
		BuySteps.searchDress();
	   
	}

	@Then("^will buy the most expensive dress and send to clara's father")
	public void will_buy_the_most_expensive_dress() throws Exception {
		
		BuySteps.buyDress();
	}
}
