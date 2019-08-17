package com.tigoune.definitions;

import com.tigoune.models.CustomerDomain;
import com.tigoune.steps.CustomerRegisterSteps;
import com.tigoune.utils.UtilCSV;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Clase que describe la definición para realizar el registro de un cliente nuevo en Siebel
 */
public class CustomerRegisterDefinition {

    @Steps
    CustomerRegisterSteps customerSteps;

    UtilCSV utilsCsv = new UtilCSV();
    CustomerDomain customerDomain;

    @Given("^Usuario elige nuevo$")
    public void usuario_elige_nuevo() throws Throwable{
       customerSteps.chooseNewClient();
    }

    @When("^Usuario ingresa los datos del nuevo cliente$")
    public void usuario_ingresa_los_datos_del_nuevo_cliente() throws Exception {
        customerDomain = new CustomerDomain(utilsCsv.getRowsCSV("customerData","exitoso"));
        customerSteps.createNewCustomer(customerDomain.getLstUsers());
    }

    @Then("^El usuario se crea exitosamente$")
    public void el_usuario_se_crea_exitosamente()  {
    }
}
