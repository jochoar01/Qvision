package com.tigoune.framework;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import static org.sikuli.script.Constants.FOREVER;

/** Métodos  para realizar las esperas en pantalla*/
public class WaitingHandler {

	Screen screen = new Screen();

	/** Espera hasta que aparezca el patrón en la pantalla */
	public void explicitWait(String imageName, String filepath) throws FindFailed {
		Pattern waitImage = new Pattern(filepath +"/"+ imageName );
		screen.wait(waitImage, FOREVER);
	}
	/** Espera hasta que desaparezca el patrón  en la pantalla */
	public void explicitWaitVanish(String imageName, String filepath) {
		Pattern waitImage = new Pattern(filepath +"/"+ imageName);
		screen.waitVanish(waitImage, FOREVER);
	}
}
