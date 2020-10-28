import javax.servlet.*;
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class Bbb extends HttpServlet implements Servlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        PrintWriter pw = resp.getWriter();
        pw.println("Headers from Servlet Bbb: ");

        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            pw.println(key + ": " + value);
        }

        pw.println();
        pw.println("Query params from ServletB:");
        pw.println("queryParam1: " + req.getParameter("queryParam1"));
        pw.println("queryParam2: " + req.getParameter("queryParam2"));
        pw.println("queryParam3: " + req.getParameter("queryParam3"));

        resp.setHeader("respheader1", "res header 1");
        resp.setHeader("respheader2", "resp header 2");
    }
}