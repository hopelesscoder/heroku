package com.example;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
 
/**
 * @author Daniele Pasquini
 *
 */
public class JasperHelper {

	private static final String JASPER_TEMPLATE_DIR = "src/jasper-template/";

	/**
	 * print the Blank_A4 pdf
	 * @return the pdf
	 * @throws JRException
	 * @throws IOException
	 */
	public static byte[] printPdf() throws JRException, IOException {

		// Compile jrxml file.
		JasperReport jasperReport = JasperCompileManager
				.compileReport(JASPER_TEMPLATE_DIR.concat("Blank_A4.jrxml"));

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();

		// DataSource
		// This is simple example, no database.
		// then using empty datasource.
		JRDataSource dataSource = new JREmptyDataSource();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
				parameters, dataSource);

		System.out.println("Done!");

		// Export to PDF.
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}

	/**
	 * print the Blank_A4 pdf with given parameters
	 * @param inputParam the map of input parameters
	 * @return the pdf
	 * @throws JRException
	 * @throws IOException
	 */
	public static byte[] printPdf(Map<String, Object> inputParam) throws JRException, IOException {

		// Compile jrxml file.
		JasperReport jasperReport = JasperCompileManager
				.compileReport(JASPER_TEMPLATE_DIR.concat("Blank_A4.jrxml"));

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();
		if(inputParam != null && !inputParam.isEmpty()) {
			parameters = inputParam; 
		}

		// DataSource
		// This is simple example, no database.
		// then using empty datasource.
		JRDataSource dataSource = new JREmptyDataSource();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
				parameters, dataSource);

		System.out.println("Done!");

		// Export to PDF.
		return JasperExportManager.exportReportToPdf(jasperPrint);  
	}

	
	/**
	 * print the template given in input
	 * @param templateName the name of the jrxml template
	 * @return the pdf
	 * @throws JRException
	 * @throws IOException
	 */
	public static byte[] printPdf(String templateName) throws JRException, IOException {

		// Compile jrxml file.
		JasperReport jasperReport = JasperCompileManager
				.compileReport(JASPER_TEMPLATE_DIR.concat(templateName));

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();

		// DataSource
		// This is simple example, no database.
		// then using empty datasource.
		JRDataSource dataSource = new JREmptyDataSource();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
				parameters, dataSource);

		System.out.println("Done!");

		// Export to PDF.
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}

	/**
	 * print the template given in input with the map of parameters given in input
	 * @param templateName the name of the jrxml template
	 * @param inputParam
	 * @return the map of input parameters
	 * @throws JRException
	 * @throws IOException
	 */
	public static byte[] printPdf(String templateName, Map<String, Object> inputParam) throws JRException, IOException {

		// Compile jrxml file.
		JasperReport jasperReport = JasperCompileManager
				.compileReport(JASPER_TEMPLATE_DIR.concat(templateName));

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();
		if(inputParam != null && !inputParam.isEmpty()) {
			parameters = inputParam; 
		}

		// DataSource
		// This is simple example, no database.
		// then using empty datasource.
		JRDataSource dataSource = new JREmptyDataSource();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
				parameters, dataSource);

		System.out.println("Done!");

		// Export to PDF.
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}
}