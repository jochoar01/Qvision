package com.tigoune.pageobjects;

import com.tigoune.framework.ActionOnImages;
import com.tigoune.framework.WaitingHandler;
import net.serenitybdd.core.pages.PageObject;
import org.sikuli.script.FindFailed;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Clase que contiene los métodos a utilizar en la personalización de las ofertas través de Siebel
 * @author PAOLA.AGUDELO
 */

public class CustomizeOfferPage extends PageObject {
    private String filepath = "src/test/resources/images/Siebel/CreateProduct";
    private String customizePath = "src/test/resources/images/Siebel/CustomizeOffer";
    private String waitPath = "src/test/resources/images/Siebel/WaitExceptions";

    ActionOnImages actionImage = new ActionOnImages();
    WaitingHandler waitingHandler = new WaitingHandler();

    /**Permite realizar la personalización de productos individuales **/
    public void insertNewProduct(String plan) throws FindFailed, InterruptedException, IOException, UnsupportedFlavorException {
        String text;
        if ((actionImage.existImage("uno.png", customizePath)).equals("Y")) {
            System.out.println("iinsersión1Product1 ");
            actionImage.doubleClickImage("1.png", customizePath);
            actionImage.writeTabKey("1");
            text = actionImage.copyAndCaptureText();
            validateProduct(text, plan, plan);
        }
        System.out.println("iinsersión1Product1 ");
    }

    /**  Permite realizar la personalización de productos TRIO  **/
     public void insertMulProduct( String planBA, String planTV) throws FindFailed, InterruptedException, IOException, UnsupportedFlavorException {
        String text;
        int i=1;
        while ( i!= 5) {
            if ((actionImage.existImage(i + ".png",customizePath)).equals("Y")){
                actionImage.doubleClickImage(i + ".png", customizePath);
                Thread.sleep(2000);
                actionImage.writeTabKey("1");
                text = actionImage.copyAndCaptureText();
                validateProduct(text, planBA, planTV);
            }
            i++;
        }
    }
    /** Valida el tipo de producto que se intenta personalizar para saber si es TO, TV, BA **/
    private void validateProduct(String text, String planBA, String planTV) throws FindFailed, InterruptedException {

        customizeOffer();
        if(actionImage.existImage("alreadyCustomize.png", customizePath).equals("Y")) {
            if (text.equals("Televisión Hogares")) {
                /*Para producto TV */
                chooseItemPlan(planTV);
                chooseChannelPlan("4");
                chooseTermContract("2");
                chooseEquipment("1");

                /* Para productos TO - BA */
            } else if ((text.equals("Telefonía")) || (text.equals("Internet"))) {
                if(text.equals("Telefonía")) {
                    choosePlansAndServ("2");
                }else{
                    choosePlansAndServ(planBA);
                }
                chooseTermContract("2");
            }
        }
        finishCustomization();
    }
    /**
     * Permite lanzar el botón para la personalización
     */
    private void customizeOffer() throws FindFailed {
        waitingHandler.explicitWait("personalizar.png", filepath);
        actionImage.clickImage("personalizar.png", filepath);
        waitingHandler.explicitWaitVanish("personalizar.png", filepath);
    }

    /**
     * Realiza las acciones correspondientes al contrato de permanencia
     */
    private void chooseTermContract(String term) throws FindFailed, InterruptedException {
        Thread.sleep(3000);
        actionImage.doubleClickImage("permanencia.png", customizePath);
        waitingHandler.explicitWait("TermContractWait.png",waitPath );
        actionImage.clickImage("planIr.png", filepath);
        actionImage.writeKeyDownAndChoose(term);
        waitingHandler.explicitWait("planIr.png", filepath);
    }

    /**
     * Permite lanzar el botón terminado para la personalización
     */
    private void finishCustomization() throws FindFailed, InterruptedException {
        actionImage.clickImage("terminado.png", customizePath);
        waitingHandler.explicitWait("ofertaEconomica.png", customizePath);
        actionImage.wheelAction(1, 3);
    }

    /**
     * Métodos definidos para la personalización del producto TV
     * @author PAOLA.AGUDELO
     */
    /**
     * Permite elegir un plan de TV
     */
    private void chooseItemPlan(String plan) throws FindFailed, InterruptedException {
        actionImage.wheelAction(1,2);
        waitingHandler.explicitWait("planIr.png", filepath);
        actionImage.clickImage("planIr.png", filepath);
        actionImage.writeKeyDownAndChoose(plan);
        waitingHandler.explicitWait("checkedBox.png", customizePath);
        waitingHandler.explicitWait("boxChecked", customizePath);
    }

    /**
     * Permite elegir el plan de canales
     */
    private void chooseChannelPlan(String plan) throws InterruptedException, FindFailed {
        waitingHandler.explicitWait("planIr.png", filepath);
        actionImage.clickImage("planIr.png", filepath);
        actionImage.writeTabKey(plan);
        actionImage.writeSpaceTab();
    }

    /**
     * Permite elegir el equipo para la personalización
     */
    private void chooseEquipment(String item) throws FindFailed {
        actionImage.clickImage("equipamiento.png", customizePath);
        waitingHandler.explicitWait("equipmentWait.png", waitPath);
        actionImage.clickImage("equipmentItem.png", customizePath);
        actionImage.writeKeyDownAndChoose("1");
        actionImage.clickImage("equipmentCustom.png", customizePath);
        waitingHandler.explicitWait("equipmentBack.png", customizePath);
        actionImage.clickImage("equipmentType.png", customizePath);
        actionImage.writeKeyDownAndChoose(item);
    }

    /**
     * Métodos definidos para la personalización de los productos  TO -BA
     * @author PAOLA.AGUDELO
     */

    /**Permite elegir el plan y servicio para los productos
     */
    private void  choosePlansAndServ(String plan) throws FindFailed, InterruptedException {
        waitingHandler.explicitWait("planAndService.png", customizePath);
        actionImage.wheelAction(-1, -2);
        actionImage.clickImage("planAndService.png", customizePath);
        actionImage.writeKeyDownAndChoose(plan);
        waitingHandler.explicitWait("planIr.png", filepath);
    }
}

