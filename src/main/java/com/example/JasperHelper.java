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
 
   public static byte[] printPdf() throws JRException, IOException {
 
        // Compile jrxml file.
       JasperReport jasperReport = JasperCompileManager
               .compileReport("/Blank_A4.jrxml");
 
       // Parameters for report
       Map<String, Object> parameters = new HashMap<String, Object>();

 
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
               parameters);
 
		System.out.println("Done!");
 
       // Export to PDF.
       return JasperExportManager.exportReportToPdf(jasperPrint);
        
       
   }
}