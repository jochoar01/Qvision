package com.tigoune.steps;

import com.tigoune.framework.Evidence;
import com.tigoune.models.OfferDomain;
import com.tigoune.pageobjects.*;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class CreateNewOfferSteps  {

	@Page
	 NewOfferPage newOfferPage;

	 CreateProductPage createProductPage =  new CreateProductPage();
	 

	 Evidence evidence = new Evidence(
				"Test login",
				"Creacion de oferta", 
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
				"CP02",
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
	public  void newOffer(List<OfferDomain> offerData) throws Exception {

		for(OfferDomain offer : offerData){
			createProductPage.searchOffer(offer.getOfferId());
			createProductPage.chooseOffer();
			newOfferPage.newOfferPage();
			evidence.screenshot("Se genera nueva oferta");
		}
	}

	@Step
	public  void offerData() throws Exception {
		newOfferPage.offerConfig();
		newOfferPage.bookOrder();
		evidence.screenshot("Se diligencian los campos de la oferta");
		evidence.CreateDocument();
	}
}