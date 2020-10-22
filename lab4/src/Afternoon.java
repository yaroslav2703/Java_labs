import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.PrintWriter;


public class Afternoon extends HttpServlet implements Servlet {

    public void init(ServletConfig sc) throws ServletException {
        super.init();
    }

    public void destroy() {
        super.destroy();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Servlet:Good afternoon");
        PrintWriter pw = rs.getWriter();
        pw.println("<div>"
                +"Servlet:Good afternoon"
                +"</div>");
        pw.close();
    }
}