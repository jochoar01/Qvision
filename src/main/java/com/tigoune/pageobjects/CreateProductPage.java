package com.tigoune.pageobjects;

import com.tigoune.framework.ActionOnImages;
import com.tigoune.framework.WaitingHandler;
import net.serenitybdd.core.pages.PageObject;
import org.sikuli.script.FindFailed;

/**
 * Clase que contiene los métodos a utilizar en la creación de los productos  través de Siebel
 */
public class CreateProductPage  extends PageObject {

    String filepath = "src/test/resources/images/Siebel/CreateProduct";
    String waitPath = "src/test/resources/images/Siebel/WaitExceptions";

    ActionOnImages actionImage = new ActionOnImages();
    WaitingHandler waitingHandler = new WaitingHandler();

    public void searchOffer(String offerId) throws FindFailed {
        actionImage.clickImage("busquedaOferta.png",filepath);
        waitingHandler.explicitWait("beforeSearchOffer.png", waitPath);
        actionImage.typeImage("ofertaId.png",filepath,offerId);
        actionImage.writeEnterKey();
    }
    public void chooseOffer() throws  FindFailed {
       actionImage.coordinateImageClick("chooseOffer.png",filepath, 20,240);
        actionImage.writeEnterKey();
    }

    public void newProduct() throws FindFailed, InterruptedException {
       waitingHandler.explicitWait("offerLoad.png", waitPath);
        actionImage.wheelAction(1,3);
        waitingHandler.explicitWait("nuevoProducto.png", filepath);
        actionImage.clickImage("nuevoProducto.png",filepath);
    }

    public void searchProduct(String productName) throws FindFailed, InterruptedException {
        waitingHandler.explicitWait("beforeSearchWait.png",waitPath);
        actionImage.clickImage("nombreProducto.png",filepath);
        waitingHandler.explicitWait("searchProductWait", waitPath);
        actionImage.clickImage("maximize.png", filepath);

        /** Para el producto Televisión Hogares es necesario cambiar el criterio a través del cual se realiza la búsqueda
           debido a que la herramienta sikuli no soporta la escritura de caracteres como las tildes
         **/
        if(productName.equals( "Television_Hogares")) {
            actionImage.clickImage("cambiarCriterio.png", filepath);
            actionImage.clickImage("nPieza.png", filepath);
        }
        actionImage.coordinateImageClickX("empiece.png", filepath, 1100);
        actionImage.type(productName);
        actionImage.clickImage("ir", filepath);
        waitingHandler.explicitWaitVanish("chooseProductWait.png", waitPath);
    }

    public void writeTechType(String techType) throws FindFailed, InterruptedException {
        actionImage.clickImage("detalleMenos.png",filepath);
        actionImage.writeTabKey("1");
        actionImage.type(techType);
    }

    public void writeProductUse(String productUse) throws FindFailed, InterruptedException {
        actionImage.writeTabKey("1");
        waitingHandler.explicitWait("listWait.png", waitPath);
        actionImage.type(productUse);
    }

    public void writeBillingAccount() throws FindFailed, InterruptedException {
        actionImage.coordinateImageClickX("chooseProduct.png", filepath, 310);
        actionImage.click();
        actionImage.writeTabKey("2");
        waitingHandler.explicitWait("nombreProduct2.png", filepath );
        actionImage.clickImage("nombreProduct2.png", filepath);
        waitingHandler.explicitWait("chooseBillingWait.png", waitPath );
        actionImage.clickImage("aceptar.png", filepath);
        waitingHandler.explicitWaitVanish("cuentaServicioWait.png", filepath );
    }

    public void saveData() throws InterruptedException {
        actionImage.saveDataKey();
    }
}
