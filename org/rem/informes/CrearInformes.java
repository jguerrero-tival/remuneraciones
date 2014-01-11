package org.rem.informes;

import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.rem.dao.hibernate.HibernateUtil;

public class CrearInformes {

	@SuppressWarnings("unchecked")
	public static void crearLibroRemuneracion(String cabecera) {
		System.out.println("ENTRO A CREAR LIBRO DE REMUNERACIONES");

		String fileNameA = "Libro2A.jrxml";
		String fileNameB = "Libro2B.jrxml";
		String outFileName = "Libro - " + cabecera + ".pdf";
		String fileNameDataA = "LibroDataA.jrxml";
		String fileNameDataB = "LibroDataB.jrxml";

		HashMap hm = new HashMap();

		System.out.println("BEGIN TRANSACTION");
		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				System.out.println("ANTES DE COMPILAR");
				JasperCompileManager.compileReportToFile(fileNameDataA);
				JasperCompileManager.compileReportToFile(fileNameDataB);
				JasperReport jasperReportA = JasperCompileManager.compileReport(fileNameA);
				JasperReport jasperReportB = JasperCompileManager.compileReport(fileNameB);
				System.out.println("DESPUES DE COMPILAR");
				
				System.out.println("ANTES DE CREAR LA IMPRESION");
				// crea la impresion
				JasperPrint printA = (JasperPrint) JasperFillManager.fillReport(
						jasperReportA, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printB = (JasperPrint) JasperFillManager.fillReport(
						jasperReportB, hm, HibernateUtil.currentSession()
								.connection());
				System.out.println("DESPUES DE CREAR LA IMPRESION");
				
				// concatena informes A y B
				List jasperPrintList = printB.getPages();
				for ( int i=0; i< jasperPrintList.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList.get(i));
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, printA);
				exporter.exportReport();

				
				new ViewerReport(printA);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLibroRemuneracionColegio(String cabecera) {
		System.out.println("ENTRO A CREAR LIBRO DE REMUNERACIONES COLEGIO");

		String fileNameA = "LibroColegio2A.jrxml";
		String fileNameB = "LibroColegio2B.jrxml";
		String fileNameC = "LibroColegio2C.jrxml";
		String outFileName = "Libro - " + cabecera + ".pdf";
		String fileNameDataA = "LibroDataColegioA.jrxml";
		String fileNameDataB = "LibroDataColegioB.jrxml";
		String fileNameDataC = "LibroDataColegioC.jrxml";
		
		HashMap hm = new HashMap();

		System.out.println("BEGIN TRANSACTION");
		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				System.out.println("ANTES DE COMPILAR");
				JasperCompileManager.compileReportToFile(fileNameDataA);
				JasperCompileManager.compileReportToFile(fileNameDataB);
				JasperCompileManager.compileReportToFile(fileNameDataC);
				JasperReport jasperReportA = JasperCompileManager.compileReport(fileNameA);
				JasperReport jasperReportB = JasperCompileManager.compileReport(fileNameB);
				JasperReport jasperReportC = JasperCompileManager.compileReport(fileNameC);
				System.out.println("DESPUES DE COMPILAR");
				
				System.out.println("ANTES DE CREAR LA IMPRESION");
				// crea la impresion
				JasperPrint printA = (JasperPrint) JasperFillManager.fillReport(
						jasperReportA, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printB = (JasperPrint) JasperFillManager.fillReport(
						jasperReportB, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printC = (JasperPrint) JasperFillManager.fillReport(
						jasperReportC, hm, HibernateUtil.currentSession()
								.connection());
				System.out.println("DESPUES DE CREAR LA IMPRESION");
				
				// concatena informes A y B
				List jasperPrintList = printB.getPages();
				for ( int i=0; i< jasperPrintList.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList.get(i));
				}

				List jasperPrintList2 = printC.getPages();
				for ( int i=0; i< jasperPrintList2.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList2.get(i));
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, printA);
				exporter.exportReport();

				
				new ViewerReport(printA);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public static void crearLibroRemuneracionFolio(String cabecera) {
		String fileNameA = "Libro2FolioA.jrxml";
		String fileNameB = "Libro2FolioB.jrxml";
		String outFileName = "Folio - Libro - " + cabecera + ".pdf";
		String fileNameDataA = "LibroDataA.jrxml";
		String fileNameDataB = "LibroDataB.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDataA);
				JasperCompileManager.compileReportToFile(fileNameDataB);
				JasperReport jasperReportA = JasperCompileManager
						.compileReport(fileNameA);
				JasperReport jasperReportB = JasperCompileManager
						.compileReport(fileNameB);

				// crea la impresion
				JasperPrint printA = (JasperPrint) JasperFillManager.fillReport(
						jasperReportA, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printB = (JasperPrint) JasperFillManager.fillReport(
						jasperReportB, hm, HibernateUtil.currentSession()
								.connection());
				
				// concatena informes A y B
				List jasperPrintList = printB.getPages();
				for ( int i=0; i< jasperPrintList.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList.get(i));
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, printA);
				exporter.exportReport();

				new ViewerReport(printA);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLibroRemuneracionColegioFolio(String cabecera) {
		String fileNameA = "LibroColegio2FolioA.jrxml";
		String fileNameB = "LibroColegio2FolioB.jrxml";
		String fileNameC = "LibroColegio2FolioC.jrxml";
		String outFileName = "Folio - Libro - " + cabecera + ".pdf";
		String fileNameDataA = "LibroDataColegioA.jrxml";
		String fileNameDataB = "LibroDataColegioB.jrxml";
		String fileNameDataC = "LibroDataColegioC.jrxml";
		
		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDataA);
				JasperCompileManager.compileReportToFile(fileNameDataB);
				JasperCompileManager.compileReportToFile(fileNameDataC);
				JasperReport jasperReportA = JasperCompileManager
						.compileReport(fileNameA);
				JasperReport jasperReportB = JasperCompileManager
						.compileReport(fileNameB);
				JasperReport jasperReportC = JasperCompileManager
						.compileReport(fileNameC);

				// crea la impresion
				JasperPrint printA = (JasperPrint) JasperFillManager.fillReport(
						jasperReportA, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printB = (JasperPrint) JasperFillManager.fillReport(
						jasperReportB, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printC = (JasperPrint) JasperFillManager.fillReport(
						jasperReportC, hm, HibernateUtil.currentSession()
								.connection());
				
				// concatena informes A y B
				List jasperPrintList = printB.getPages();
				for ( int i=0; i< jasperPrintList.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList.get(i));
				}
				
				List jasperPrintList2 = printC.getPages();
				for ( int i=0; i< jasperPrintList2.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList2.get(i));
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, printA);
				exporter.exportReport();

				new ViewerReport(printA);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLibroRemuneracionCC(String cabecera, Long cc, String nombreCC) {
		System.out.println("ENTRO A CREAR LIBRO DE REMUNERACIONES POR CC");

		String fileNameA = "LibroCCA.jrxml";
		String fileNameB = "LibroCCB.jrxml";
		String outFileName = "Libro - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDataA = "LibroDataACC.jrxml";
		String fileNameDataB = "LibroDataBCC.jrxml";
		String fileNameDataAJasper = "LibroDataACC.jasper";
		String fileNameDataBJasper = "LibroDataBCC.jasper";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);
				
				System.out.println("ANTES DE COMPILAR REPORTES");
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDataA, fileNameDataAJasper);
				JasperCompileManager.compileReportToFile(fileNameDataB, fileNameDataBJasper);
				JasperReport jasperReportA = JasperCompileManager.compileReport(fileNameA);
				JasperReport jasperReportB = JasperCompileManager.compileReport(fileNameB);
				
				//JasperReport jasperReport = JasperCompileManager.compileReport(fileNameDataA);
				
				System.out.println("DESPUES DE COMPILAR REPORTES");

				System.out.println("ANTES DE CREAR LA IMPRESION");
				// crea la impresion
				JasperPrint printA = (JasperPrint) JasperFillManager.fillReport(
						jasperReportA, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printB = (JasperPrint) JasperFillManager.fillReport(
						jasperReportB, hm, HibernateUtil.currentSession()
								.connection());
				System.out.println("DESPUES DE CREAR LA IMPRESION");

				List jasperPrintList = printB.getPages();
				for ( int i=0; i< jasperPrintList.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList.get(i));
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, printA);
				exporter.exportReport();

				new ViewerReport(printA);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLibroRemuneracionColegioCC(String cabecera, Long cc, String nombreCC) {
		System.out.println("ENTRO A CREAR LIBRO DE REMUNERACIONES COLEGIO POR CC");

		String fileNameA = "LibroColegioCCA.jrxml";
		String fileNameB = "LibroColegioCCB.jrxml";
		String fileNameC = "LibroColegioCCC.jrxml";
		String outFileName = "Libro - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDataA = "LibroColegioDataACC.jrxml";
		String fileNameDataB = "LibroColegioDataBCC.jrxml";
		String fileNameDataC = "LibroColegioDataCCC.jrxml";
		String fileNameDataAJasper = "LibroColegioDataACC.jasper";
		String fileNameDataBJasper = "LibroColegioDataBCC.jasper";
		String fileNameDataCJasper = "LibroColegioDataCCC.jasper";
		
		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);
				
				System.out.println("ANTES DE COMPILAR REPORTES");
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDataA, fileNameDataAJasper);
				JasperCompileManager.compileReportToFile(fileNameDataB, fileNameDataBJasper);
				JasperCompileManager.compileReportToFile(fileNameDataC, fileNameDataCJasper);
				JasperReport jasperReportA = JasperCompileManager.compileReport(fileNameA);
				JasperReport jasperReportB = JasperCompileManager.compileReport(fileNameB);
				JasperReport jasperReportC = JasperCompileManager.compileReport(fileNameC);
				
				//JasperReport jasperReport = JasperCompileManager.compileReport(fileNameDataA);
				
				System.out.println("DESPUES DE COMPILAR REPORTES");

				System.out.println("ANTES DE CREAR LA IMPRESION");
				// crea la impresion
				JasperPrint printA = (JasperPrint) JasperFillManager.fillReport(
						jasperReportA, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printB = (JasperPrint) JasperFillManager.fillReport(
						jasperReportB, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printC = (JasperPrint) JasperFillManager.fillReport(
						jasperReportC, hm, HibernateUtil.currentSession()
								.connection());
				System.out.println("DESPUES DE CREAR LA IMPRESION");

				List jasperPrintList = printB.getPages();
				for ( int i=0; i< jasperPrintList.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList.get(i));
				}
				
				List jasperPrintList2 = printC.getPages();
				for ( int i=0; i< jasperPrintList2.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList2.get(i));
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, printA);
				exporter.exportReport();

				new ViewerReport(printA);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLibroRemuneracionCCFolio(String cabecera, Long cc, String nombreCC) {

		String fileNameA = "LibroFolioCCA.jrxml";
		String fileNameB = "LibroFolioCCB.jrxml";
		String outFileName = "Folio - Libro - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDataA = "LibroDataACC.jrxml";
		String fileNameDataB = "LibroDataBCC.jrxml";
		
		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);

				//ACA VOY, creo que no debería realizar modificaciones hacia abajo
				
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDataA);
				JasperCompileManager.compileReportToFile(fileNameDataB);
				JasperReport jasperReportA = JasperCompileManager
						.compileReport(fileNameA);
				JasperReport jasperReportB = JasperCompileManager
						.compileReport(fileNameB);

				// crea la impresion
				JasperPrint printA = (JasperPrint) JasperFillManager.fillReport(
						jasperReportA, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printB = (JasperPrint) JasperFillManager.fillReport(
						jasperReportB, hm, HibernateUtil.currentSession()
								.connection());
				
				// concatena informes A y B
				List jasperPrintList = printB.getPages();
				for ( int i=0; i< jasperPrintList.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList.get(i));
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, printA);
				exporter.exportReport();

				new ViewerReport(printA);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLibroRemuneracionColegioCCFolio(String cabecera, Long cc, String nombreCC) {

		String fileNameA = "LibroColegioFolioCCA.jrxml";
		String fileNameB = "LibroColegioFolioCCB.jrxml";
		String fileNameC = "LibroColegioFolioCCC.jrxml";
		String outFileName = "Folio - Libro - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDataA = "LibroColegioDataACC.jrxml";
		String fileNameDataB = "LibroColegioDataBCC.jrxml";
		String fileNameDataC = "LibroColegioDataCCC.jrxml";
		
		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);

				//ACA VOY, creo que no debería realizar modificaciones hacia abajo
				
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDataA);
				JasperCompileManager.compileReportToFile(fileNameDataB);
				JasperCompileManager.compileReportToFile(fileNameDataC);
				JasperReport jasperReportA = JasperCompileManager
						.compileReport(fileNameA);
				JasperReport jasperReportB = JasperCompileManager
						.compileReport(fileNameB);
				JasperReport jasperReportC = JasperCompileManager
						.compileReport(fileNameC);
				
				// crea la impresion
				JasperPrint printA = (JasperPrint) JasperFillManager.fillReport(
						jasperReportA, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printB = (JasperPrint) JasperFillManager.fillReport(
						jasperReportB, hm, HibernateUtil.currentSession()
								.connection());
				JasperPrint printC = (JasperPrint) JasperFillManager.fillReport(
						jasperReportC, hm, HibernateUtil.currentSession()
								.connection());
				
				// concatena informes A y B
				List jasperPrintList = printB.getPages();
				for ( int i=0; i< jasperPrintList.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList.get(i));
				}
				List jasperPrintList2 = printC.getPages();
				for ( int i=0; i< jasperPrintList2.size(); i++) {
					printA.addPage((JRPrintPage)jasperPrintList2.get(i));
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, printA);
				exporter.exportReport();

				new ViewerReport(printA);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLiquidacionSueldo(String cabecera) {

		String fileName = "Liquidacion2.jrxml";
		String outFileName = "Liquidacion - " + cabecera + ".pdf";
		String fileNamePersona = "LiquidacionPersona2.jrxml";
		String fileNameImponible = "LiquidacionImponible2.jrxml";
		String fileNameNoImponible = "LiquidacionNoImponible2.jrxml";
		String fileNameDescuentoLegal = "LiquidacionDescuentoLegal2.jrxml";
		String fileNameDescuentoVario = "LiquidacionDescuentoVario2.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNamePersona);
				JasperCompileManager.compileReportToFile(fileNameImponible);
				JasperCompileManager.compileReportToFile(fileNameNoImponible);
				JasperCompileManager
						.compileReportToFile(fileNameDescuentoLegal);
				JasperCompileManager
						.compileReportToFile(fileNameDescuentoVario);
				JasperReport jasperReport = JasperCompileManager
						.compileReport(fileName);

				// crea la impresion
				JasperPrint print = (JasperPrint) JasperFillManager.fillReport(
						jasperReport, hm, HibernateUtil.currentSession()
								.connection());
				
				// quitar paginas que sobran
				int paginas = print.getPages().size();
				if (paginas>=2) {
					print.removePage(paginas-1);
					print.removePage(paginas-2);
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLiquidacionSueldoFolio(String cabecera) {

		String fileName = "Liquidacion2Folio.jrxml";
		String outFileName = "Folio - Liquidacion - " + cabecera + ".pdf";
		String fileNamePersona = "LiquidacionPersona2.jrxml";
		String fileNameImponible = "LiquidacionImponible2.jrxml";
		String fileNameNoImponible = "LiquidacionNoImponible2.jrxml";
		String fileNameDescuentoLegal = "LiquidacionDescuentoLegal2.jrxml";
		String fileNameDescuentoVario = "LiquidacionDescuentoVario2.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNamePersona);
				JasperCompileManager.compileReportToFile(fileNameImponible);
				JasperCompileManager.compileReportToFile(fileNameNoImponible);
				JasperCompileManager
						.compileReportToFile(fileNameDescuentoLegal);
				JasperCompileManager
						.compileReportToFile(fileNameDescuentoVario);
				JasperReport jasperReport = JasperCompileManager
						.compileReport(fileName);

				// crea la impresion
				JasperPrint print = (JasperPrint) JasperFillManager.fillReport(
						jasperReport, hm, HibernateUtil.currentSession()
								.connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearLiquidacionSueldoCC(String cabecera, Long cc, String nombreCC) {

		String fileName = "Liquidacion2CC.jrxml";
		String outFileName = "Liquidacion - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNamePersona = "LiquidacionPersona2CC.jrxml";
		String fileNameImponible = "LiquidacionImponible2CC.jrxml";
		String fileNameNoImponible = "LiquidacionNoImponible2CC.jrxml";
		String fileNameDescuentoLegal = "LiquidacionDescuentoLegal2CC.jrxml";
		String fileNameDescuentoVario = "LiquidacionDescuentoVario2CC.jrxml";
		String fileNamePersonaJasper = "LiquidacionPersona2CC.jasper";
		String fileNameImponibleJasper = "LiquidacionImponible2CC.jasper";
		String fileNameNoImponibleJasper = "LiquidacionNoImponible2CC.jasper";
		String fileNameDescuentoLegalJasper = "LiquidacionDescuentoLegal2CC.jasper";
		String fileNameDescuentoVarioJasper = "LiquidacionDescuentoVario2CC.jasper";
		
		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);
				
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNamePersona, fileNamePersonaJasper);
				JasperCompileManager.compileReportToFile(fileNameImponible, fileNameImponibleJasper);
				JasperCompileManager.compileReportToFile(fileNameNoImponible, fileNameNoImponibleJasper);
				JasperCompileManager.compileReportToFile(fileNameDescuentoLegal, fileNameDescuentoLegalJasper);
				JasperCompileManager.compileReportToFile(fileNameDescuentoVario, fileNameDescuentoVarioJasper);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = (JasperPrint) JasperFillManager.fillReport(
						jasperReport, hm, HibernateUtil.currentSession()
								.connection());

				// quitar paginas que sobran
				int paginas = print.getPages().size();
				if (paginas>=2) {
					print.removePage(paginas-1);
					print.removePage(paginas-2);
				}
				
				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearInp(String cabecera) {

		String fileName = "Inp.jrxml";
		String outFileName = "INP - " + cabecera + ".pdf";
		String fileNameDetail= "InpDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
		
	@SuppressWarnings("unchecked")
	public static void crearInpFolio(String cabecera) {

		String fileName = "InpFolio.jrxml";
		String outFileName = "Folio - INP - " + cabecera + ".pdf";
		String fileNameDetail= "InpDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearInpCC(String cabecera, Long cc, String nombreCC) {

		String fileName = "InpCC.jrxml";
		String outFileName = "INP - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDetail= "InpDetailCC.jrxml";
		String fileNameDetailJasper= "InpDetailCC.jasper";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail, fileNameDetailJasper);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearCaja(String cabecera) {

		String fileName = "Caja.jrxml";
		String outFileName = "Caja - " + cabecera + ".pdf";
		String fileNameDetail= "CajaDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearCajaFolio(String cabecera) {

		String fileName = "CajaFolio.jrxml";
		String outFileName = "Folio - Caja - " + cabecera + ".pdf";
		String fileNameDetail= "CajaDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearCajaCC(String cabecera, Long cc, String nombreCC) {

		String fileName = "CajaCC.jrxml";
		String outFileName = "Caja - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDetail= "CajaDetailCC.jrxml";
		String fileNameDetailJasper= "CajaDetailCC.jasper";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);
				
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail, fileNameDetailJasper);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearMutual(String cabecera) {

		String fileName = "Mutual.jrxml";
		String outFileName = "Mutual - " + cabecera + ".pdf";
		String fileNameDetail= "MutualDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearMutualFolio(String cabecera) {

		String fileName = "MutualFolio.jrxml";
		String outFileName = "Folio - Mutual - " + cabecera + ".pdf";
		String fileNameDetail= "MutualDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());

				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearMutualCC(String cabecera, Long cc, String nombreCC) {

		String fileName = "MutualCC.jrxml";
		String outFileName = "Mutual - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDetail= "MutualDetailCC.jrxml";
		String fileNameDetailJasper= "MutualDetailCC.jasper";
		
		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);
				
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail, fileNameDetailJasper);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearIsapre(String cabecera, String nombreIsapre) {

		String fileName = "Isapre.jrxml";
		String outFileName = "Isapre - " + nombreIsapre + " - " + cabecera + ".pdf";
		String fileNameDetail= "IsapreDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("ISAPRE", nombreIsapre);
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearIsapreFolio(String cabecera, String nombreIsapre) {

		String fileName = "IsapreFolio.jrxml";
		String outFileName = "Folio - Isapre - " + nombreIsapre + " - " + cabecera + ".pdf";
		String fileNameDetail= "IsapreDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("ISAPRE", nombreIsapre);
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public static void crearIsapreCC(String cabecera, String nombreIsapre, Long cc, String nombreCC) {

		String fileName = "IsapreCC.jrxml";
		String outFileName = "Isapre - " + nombreIsapre + " - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDetail= "IsapreDetailCC.jrxml";
		String fileNameDetailJasper= "IsapreDetailCC.jasper";

		
		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("ISAPRE", nombreIsapre);
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);
				
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail, fileNameDetailJasper);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearAfp(String cabecera, String nombreAfp) {

		String fileName = "Afp.jrxml";
		String outFileName = "Afp - " + nombreAfp + " - " + cabecera + ".pdf";
		String fileNameDetail= "AfpDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("AFP", nombreAfp);
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);
				
			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearAfpFolio(String cabecera, String nombreAfp) {

		String fileName = "AfpFolio.jrxml";
		String outFileName = "Folio - Afp - " + nombreAfp + " - " + cabecera + ".pdf";
		String fileNameDetail= "AfpDetail.jrxml";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("AFP", nombreAfp);
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);
				
			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void crearAfpCC(String cabecera, String nombreAfp, Long cc, String nombreCC) {

		String fileName = "AfpCC.jrxml";
		String outFileName = "Afp - " + nombreAfp + " - " + cabecera + " - CC_" + cc + ".pdf";
		String fileNameDetail= "AfpDetailCC.jrxml";
		String fileNameDetailJasper= "AfpDetailCC.jasper";

		HashMap hm = new HashMap();

		HibernateUtil.beginTransaction();
		try {
			try {
				// agrega la session de hibernet a las variables mapeadas
				hm.put("HIBERNATE_SESSION", HibernateUtil.currentSession());
				hm.put("AFP", nombreAfp);
				hm.put("CC", cc);
				hm.put("CC_NAME", nombreCC);
				
				// compila reportes y subreportes
				JasperCompileManager.compileReportToFile(fileNameDetail, fileNameDetailJasper);
				JasperReport jasperReport = JasperCompileManager.compileReport(fileName);

				// crea la impresion
				JasperPrint print = 
					(JasperPrint) JasperFillManager.fillReport(
							jasperReport, hm, HibernateUtil.currentSession().connection());

				// exporta la impresion a PDF
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

				// ver
				new ViewerReport(print);
				
			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}
