package com.tigoune.definitions;

import com.tigoune.models.OfferDomain;
import com.tigoune.utils.UtilCSV;
import com.tigoune.steps.CreateNewOfferSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Clase que describe la definición para realizar la creación de la oferta  en la aplicación Siebel
 */
public class CreateNewOfferDefinition {

    @Steps
    CreateNewOfferSteps createNewOffer;

	UtilCSV utilsCsv = new UtilCSV();
	OfferDomain offerDomain;
	
	@Given("^Usuario elige nueva oferta$")
	public void usuario_elige_nueva_oferta() throws Exception {
		offerDomain = new OfferDomain(utilsCsv.getRowsCSV("offerInfo","exitoso"));
		createNewOffer.newOffer(offerDomain.getLstOffers());

	}

	@When("^Usuario ingresa los datos necesarios de la oferta$")
	public void usuario_ingresa_los_datos_necesarios_de_la_oferta() throws Exception {
	createNewOffer.offerData();
	}

	@Then("^La oferta se crea exitosamente$")
	public void la_oferta_se_crea_exitosamente() {
		
	}

}
