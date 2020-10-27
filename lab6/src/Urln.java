import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.PrintWriter;


public class Urln extends HttpServlet implements Servlet {

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {

        rs.setContentType("text/html");
        String param = rq.getParameter("urln");

        PrintWriter printWriter = rs.getWriter();

        if (param.equals("1")) {
            rs.sendRedirect(getServletContext().getInitParameter("URL1"));
        } else if (param.equals("2")) {
            rs.sendRedirect(getServletContext().getInitParameter("URL2"));
        } else {
            printWriter.println("parameter URLn not found");
        }
    }
}