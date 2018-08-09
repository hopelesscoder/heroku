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
 
   public static void main(String[] args) throws JRException, IOException {
 
        // Compile jrxml file.
       JasperReport jasperReport = JasperCompileManager
               .compileReport("C:/jasperreport/StyledTextReport/StyledTextReport.jrxml");
 
       // Parameters for report
       Map<String, Object> parameters = new HashMap<String, Object>();

 
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
               parameters);
 
    
 
       // Export to PDF.
       JasperExportManager.exportReportToPdf(jasperPrint);
        
       System.out.println("Done!");
   }
}