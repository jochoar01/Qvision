package com.tigoune.framework;

import org.sikuli.script.*;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/** Métodos genéricos para realizar las accciones sobre la pantalla */

public class ActionOnImages {
    String[] resultData = new String[3];
    Screen screen = new Screen();

    public ActionOnImages(){}

    public ActionOnImages(String resultData) {
        this.resultData[0] = resultData;
    }

    /** Métodos asociados a la acción click*/
    public void click() {
         screen.click();
    }
    public void doubleClick() {
        screen.doubleClick();
   }
    public void clickImage(String imageName, String filepath) throws FindFailed {
        screen.click(filepath + "\\" + imageName);
    }
    public void doubleClickImage(String imageName, String filepath) throws FindFailed, InterruptedException {
        screen.doubleClick(filepath + "\\" + imageName);
        Thread.sleep(4000);
    }
    public void coordinateClick(int x, int y) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(3000);
        screen.h = 1;
        screen.w = 1;
        screen.x = x;
        screen.y = y;
        screen.capture();
        screen.click();
    }
    public void coordinateImageClick(String imageName, String filepath, int moveX, int moveY) throws  FindFailed {
        Match image = screen.find(filepath + "\\" + imageName);
        image.click();
        image.x = moveX;
        image.y = moveY;
        image.click();
    }
    public void coordinateImageClickX(String imageName, String filepath, int moveX)
            throws FindFailed, InterruptedException {
        Match image = screen.find(filepath + "\\" + imageName);
        image.click();
        Thread.sleep(5000);
        image.x = moveX;
        image.click();
    }
     public void wheelAction(int direction, int steps) throws InterruptedException {
         screen.wheel(direction, steps);
         Thread.sleep(4000);
     }

     /** Métodos asociados a la acción escribir en pantalla */
     public void type(String textToSend) throws InterruptedException {
         Thread.sleep(2000);
         screen.type(textToSend);
     }
     public void typeImage(String imageName, String filepath, String textToSend) throws FindFailed {
        screen.click(filepath + "\\" + imageName);
        screen.type(textToSend);
     }

     /** Métodos asociados  a acciones con el teclado
     /** Escribir  @ */
    public void writeAtKey(String InitString, String finalString) {
        screen.type(InitString + "2", Key.SHIFT);
        screen.type(finalString);
    }
     /** Escribir  Enter */
    public void writeEnterKey() {
        screen.type(Key.ENTER);
    }
     /** Escribir  Tab */
    public void writeTabKey(String tabsNumber) throws InterruptedException {
        int limit = Integer.parseInt(tabsNumber);
        for (int i = 0; i < limit; i = i + 1) {
            Thread.sleep(2000);
            screen.type(Key.TAB);
        }
    }
     /** Escribir  Espacio */
    public void writeSpaceTab() {
        screen.type(Key.SPACE);
    }
     /** Escribir  Ctrl S "Guardar" */
    public void saveDataKey() throws InterruptedException {
        Thread.sleep(2000);
        screen.type("S", Key.CTRL);
    }
     /** Escribir  Flecha abajo */
     public void writeKeyDown(String tabsNumber){
         int limit = Integer.parseInt(tabsNumber);
         for (int i = 0; i <= limit; i = i + 1) {
             screen.type(Key.DOWN);
         }
         screen.type(Key.ENTER);
     }
     /** Escribir  Flecha abajo y Tecla enter (Sirve para seleccionar )*/
     public void writeKeyDownAndChoose(String tabsNumber){
         int limit = Integer.parseInt(tabsNumber);
         for (int i = 0; i < limit; i = i + 1) {
             screen.type(Key.DOWN);
         }
         screen.type(Key.ENTER);
     }

     /** Métodos con acciones combinadas */
     public void coordinateImageType(String imageName, String filepath, String textToSend, int moveX, int desplazamientoy) throws   FindFailed {
        Screen screen = new Screen();
        Match image = screen.find(filepath + "\\" + imageName);
        image.click();
        image.x = moveX;
        image.click();
        screen.type(textToSend);
    }
    /** Busca una cadena en la pantalla y da click sobre las coordenadas indicadas
     *  Ejemplo de uso: Marcar check box
     * Nota: No reconoce espacios en blanco */

    public void findTextAndMove(String textToSearch, int moveX) throws FindFailed {
        Match text;
        text = screen.findText(textToSearch);
        int move = text.x - moveX;
        text.click();
        text.x = text.x - move;
        text.click();
    }
     /** Copiar el texto en pantalla */
    public String copyAndCaptureText() throws UnsupportedFlavorException, IOException, InterruptedException {
        Thread.sleep(3000);
        screen.type("C", Key.CTRL);
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

        if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            String text = (String) t.getTransferData(DataFlavor.stringFlavor);
            return text;
        }
        return null;
    }
    /** Copiar el texto en pantalla: personalizado para la oferta */
    public String copyAndCaptureOfferAndOrder() throws UnsupportedFlavorException, IOException {
        String data = null;
        screen.doubleClick();
        screen.type("C", Key.CTRL);
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor) && this.resultData[0] != null) {
            if (this.resultData[1] == null) {
                String text = (String) t.getTransferData(DataFlavor.stringFlavor);
                this.resultData[1] = text;
            } else if (this.resultData[2] == null) {
                String text = (String) t.getTransferData(DataFlavor.stringFlavor); 
                this.resultData[2] = text;
            }
        }
        data = this.resultData[0] + ";1-" + this.resultData[1] + ";1-" + this.resultData[2];
        return data;

    }

    /** Valida si en la pantalla actual existe la imagen dada */
    public String existImage(String imageName, String filepath){
        if (null != screen.exists(filepath + "\\" + imageName)) {
        return "Y";
        } else {
        return "N"; 
        }
    }
}


