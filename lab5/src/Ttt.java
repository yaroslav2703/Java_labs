import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.PrintWriter;


public class Ttt extends HttpServlet implements Servlet {

    public void init(ServletConfig sc) throws ServletException {
        super.init();
    }

    public void destroy() {
        super.destroy();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String surname = rq.getParameter("surname");
        String lastname = rq.getParameter("lastname");
        String sex = rq.getParameter("sex");

        PrintWriter printWriter = rs.getWriter();
        printWriter.println(
                "<br/>Firstname: " + surname +
                        "<br/>Lastname: " + lastname +
                        "<br/>Sex: " + sex
        );
    }
}