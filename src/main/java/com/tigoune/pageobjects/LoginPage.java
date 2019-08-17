package com.tigoune.pageobjects;

import com.tigoune.framework.Evidence;
import com.tigoune.framework.WaitingHandler;
import org.sikuli.script.FindFailed;
import com.tigoune.framework.ActionOnImages;
import net.serenitybdd.core.pages.PageObject;

/**
 * Clase que describe como está mapeado el inicio de sesión en la aplicación Siebel
 * @author PAOLA.AGUDELO
 */
public class LoginPage extends PageObject {

	public String filepath = "src/test/resources/images/Siebel/login";
	public String loginWait = "src/test/resources/images/Siebel/WaitExceptions";

    ActionOnImages actionImage = new ActionOnImages();
    WaitingHandler waitingHandler = new WaitingHandler();

	public void SendData(String username, String password) throws Exception {
		waitingHandler.explicitWait( "loginWait.png", loginWait);
		actionImage.clickImage("capture.png", filepath);
		actionImage.typeImage("username.png", filepath, username);
		actionImage.typeImage("password.png", filepath, password);
		actionImage.clickImage("next.png", filepath);
	}

	public void loadWait() throws Exception {
		if(actionImage.existImage("warning.png", filepath).equals( "Y")){
			actionImage.clickImage("close", filepath);
		}
	    waitingHandler.explicitWait("loadWait.png", loginWait);

    }
}
