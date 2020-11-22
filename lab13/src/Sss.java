import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns = "/sss")
public class Sss extends HttpServlet implements Servlet {
    public Sss() {
        super();
    }
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String filename = rq.getParameter("file");
		String docdir = getServletContext().getInitParameter("doc-dir");

         try {
            File doc = new File(docdir.concat("\\").concat(filename));
            rs.setContentType("application/msword");
            rs.addHeader("Content-Disposition", "attachment; filename="+ doc.getName());
            rs.setContentLength((int) doc.length());

            System.out.println("Download, Servlet:SSS, file name: " + filename);
            FileInputStream in = new FileInputStream(doc);
            BufferedInputStream buf = new BufferedInputStream(in);
            ServletOutputStream out = rs.getOutputStream();
            int readBytes = 0;
            while ((readBytes = buf.read()) != -1) {
                out.write(readBytes);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Servlet:SSS");
    }

	
}