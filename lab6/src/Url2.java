import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.PrintWriter;


public class Url2 extends HttpServlet implements Servlet {

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {

        rs.getWriter().println("URL2  servlet");
    }
}