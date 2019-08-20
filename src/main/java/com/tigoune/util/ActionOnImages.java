package com.tigoune.util;

import org.sikuli.script.*;



/** Métodos genéricos para realizar las accciones sobre la pantalla */

public class ActionOnImages {
    private static final double FOREVER = 0;
	String[] resultData = new String[3];
    static Screen screen = new Screen();

    public ActionOnImages(){}

    public ActionOnImages(String resultData) {
        this.resultData[0] = resultData;
    }

    /** Métodos asociados a la acción click*/
    public static void click() {
         screen.click();
    }
    public void doubleClick() {
        screen.doubleClick();
   }
    public static void clickImage(String imageName, String filepath) throws FindFailed, InterruptedException {
    	Thread.sleep(3000);
        screen.click(filepath + "\\" + imageName);
    }



     /** Métodos asociados a la acción escribir en pantalla */
     public static void type(String textToSend) throws InterruptedException {
         Thread.sleep(2000);
         screen.type(textToSend);
     }
     public static void typeImage(String imageName, String filepath, String textToSend) throws FindFailed {
        screen.click(filepath + "\\" + imageName);
        screen.type(textToSend);
     }


     /** Escribir  Enter */
    public static void writeEnterKey() {
        screen.type(Key.ENTER);
    }    
    
	public static void explicitWait(String imageName, String filepath) throws FindFailed {
		Pattern waitImage = new Pattern(filepath +"/"+ imageName );
		screen.wait(waitImage, FOREVER);
	}
	/** Espera hasta que desaparezca el patr�n  en la pantalla */
	public void explicitWaitVanish(String imageName, String filepath) {
		Pattern waitImage = new Pattern(filepath +"/"+ imageName);
		screen.waitVanish(waitImage, FOREVER);
	}
}


