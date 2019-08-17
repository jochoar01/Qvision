package com.tigoune.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Image;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import com.itextpdf.text.BaseColor;

import com.itextpdf.text.pdf.PdfPCell;

import com.itextpdf.text.pdf.PdfTemplate;

public class GeneratePDF {
	



	static PdfTemplate total;
	static Document document = new Document();
	static ArrayList<String> photoName = new ArrayList<>();

	static Font calibriFont = new Font(Font.FontFamily.UNDEFINED, 16, Font.BOLD);
	static Font calibriFontItalica = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLDITALIC);
	static Font calibriFontUnderline = new Font(Font.FontFamily.UNDEFINED, 11, Font.UNDERLINE);
	static Font calibriFontNormal = new Font(Font.FontFamily.UNDEFINED, 11, Font.NORMAL);
	static Font calibriFontNegrilla = new Font(Font.FontFamily.UNDEFINED, 11, Font.BOLD);
	static Font calibriFontNormalRoja = new Font(Font.FontFamily.UNDEFINED, 11, Font.NORMAL, BaseColor.RED);
	static Font calibriFontDos = new Font(Font.FontFamily.UNDEFINED, 14, Font.NORMAL);
	static Font arialFont = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);

	

	
	public static void generatePDF(
			
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
			
			) throws Exception {
		
		SimpleDateFormat fecha = new SimpleDateFormat("dd_MM_yyyy");
		String fechaString = fecha.format(new java.util.Date());
		File folder = new File("src/test/resources/Evidence/PDF");
		folder.mkdir();
		String File = "src/test/resources/Evidence/PDF/" + "(" + testName + ")_" + fechaString + ".pdf";

		PdfWriter.getInstance(document, new FileOutputStream(File));

		document.open();

		imagenSophosInicial();
		portada(

				portadatitulo, 			 
				portadaCodigoproyecto,
				portadacodigoRequerimiento,
				portadaNombreRequerimiento,
				portadaVersion,
				portadaFecha
				
				);

		document.newPage();
		imagenSophosEncabezado();
		aprobadoPor(

				aprobadoPorNombreElabora,
				aprobadoPorNombreRevisa,
				aprobadoPorNombreAprueba
				
				);

		document.newPage();
		imagenSophosEncabezado();
		indice();

		document.newPage();
		imagenSophosEncabezado();
		historialdeVersiones(

				historialdeVersionesDescripcionVersion,
				historialdeVersionesDescripcionFecha,
				historialdeVersionesDescripcionEstado,
				historialdeVersionesDescripcionGeneral,
				historialdeVersionesDetalleDescripcion
				
				);

		document.newPage();
		imagenSophosEncabezado();
		introduccion(

				introduccionNombreEjecutor,
				introduccionnumeroCaso,
				introducciontextoNavegador,
				introducciondesDatosPrueba,
				introducciondescripcionDatosPrueba,
				introducciondescripcionTipoPrueba,
				introducciondescripcionResultado,
				introduccionnumeroIncidente,
				introducciondescripcionSistema,
				introducciondescripcionAmbiente,
				introducciondescripcionResultadoEsperado
				
				);
       
		document.newPage();

		for (int i = 0; i < photoName.size(); i++) {

			String string = photoName.get(i);
			String[] parts = string.split("/");
			String part2 = parts[1];

			imagenSophosEncabezado();
			document.add(new Paragraph(part2.replaceFirst("[\\s\\S]{0,3}$", "")));
			Image Foto = Image.getInstance(photoName.get(i));
			Foto.scaleAbsoluteWidth(500f);
			Foto.scaleAbsoluteHeight(350f);
			document.add(Foto);
			document.newPage();

		}
		document.close();
		System.out.println("Se genera Documento");
	}

	public static void insertPath(String param) throws DocumentException, MalformedURLException, IOException {

		photoName.add(param);
		System.out.println("Se inserta " + param + " al documento");

	}

	public static void portada(
			
			String portadatitulo, 			 
			String portadaCodigoproyecto,
			String portadacodigoRequerimiento,
			String portadaNombreRequerimiento,
			String portadaVersion,
			String portadaFecha
			
			)throws DocumentException, MalformedURLException, IOException {

		Paragraph portadaTitulo = new Paragraph(portadatitulo, calibriFont);
		Paragraph portadaEvidencia = new Paragraph("Evidencias de Pruebas Funcionales", calibriFont);
		Paragraph portadaProyecto = new Paragraph(
				"Código Proyecto: "+portadaCodigoproyecto+" \n" + 
		        "\tCódigo Requerimiento: "+portadacodigoRequerimiento+" \n"+ 
				"\tNombre Requerimiento: "+portadaNombreRequerimiento+" \n" + 
		        "\tVersión: "+portadaVersion+" \n" + 
				"\tFecha: "+portadaFecha,
				calibriFontDos);
		portadaTitulo.setAlignment(Element.EMPTY);
		portadaEvidencia.setAlignment(Element.READONLY);
		portadaProyecto.setAlignment(Element.EMPTY);
		document.add(new Phrase("\n\n\n\n\n"));
		document.add(portadaTitulo);
		document.add(new Phrase("\n\n\n\n\n\n\n"));
		document.add(portadaEvidencia);
		document.add(new Phrase("\n\n\n\n\n"));
		document.add(portadaProyecto);

	}

	public static void imagenSophosEncabezado() throws DocumentException, MalformedURLException, IOException {

		Image foto = Image.getInstance("src/test/resources/images/Framework/ConfigPDF/EncabezadoFinal.png");
		foto.scaleAbsoluteWidth(450f);
		foto.scaleAbsoluteHeight(80f);
		foto.setAlignment(Element.READONLY);
		document.add(foto);

	}

	public static void aprobadoPor(
			String aprobadoPorNombreElabora,
			String aprobadoPorNombreRevisa,
			String aprobadoPorNombreAprueba
			
			) throws DocumentException, MalformedURLException, IOException {

		document.add(new Phrase("\n\n\n\n\n\n\n"));
		Paragraph aprobado = new Paragraph("Documento aprobado por:", calibriFontUnderline);
		aprobado.setAlignment(Element.EMPTY);
		document.add(aprobado);

		document.add(new Phrase("\n\n\n\n"));

		Phrase elaboradoPor = new Phrase("Elaborado Por:", calibriFontNegrilla);
		Phrase revisadoPor = new Phrase("Revisado Por:", calibriFontNegrilla);
		Phrase aprobadoPor = new Phrase("Aprobado Por", calibriFontNegrilla);
		Phrase nombreElabora = new Phrase(aprobadoPorNombreElabora + "\n______________ \nSophos Solutions", calibriFontNormal);
		Phrase nombreRevisa = new Phrase(aprobadoPorNombreRevisa + "\n______________ \nSophos Solutions", calibriFontNormal);
		Phrase nombreAprueba = new Phrase(aprobadoPorNombreAprueba + "\n______________ \n Sophos Solutions / Tigo � Une",
				calibriFontNormal);

		PdfPTable table = new PdfPTable(3);
		PdfPCell cell = new PdfPCell();
		PdfPCell cell2 = new PdfPCell();
		PdfPCell cell3 = new PdfPCell();

		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);

		cell.addElement(elaboradoPor);
		table.addCell(cell);

		cell2.addElement(revisadoPor);
		table.addCell(cell2);

		cell3.addElement(aprobadoPor);
		table.addCell(cell3);

		table.addCell(nombreElabora);
		table.addCell(nombreRevisa);
		table.addCell(nombreAprueba);
		document.add(table);

		document.add(new Phrase("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));
		Paragraph copyright = new Paragraph("Copyright", calibriFontNormal);
		Paragraph sophosS = new Paragraph("Sophos Solutions", calibriFontNormalRoja);
		Paragraph ciudadPais = new Paragraph("Bogotá, Colombia", calibriFontNormal);
		copyright.setAlignment(Element.READONLY);
		sophosS.setAlignment(Element.READONLY);
		ciudadPais.setAlignment(Element.READONLY);
		document.add(copyright);
		document.add(sophosS);
		document.add(ciudadPais);
	}

	public static void indice() throws DocumentException, MalformedURLException, IOException {

		Paragraph indice = new Paragraph("1. Índice", calibriFont);
		indice.setAlignment(Element.READONLY);
		document.add(indice);

		document.add(new Phrase("\n\n\n"));
		Paragraph indiceDos = new Paragraph(
				"1. Índice.........................................................................................................................................3",
				calibriFontItalica);
		indiceDos.setAlignment(Element.EMPTY);
		Paragraph historialVersiones = new Paragraph(
				"2. Historial de Versiones..............................................................................................................4",
				calibriFontItalica);
		historialVersiones.setAlignment(Element.EMPTY);
		Paragraph introduccion = new Paragraph(
				"3. INTRODUCCION........................................................................................................................5",
				calibriFontItalica);
		introduccion.setAlignment(Element.EMPTY);
		Paragraph introduccionDos = new Paragraph(
				" 3.1 Documentación Evidencia de Pruebas................................................................................5",
				calibriFontItalica);
		introduccionDos.setAlignment(Element.EMPTY);

		document.add(indiceDos);
		document.add(historialVersiones);
		document.add(introduccion);
		document.add(introduccionDos);
	}

	public static void historialdeVersiones(
			
			String historialdeVersionesDescripcionVersion,
			String historialdeVersionesDescripcionFecha,
			String historialdeVersionesDescripcionEstado,
			String historialdeVersionesDescripcionAutor,
			String historialdeVersionesDetalleDescripcion
			
			) throws DocumentException, MalformedURLException, IOException {

		Paragraph indice = new Paragraph("2. Historial de Versiones", calibriFont);
		indice.setAlignment(Element.READONLY);
		document.add(indice);

		document.add(new Phrase("\n\n"));

		Phrase Version = new Phrase("Versión", calibriFontNegrilla);
		Phrase fecha = new Phrase("Fecha", calibriFontNegrilla);
		Phrase estado = new Phrase("Estado", calibriFontNegrilla);
		Phrase autor = new Phrase("Autor:", calibriFontNegrilla);
		Phrase descripcion = new Phrase("Descripción", calibriFontNegrilla);
		Phrase descripcionVersion = new Phrase(historialdeVersionesDescripcionVersion, calibriFontNormal);
		Phrase descripcionFecha = new Phrase(historialdeVersionesDescripcionFecha, calibriFontNormal);
		Phrase descripcionEstado = new Phrase(historialdeVersionesDescripcionEstado, calibriFontNormal);
		Phrase descripcionAutor = new Phrase(historialdeVersionesDescripcionAutor, calibriFontNormal);
		Phrase detalleDescripcion = new Phrase(historialdeVersionesDetalleDescripcion, calibriFontNormal);

		PdfPTable table = new PdfPTable(5);
		PdfPCell cell = new PdfPCell();
		PdfPCell cell2 = new PdfPCell();
		PdfPCell cell3 = new PdfPCell();
		PdfPCell cell4 = new PdfPCell();
		PdfPCell cell5 = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);

		cell.addElement(Version);
		table.addCell(cell);

		cell2.addElement(fecha);
		table.addCell(cell2);

		cell3.addElement(estado);
		table.addCell(cell3);

		cell4.addElement(autor);
		table.addCell(cell4);

		cell5.addElement(descripcion);
		table.addCell(cell5);

		table.addCell(descripcionVersion);
		table.addCell(descripcionFecha);
		table.addCell(descripcionEstado);
		table.addCell(descripcionAutor);		
		table.addCell(detalleDescripcion);

		document.add(table);
	}

	public static void tablaIncial() throws DocumentException, FileNotFoundException {

		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaString = fecha.format(new Date());

		Phrase ambientePrueba = new Phrase("Ambientes de prueba (test, migrados)", calibriFont);
		Phrase sistema = new Phrase("Sistema (CRM, NCA)", calibriFont);
		Phrase fechaPrueba = new Phrase("Fecha de prueba", calibriFont);
		Phrase resultadoPrueba = new Phrase("Resultado de la prueba", calibriFont);
		Phrase incidenciaAsociada = new Phrase("Incidencia(s) asociada(s)", calibriFont);
		Phrase analistaPrueba = new Phrase("Analista de pruebas", calibriFont);
		Phrase casoPrueba = new Phrase("Caso de prueba", calibriFont);
		Phrase pedido = new Phrase("Pedido", calibriFont);
		Phrase oferta = new Phrase("Oferta", calibriFont);

		PdfPTable table = new PdfPTable(2);
		table.addCell(ambientePrueba);
		table.addCell("");
		table.addCell(sistema);
		table.addCell("");
		table.addCell(fechaPrueba);
		table.addCell(fechaString);

		PdfPTable table2 = new PdfPTable(4);
		table2.addCell(resultadoPrueba);
		table2.addCell("");
		table2.addCell(incidenciaAsociada);
		table2.addCell("");

		PdfPTable table3 = new PdfPTable(2);
		table3.addCell(analistaPrueba);
		table3.addCell("");
		table3.addCell(casoPrueba);
		table3.addCell("");

		PdfPTable table4 = new PdfPTable(4);
		table4.addCell(pedido);
		table4.addCell("");
		table4.addCell(oferta);
		table4.addCell("");

		document.add(table);
		document.add(table2);
		document.add(table3);
		document.add(table4);

	}

	public static void imagenSophosInicial() throws MalformedURLException, IOException, DocumentException {

		Image foto = Image.getInstance("src/test/resources/images/Framework/ConfigPDF/Encabezado.png");

		foto.scaleAbsoluteWidth(550f);
		foto.scaleAbsoluteHeight(80f);
		foto.setAlignment(Element.READONLY);

		document.add(foto);

	}

	public static void introduccion(
			
			String introduccionnombreEjecutor,
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
			
			) throws MalformedURLException, IOException, DocumentException {

		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaString = fecha.format(new Date());

		Paragraph introduccion = new Paragraph("3. INTRODUCCIÓN", calibriFont);
		introduccion.setAlignment(Element.READONLY);
		document.add(introduccion);
		document.add(new Phrase("\n"));

		Paragraph intro = new Paragraph(
				"Este documento presenta las evidencias obtenidos durante el proceso de ejecución de las pruebas.",
				calibriFontNormal);
		intro.setAlignment(Element.EMPTY);
		document.add(intro);

		document.add(new Phrase("\n\n\n"));

		Paragraph introduccionDos = new Paragraph(" 3.1 Documentación Evidencia de Pruebas", calibriFont);
		introduccionDos.setAlignment(Element.EMPTY);

		document.add(introduccionDos);
		document.add(new Phrase("\n\n\n"));

		Phrase ejecutadoPorTit = new Phrase("Ejecutado Por:", calibriFontNegrilla);
		Phrase idCasoTit = new Phrase("ID Caso:", calibriFontNegrilla);
		Phrase navegadorTit = new Phrase("Navegador:", calibriFontNegrilla);
		Phrase datosPruebaTit = new Phrase("Datos para la Prueba:", calibriFontNegrilla);
		Phrase fechaPruebaTit = new Phrase("Fecha:", calibriFontNegrilla);
		Phrase nombreCasoTit = new Phrase("Nombre del Caso", calibriFontNegrilla);
		Phrase tipoPruebaTit = new Phrase("Tipo de prueba:", calibriFontNegrilla);
		Phrase resultadoTit = new Phrase("Resultado:", calibriFontNegrilla);
		Phrase incidenteTit = new Phrase("ID Incidente:", calibriFontNegrilla);
		Phrase sistemaTit = new Phrase("Sistema (CRM, OPEN, ETC)", calibriFontNegrilla);
		Phrase ambienteTit = new Phrase("Ambiente de Pruebas:", calibriFontNegrilla);
		Phrase resultadoEsperadoTit = new Phrase("Resultado Esperado", calibriFontNegrilla);
		
		
		Phrase nombreEjecutorDesc = new Phrase(introduccionnombreEjecutor, calibriFontNormal);		
		Phrase numeroCasoDesc = new Phrase(introduccionnumeroCaso, calibriFontNormal);		
		Phrase textoNavegadorDesc = new Phrase(introducciontextoNavegador, calibriFontNormal);		
		Phrase desDatosPruebaDesc = new Phrase(introducciondesDatosPrueba, calibriFontNormal);		
		Phrase descripcionDatosPruebaDesc = new Phrase(introducciondescripcionDatosPrueba, calibriFontNormal);		
		Phrase descripcionTipoPruebaDesc = new Phrase(introducciondescripcionTipoPrueba, calibriFontNormal);		
		Phrase descripcionResultadoDesc = new Phrase(introducciondescripcionResultado, calibriFontNormal);	
		Phrase numeroIncidenteDesc = new Phrase(introduccionnumeroIncidente, calibriFontNormal);	
		Phrase descripcionSistemaDesc = new Phrase(introducciondescripcionSistema, calibriFontNormal);		
		Phrase descripcionAmbienteDesc = new Phrase(introducciondescripcionAmbiente, calibriFontNormal);		
		Phrase descripcionResultadoEsperadoDesc = new Phrase(introducciondescripcionResultadoEsperado, calibriFontNormal);

		PdfPTable table = new PdfPTable(4);
		PdfPTable table2 = new PdfPTable(2);
		PdfPTable table3 = new PdfPTable(4);
		PdfPTable table4 = new PdfPTable(1);
		PdfPTable table5 = new PdfPTable(6);
		PdfPTable table6 = new PdfPTable(2);
		PdfPTable table7 = new PdfPTable(1);

		PdfPCell cell = new PdfPCell();
		PdfPCell cell2 = new PdfPCell();

		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);

		table.addCell(ejecutadoPorTit);
		table.addCell(nombreEjecutorDesc);
		table.addCell(idCasoTit);
		table.addCell(numeroCasoDesc);

		table2.addCell(navegadorTit);
		table2.addCell(textoNavegadorDesc);

		table3.addCell(datosPruebaTit);
		table3.addCell(desDatosPruebaDesc);
		table3.addCell(fechaPruebaTit);
		table3.addCell(fechaString);

		cell.addElement(nombreCasoTit);
		table4.addCell(cell);
		table4.addCell(descripcionDatosPruebaDesc);

		table5.addCell(tipoPruebaTit);
		table5.addCell(descripcionTipoPruebaDesc);
		table5.addCell(resultadoTit);
		table5.addCell(descripcionResultadoDesc);
		table5.addCell(incidenteTit);
		table5.addCell(numeroIncidenteDesc);

		table6.addCell(sistemaTit);
		table6.addCell(descripcionSistemaDesc);
		table6.addCell(ambienteTit);
		table6.addCell(descripcionAmbienteDesc);

		cell2.addElement(resultadoEsperadoTit);
		table7.addCell(cell2);
		table7.addCell(descripcionResultadoEsperadoDesc);

		document.add(table);
		document.add(table2);
		document.add(table3);
		document.add(table4);
		document.add(table5);
		document.add(table6);
		document.add(table7);

	}

}
