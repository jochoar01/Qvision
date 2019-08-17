package com.tigoune.pageobjects;

import com.tigoune.framework.WaitingHandler;
import com.tigoune.utils.UtilCSV;
import net.serenitybdd.core.pages.PageObject;
import org.sikuli.script.FindFailed;
import com.tigoune.framework.ActionOnImages;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Clase que describe como está mapeada la creación de clientes a través de venta ágil
 */
public class CustomerRegisterPage extends PageObject {

    String filepath = "src/test/resources/images/Siebel/CustomerRegister";
    String addressFilepath = "src/test/resources/images/Siebel/AddressSearch";
    String contacPersonPath = "src/test/resources/images/Siebel/ContactPerson";
    String waitPath = "src/test/resources/images/Siebel/WaitExceptions";

    ActionOnImages actionImage =new ActionOnImages();
    WaitingHandler waitingHandler = new WaitingHandler();
    UtilCSV utilCSV = new UtilCSV();

    public void accountClick() throws  FindFailed {
        actionImage.clickImage("account.png", filepath);
        waitingHandler.explicitWait("account.png", filepath);
        actionImage.clickImage("ventaAgil.png", filepath);
    }

    public void insertCustomerData(String firstname, String lastname, String documentType,
                                   String document,String expeditionDate, String phone, String email, String cellphone)
                                   throws FindFailed
    {
        waitingHandler.explicitWait("nuevo.png", filepath);
        actionImage.clickImage("nuevo.png", filepath);
        actionImage.clickImage("primerApellido.png", filepath);
        System.out.println(firstname);
        actionImage.typeImage("primerNombre.png", filepath, firstname);
        actionImage.typeImage("primerApellido.png", filepath, lastname);
        findDocumentType(documentType);
        actionImage.typeImage("documento.png", filepath, document);
        actionImage.typeImage("fechaExpedicion.png", filepath, expeditionDate);
        actionImage.typeImage("telefono.png", filepath, phone);
        actionImage.typeImage("correo.png", filepath, email);
        actionImage.typeImage("celular.png", filepath, cellphone);
    }

    public void findDocumentType(String documentType) throws FindFailed {
        actionImage.clickImage("tipodeDocir.png", filepath);
        actionImage.writeKeyDown(documentType);
    }

    public void addressSearch(String dpto, String city, String neighborhood, String address, String sector)
            throws FindFailed, InterruptedException {
        actionImage.clickImage("consultaDirec.png", addressFilepath);
        waitingHandler.explicitWait("consultaEspecif.png", addressFilepath);
        actionImage.writeKeyDown(dpto);
        actionImage.typeImage("cc_municipio.png", addressFilepath, city);
        actionImage.typeImage("cc_barrio.png", addressFilepath, neighborhood);
        actionImage.typeImage("cc_gis.png", addressFilepath, address);
        actionImage.typeImage("sector.png",addressFilepath, sector);
        actionImage.writeEnterKey();
        waitingHandler.explicitWait("exitoso.png", addressFilepath);
        Thread.sleep(3000);
        actionImage.clickImage("agregarDireccion.png", contacPersonPath);
        Thread.sleep(30000);
    }

    public void insertContactPerson() throws FindFailed {
        actionImage.clickImage("agregar.png", contacPersonPath);
        if ((actionImage.existImage("crmNoresponde.png",waitPath)).equals("Y")){
            waitingHandler.explicitWaitVanish("crmNoresponde.png", waitPath);
            actionImage.clickImage("agregar.png", contacPersonPath);
        }
        waitingHandler.explicitWait("aceptarContacto.png", contacPersonPath);
        actionImage.clickImage("aceptarContacto.png", contacPersonPath);
        waitingHandler.explicitWaitVanish("contactWait.png", waitPath);
    }

    public void writeOfferData() throws FindFailed, InterruptedException, IOException, UnsupportedFlavorException {
        String offerId;
        actionImage.wheelAction(1,2);
        waitingHandler.explicitWait("offerInBuild.png", filepath);
        actionImage.clickImage("offerInBuild.png", filepath);
        actionImage.writeTabKey("1");
        offerId = actionImage.copyAndCaptureText();
        offerId = "1;exitoso;" + offerId;
        utilCSV.resultDataCSV(offerId);
    }
    public void SaveFinalData() throws Exception {
        waitingHandler.explicitWait("generarDatos.png", contacPersonPath);
        Thread.sleep(3000);
        actionImage.clickImage("generarDatos.png", contacPersonPath);
        if ((actionImage.existImage("crmNoresponde.png",waitPath)).equals("Y")){
            waitingHandler.explicitWaitVanish("crmNoresponde.png", waitPath);
        }
        actionImage.clickImage("generarDatos.png", contacPersonPath);
        waitingHandler.explicitWaitVanish("generarDatos.png", contacPersonPath);
        writeOfferData();
        accountClick();
     }
}


