package com.tigoune.steps;

import com.tigoune.framework.Evidence;
import com.tigoune.models.CustomerDomain;

import com.tigoune.pageobjects.*;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

/**
 * Clase que describe los steps para realizar la creación del cliente en la
 * aplicación Siebel
 *
 * @author PAOLA.AGUDELO
 */
public class CustomerRegisterSteps {

    @Page
     CustomerRegisterPage customerPages;
    
    Evidence evidence = new Evidence(
			"Test login",
			"Creacion de usuario", 
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
    public  void chooseNewClient() throws Exception {
        customerPages.accountClick();
        evidence.screenshot("Se ingresa a pagina de creacion de cuentas");
    }
    @Step
    public void createNewCustomer(List<CustomerDomain> customerData) throws Exception {
        for (CustomerDomain data : customerData) {
            customerPages.insertCustomerData(data.getFirstname(), data.getLastname(),
                    data.getDocumentType(), data.getDocument(),
                    data.getExpeditionDate(), data.getPhone(),
                    data.getEmail(), data.getCellphone());
            evidence.screenshot("Se insertan datos basicos del cliente");
            customerPages.insertContactPerson();
            evidence.screenshot("Se asocia el contacto para el cliente");
            customerPages.addressSearch(data.getDpto(), data.getCity(), data.getNeighborhood(),
                    data.getAddress(), data.getSector());
            customerPages.SaveFinalData();
            evidence.screenshot("Se guardan los datos");
            evidence.CreateDocument();
        }
    }
}