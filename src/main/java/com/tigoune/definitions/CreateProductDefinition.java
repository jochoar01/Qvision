package com.tigoune.definitions;

import com.tigoune.models.OfferDomain;
import com.tigoune.steps.CreateProductSteps;
import com.tigoune.utils.UtilCSV;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Clase que describe la definición para realizar la personalización de la oferta comercial en la aplicación Siebel
 */
public class CreateProductDefinition {

    @Steps
    CreateProductSteps createProductSteps;

    UtilCSV utilsCsv = new UtilCSV();
    OfferDomain offerDomain;

    @Given("^que un usuario tiene una oferta creada$")
    public void queUnUsuarioTieneUnaOfertaCreada() throws Exception {
        offerDomain = new OfferDomain(utilsCsv.getRowsCSV("offerInfo", "exitoso"));
        createProductSteps.newProduct(offerDomain.getLstOffers());
    }
    @When("^crea un nuevo producto \"([^\"]*)\" con tecnologia \"([^\"]*)\" uso \"([^\"]*)\"$")
    public void creaUnNuevoProductoConTecnologiaUso(String productName, String techType, String use) throws Throwable {
        createProductSteps.insertProductData(productName, techType, use);
    }
    @And("^realiza la personalizacion con  plan \"([^\"]*)\"$")
    public void realizaLaPersonalizacionConPlan(String plan) throws Throwable {
        createProductSteps.customizeOffer(plan);
    }
    @And("^realiza la personalizacion con \"([^\"]*)\"  \"([^\"]*)\"$")
    public void realizaLaPersonalizacionConY(String planBA, String planTV) throws Throwable {
        createProductSteps.customizeMultOffer(planBA,planTV);
    }
    @Then("^el producto es personalizado")
    public void elProductoEsPersonalizado() throws Throwable {
        createProductSteps.saveNewProduct();
    }
}
