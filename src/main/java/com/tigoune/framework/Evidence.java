package com.tigoune.framework;

import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

public class Evidence {
	SimpleDateFormat date = new SimpleDateFormat("dd_MM_yyyy");
	String fechaString = date.format(new java.util.Date());
	public String testName;
	public File folder;
	public String portadatitulo; 			 
	public String portadaCodigoproyecto;
	public String portadacodigoRequerimiento;
	public String portadaNombreRequerimiento;
	public String portadaVersion;
	public String portadaFecha;
	public String aprobadoPorNombreElabora;
	public String aprobadoPorNombreRevisa;
	public String aprobadoPorNombreAprueba;
	public String historialdeVersionesDescripcionVersion;
	public String historialdeVersionesDescripcionFecha;
	public String historialdeVersionesDescripcionEstado;
	public String historialdeVersionesDescripcionGeneral;
	public String historialdeVersionesDetalleDescripcion;
	public String introduccionNombreEjecutor;
	public String introduccionnumeroCaso;
	public String introducciontextoNavegador;
	public String introducciondesDatosPrueba;
	public String introducciondescripcionDatosPrueba;
	public String introducciondescripcionTipoPrueba;
	public String introducciondescripcionResultado;
	public String introduccionnumeroIncidente;
	public String introducciondescripcionSistema;
	public String introducciondescripcionAmbiente;
	public String introducciondescripcionResultadoEsperado;

	public Evidence(
			
			String testName,
			String portadatitulo, 			 
			String portadaCodigoproyecto,
			String portadacodigoRequerimiento,
			String portadaNombreRequerimiento,
			String portadaVersion,
			String portadaFecha,
			String aprobadoPorNombreElabora,
			String aprobadoPorNombreRevisa,
			String aprobadoPorNombreAprueba,
			String historialdeVersionesDescripcionVersion,
			String historialdeVersionesDescripcionFecha,
			String historialdeVersionesDescripcionEstado,
			String historialdeVersionesDescripcionGeneral,
			String historialdeVersionesDetalleDescripcion,
			String introduccionNombreEjecutor,
			String introduccionnumeroCaso,
			String introducciontextoNavegador,
			String introducciondesDatosPrueba,
			String introducciondescripcionDatosPrueba,
			String introducciondescripcionTipoPrueba,
			String introducciondescripcionResultado,
			String introduccionnumeroIncidente,
			String introducciondescripcionSistema,
			String introducciondescripcionAmbiente,
			String introducciondescripcionResultadoEsperado
			
			) {
		this.testName = testName;
		
		this.portadatitulo=portadatitulo; 			 
		this.portadaCodigoproyecto=portadaCodigoproyecto;
		this.portadacodigoRequerimiento=portadacodigoRequerimiento;
		this.portadaNombreRequerimiento=portadaNombreRequerimiento;
		this.portadaVersion=portadaVersion;
		this.portadaFecha=portadaFecha;
		this.aprobadoPorNombreElabora=aprobadoPorNombreElabora;
		this.aprobadoPorNombreRevisa=aprobadoPorNombreRevisa;
		this.aprobadoPorNombreAprueba=aprobadoPorNombreAprueba;
		this.historialdeVersionesDescripcionVersion=historialdeVersionesDescripcionVersion;
		this.historialdeVersionesDescripcionFecha=historialdeVersionesDescripcionFecha;
		this.historialdeVersionesDescripcionEstado=historialdeVersionesDescripcionEstado;
		this.historialdeVersionesDescripcionGeneral=historialdeVersionesDescripcionGeneral;
		this.historialdeVersionesDetalleDescripcion=historialdeVersionesDetalleDescripcion;
		this.introduccionNombreEjecutor=introduccionNombreEjecutor;
		this.introduccionnumeroCaso=introduccionnumeroCaso;
		this.introducciontextoNavegador=introducciontextoNavegador;
		this.introducciondesDatosPrueba=introducciondesDatosPrueba;
		this.introducciondescripcionDatosPrueba=introducciondescripcionDatosPrueba;
		this.introducciondescripcionTipoPrueba=introducciondescripcionTipoPrueba;
		this.introducciondescripcionResultado=introducciondescripcionResultado;
		this.introduccionnumeroIncidente=introduccionnumeroIncidente;
		this.introducciondescripcionSistema=introducciondescripcionSistema;
		this.introducciondescripcionAmbiente=introducciondescripcionAmbiente;
		this.introducciondescripcionResultadoEsperado=introducciondescripcionResultadoEsperado;		
		
		this.folder = new File("src/test/resources/Evidence");
		this.folder.mkdir();
		this.folder = new File("src/test/resources/Evidence/Images");
		this.folder.mkdir();
		this.folder = new File("src/test/resources/Evidence/Images/EvidenceImages");
		this.folder.mkdir();
		this.folder = new File("src/test/resources/Evidence/Images/EvidenceImages/(Imagenes_" + this.testName+")_" + fechaString);		
		this.folder.mkdir();
		
		
	}

	public void screenshot(String name) throws Exception {

		BufferedImage screenshot = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		Thread.sleep(2000);
		// Guardar Como jpg
		String path = this.folder + "/" + name + ".jpg";
		File file = new File(path);
		ImageIO.write(screenshot, "jpg", file);
		GeneratePDF.insertPath(path);
	}

	public void CreateDocument() throws Exception {

		GeneratePDF.generatePDF(
				
				this.testName,
				this.portadatitulo, 			 
				this.portadaCodigoproyecto,
				this.portadacodigoRequerimiento,
				this.portadaNombreRequerimiento,
				this.portadaVersion,
				this.portadaFecha,
				this.aprobadoPorNombreElabora,
				this.aprobadoPorNombreRevisa,
				this.aprobadoPorNombreAprueba,
				this.historialdeVersionesDescripcionVersion,
				this.historialdeVersionesDescripcionFecha,
				this.historialdeVersionesDescripcionEstado,
				this.historialdeVersionesDescripcionGeneral,
				this.historialdeVersionesDetalleDescripcion,
				this.introduccionNombreEjecutor,
				this.introduccionnumeroCaso,
				this.introducciontextoNavegador,
				this.introducciondesDatosPrueba,
				this.introducciondescripcionDatosPrueba,
				this.introducciondescripcionTipoPrueba,
				this.introducciondescripcionResultado,
				this.introduccionnumeroIncidente,
				this.introducciondescripcionSistema,
				this.introducciondescripcionAmbiente,
				this.introducciondescripcionResultadoEsperado
				
				);
		System.out.println("Se genera documento con nombre " + this.testName + ".pdf");
	}

}
