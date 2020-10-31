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
        pw.println("Headers from Servlet Aaa: ");

        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            pw.println(key + ": " + value);
        }

        pw.println();
        pw.println("Params from ServletA:");
        pw.println("Param1: " + req.getParameter("Param1"));
        pw.println("Param2: " + req.getParameter("Param2"));
        pw.println("Param3: " + req.getParameter("Param3"));

        resp.setHeader("Header1", "Header1");
        resp.setHeader("Header2", "Header2");
    }
}