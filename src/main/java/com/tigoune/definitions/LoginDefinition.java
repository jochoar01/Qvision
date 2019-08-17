package com.tigoune.definitions;

import com.tigoune.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Clase que describe la definición para realizar el inicio de sesión en la aplicación Siebel
 */
public class LoginDefinition {
	
	@Steps
	LoginSteps loginsteps;

	@Given("^Que estoy en el inicio de la aplicacion Siebel$")
	public void estoyEnElInicioDeLaAplicacionSiebel() throws Exception {
		loginsteps.openBrowser();
	}

	@When("^ingrese las credenciales de accceso \"([^\"]*)\" y \"([^\"]*)\"$")
	public void ingreseLasCredencialesDeAccceso(String username, String password) throws Throwable {
		loginsteps.login(username, password);
	}

	@Then("^el login será exitoso$")
	public void elLoginSeraExitoso() throws Throwable {
		loginsteps.loadWait();
	}
}
