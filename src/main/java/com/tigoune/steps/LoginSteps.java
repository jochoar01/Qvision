package com.tigoune.steps;

import com.tigoune.framework.Evidence;
import com.tigoune.framework.InitialConfig;
import com.tigoune.pageobjects.LoginPage;

import org.fluentlenium.core.annotation.Page;
import net.thucydides.core.annotations.Step;


/**
 * Clase que describe los steps para realizar el inicio de sesión en la aplicación Siebel
 * @author PAOLA.AGUDELO
 */
public class LoginSteps {

	@Page
	private static LoginPage loginpage;

	static InitialConfig initialConfig = new InitialConfig();
	static Evidence evidence = new Evidence(
			"Test login",
			"Prueba inicio de sesion a la aplicacion SIEBEL", 
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
			"CP01",
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
	public static void openBrowser() throws Exception{
		initialConfig.webBroserConfig("explorer", "http://crmpre/ecommunications_esn/start.swe?");
		evidence.screenshot("Se abre navegador y se inserta URL");
	} 

	@Step
	public static void login(String username, String password) throws Exception {
			loginpage.SendData(username, password);
			evidence.screenshot("Se inserta usuario y contraseña");
	}
	@Step
	public static void loadWait() throws Exception {
		loginpage.loadWait();
		evidence.screenshot("inicio de sesion exitoso");
		evidence.introducciondescripcionResultado="EXITOSO";
		evidence.CreateDocument();
		/* Si se desea cerrar el navegador después de la prueba descomentar */
		initialConfig.closeBrowser("explorer");
	}
}
