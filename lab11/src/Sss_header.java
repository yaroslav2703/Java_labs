import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.*;


public class Sss_header extends HttpServlet implements Servlet {
    public Sss_header() {
        super();
    }
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss:doGet");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss:doPost");
        try {
        	Thread.currentThread().sleep(10000);  // 10 sec
         } catch (Exception e) {
         System.out.println(e);
         }

        System.out.println(rq.getHeader("Value-X"));
        System.out.println(rq.getHeader("Value-Y"));
        Float x = new Float(rq.getHeader("Value-X"));
        Float y = new Float(rq.getHeader("Value-Y"));
        Float z = x + y;
        System.out.println(z.toString());
        rs.setHeader("Value-Z", z.toString());
    }
}
