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
 
public class JasperHelper {
	
	private static final String jasperTemplateDir = "src/jasper-template/";
 
   public static byte[] printPdf() throws JRException, IOException {
 
        // Compile jrxml file.
       JasperReport jasperReport = JasperCompileManager
               .compileReport(jasperTemplateDir.concat("Blank_A4.jrxml"));
 
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
   
   public static byte[] printPdf(Map<String, Object> inputParam) throws JRException, IOException {
	   
       // Compile jrxml file.
      JasperReport jasperReport = JasperCompileManager
              .compileReport(jasperTemplateDir.concat("Blank_A4.jrxml"));

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
   
   public static byte[] printPdf(String templateName) throws JRException, IOException {
	   
       // Compile jrxml file.
      JasperReport jasperReport = JasperCompileManager
              .compileReport(jasperTemplateDir.concat(templateName));

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
   
   public static byte[] printPdf(String templateName, Map<String, Object> inputParam) throws JRException, IOException {
	   
       // Compile jrxml file.
      JasperReport jasperReport = JasperCompileManager
              .compileReport(jasperTemplateDir.concat(templateName));

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