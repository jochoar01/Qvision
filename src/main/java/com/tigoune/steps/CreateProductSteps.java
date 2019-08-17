package com.tigoune.steps;

import com.tigoune.framework.Evidence;
import com.tigoune.models.OfferDomain;
import com.tigoune.pageobjects.CreateProductPage;
import com.tigoune.pageobjects.CustomizeOfferPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import java.util.List;

/**
 * Clase que describe los steps para realizar la adición de productos a una
 * oferta económica
 * 
 * @author PAOLA.AGUDELO
 */
public class CreateProductSteps  {

	@Page
	 CreateProductPage createProductPage;
	@Page
	 CustomizeOfferPage customizeOfferPage;
	
	 Evidence evidence = new Evidence(
				"Test login",
				"Creacion de producto en oferta", 
				"PR-001",
				"REQ-001",
				"Prueba E2E",
				"001", 
				"09/01/2019",
				"Juan Ochoa", 
				"Paola Rendon", 
				"Yurani Perez", 
				"001", 
				"09/01/2019", 
				"Activo",
				"Descripcion del requerimiento", 
				"Versiones del documento",
				"Juan Ochoa", 
				"CP03",
				"Internet Explorer",
				"Nombre De usuario",
				"N/A", 
				"Automatizada", 
				"N/A", 
				"N/A", 
				"SIEBEL",
				"PRUEBAS", 
				"Se espera inicio de sesion exitoso");

	@Step
	public  void newProduct(List<OfferDomain> offerData) throws Exception {
		for (OfferDomain offer : offerData) {
			createProductPage.searchOffer(offer.getOfferId());
			createProductPage.chooseOffer();
			createProductPage.newProduct();
			evidence.screenshot("Se crea el nuevo producto");
		}
	}

	@Step
	public  void insertProductData(String productName, String techType, String use) throws Exception {
		createProductPage.searchProduct(productName);
		createProductPage.writeTechType(techType);
		createProductPage.writeProductUse(use);
		evidence.screenshot("Se insertan los datos del producto");
	}
	@Step
	public  void customizeOffer(String planP) throws Exception {
		customizeOfferPage.insertNewProduct(planP);
		createProductPage.writeBillingAccount();
		evidence.screenshot("Se personaliza oferta");
	}
	@Step
	public  void customizeMultOffer(String planBA,String planTV) throws Exception {
		customizeOfferPage.insertMulProduct(planBA, planTV);
		createProductPage.writeBillingAccount();
		evidence.screenshot("Se personaliza oferta");

	}
	@Step
	public void saveNewProduct() throws Exception {
		createProductPage.saveData();
		evidence.screenshot("Se guardan datos");
		evidence.CreateDocument();
	}
}
