package config;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.log4j.Logger;


import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class JasperReportConfig extends JFrame {



    public void generateAddressReports(Map<String, Object> reportParameters, OutputStream out) throws JRException {


        // generatePdfReport(Map<String, Object> reportParameters, OutputStream out, "accounts");
        InputStream reportIs = getReportFile("accounts");
        JasperPrint print = fillReport(reportParameters, reportIs);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();


        exportToPdf(print, baos);


        try {
            out.write(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void exportToPdf(JasperPrint print, ByteArrayOutputStream baos) throws JRException {
        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setExporterInput(new SimpleExporterInput(print));
        pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
        pdfExporter.exportReport();
    }

    private InputStream getReportFile(String name) {
        return this.getClass().getResourceAsStream("/" + name + ".jasper");
    }

    private JasperPrint fillReport(Map<String, Object> reportParameters, InputStream reportIs) throws JRException {

        Connection connHandle;
        connHandle = Database.getConnection();
        JasperReport report = (JasperReport) JRLoader.loadObject(reportIs);
        JasperPrint print = JasperFillManager.fillReport(report, reportParameters, connHandle);
        Database.close(connHandle);
        return print;


    }
}
