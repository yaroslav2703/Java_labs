import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ppp extends HttpServlet implements Servlet {

    protected void doPost(HttpServletRequest rq, HttpServletResponse
            rs)
            throws ServletException, IOException {
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>Ppp:doPost:firstname=" + firstname
                + "<br>Ppp:doPost:lastname= " + lastname
                + "</body>" + "</html>");
        pw.close();
    }

}