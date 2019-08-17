package com.tigoune.pageobjects;

import net.serenitybdd.core.pages.PageObject;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.sikuli.script.FindFailed;
import com.tigoune.framework.ActionOnImages;
import com.tigoune.framework.WaitingHandler;
import com.tigoune.utils.UtilCSV;

public class NewOfferPage extends PageObject {

	String filePath = "src/test/resources/images/Siebel/NewOffer";
	String loadWait = "src/test/resources/images/Siebel/WaitExceptions";
	ActionOnImages actionImage = new ActionOnImages();
	WaitingHandler waitingHandler = new WaitingHandler();
	UtilCSV utilCSV = new UtilCSV();
	public void newOfferPage() throws FindFailed, InterruptedException {
		/*
		 * actionImage.clickImage("1BotonFlechaAbajo.png", filePath);
		 * actionImage.clickImage("1BotonOfertasEconomicas.png", filePath);
		 * waitingHandler.explicitWait("EsperaAntesDeNuevaOferta.png", loadWait);
		 * actionImage.clickImage("2BotonNuevo.png", filePath);
		 * actionImage.clickImage("3ClickEnBlanco.png", filePath);
		 * waitingHandler.explicitWait("EsperaAntesEntrarOferta.png", loadWait);
		 * actionImage.coordinateImageClickX("2NumeroOferta.png", filePath, 50);
		 */
	}

	public void offerConfig() throws InterruptedException, FindFailed {
		waitingHandler.explicitWait("EsperaParaConfigurarOferta.png", loadWait);
		actionImage.coordinateImageClickX("6CanalDeVenta.png", filePath, 440);
		waitingHandler.explicitWait("EsperaVentanaCanalesDeVenta.png", loadWait);
		actionImage.clickImage("6Aceptar.png", filePath);
		waitingHandler.explicitWait("EsperaCanalDeVenta.png", loadWait);
		actionImage.coordinateImageClickX("5AsesorVenta.png", filePath, 440);
		waitingHandler.explicitWait("EsperaAsesorDeVenta.png", loadWait);
		actionImage.clickImage("6Aceptar.png", filePath);
		waitingHandler.explicitWait("EsperaNumeroLlamada.png", loadWait);
		actionImage.coordinateImageType("NumeroIvr.png", filePath, "12345672345", 440, 0);
		actionImage.coordinateImageClickX("ClickCheckBoxEmail.png", filePath, 1000);

	}

	public void bookOrder() throws FindFailed, InterruptedException {
		actionImage.clickImage("estudio.png", filePath);

		while (actionImage.existImage("estRiesgos.png", filePath).equals("N")) {
			actionImage.clickImage("actualizar.png", filePath);
			Thread.sleep(5000);

		}

		actionImage.coordinateImageClickX("estadEstLeg.png", filePath, 805);
		actionImage.writeKeyDownAndChoose("2");
		actionImage.coordinateImageClickX("subEstadEstLeg.png", filePath, 805);
		actionImage.writeKeyDownAndChoose("1");
		actionImage.clickImage("reservar.png", filePath);

		while (actionImage.existImage("pedidoGenerado.png", filePath).equals("N")) {
			actionImage.clickImage("actualizar.png", filePath);
			Thread.sleep(5000);

		}

	}

	public  void writeOrderData() throws FindFailed, InterruptedException, IOException, UnsupportedFlavorException {
		waitingHandler.explicitWait( "orderWait.png", loadWait);		
		actionImage.wheelAction(1, 1);		
		actionImage.clickImage("clickPedido.png", filePath);		
		waitingHandler.explicitWait( "esperaPedido.png", loadWait);	
		actionImage.wheelAction(1, 1);
		actionImage.coordinateImageClickX("buscarTipoPedido.png", filePath, 100);
		actionImage.doubleClick();		
		String order = actionImage.copyAndCaptureText();		
		List<Map<String, String>> readCSV = utilCSV.getRowsCSV("offerInfo", "exitoso"); 
		String result = readCSV.toString();		
		String[] parts = result.split("(,)");
		String part1 = parts[0]; // 123
		String part2 = parts[1]; // -654321				
		String part4 = parts[3];		
		String caso = part1.replaceAll("caso=", "").replaceAll("[^\\dA-Za-z]", "");
		String oferta = ";1-"+part2.replaceAll("oferta=", "").replaceAll("[^\\dA-Za-z]", "").replaceAll("1", "");
		String pedido = ";1-"+order;
		String columnaFiltro = ";"+part4.replaceAll("columnaFiltro=", "").replaceAll("[^\\dA-Za-z]", "");
		String sendCSV = caso+oferta+pedido+columnaFiltro;
		System.out.println(sendCSV);
		utilCSV.resultDataCSV(sendCSV);
		
	}
	
	
}