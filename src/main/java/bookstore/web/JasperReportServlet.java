package bookstore.web;

import config.Database;
import config.JasperReportConfig;
import net.sf.jasperreports.engine.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@WebServlet("/jasper_report")
public class JasperReportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JasperPrint jasperPrint = null;
        try {
            String reportFileName = "Blank_A4";
            String reportPath = "/resources" + reportFileName;
            String targetFileName = reportFileName.replace(".jrxml", ".pdf");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, Database.getConnection());
            ServletOutputStream outputstream = resp.getOutputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);
            resp.setContentType("application/pdf");
            outputstream.write(byteArrayOutputStream.toByteArray());
            resp.setHeader("Cache-Control", "max-age=0");
            resp.setHeader("Content-Disposition", "attachment; filename=" + targetFileName);
            outputstream.flush();
            outputstream.close();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
