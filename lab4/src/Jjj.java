import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Calendar;

public class Jjj extends HttpServlet implements Servlet {

    private Calendar calendar = Calendar.getInstance();
    private int hour = calendar.get(Calendar.HOUR_OF_DAY);

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Jjj:doGet");
        RequestDispatcher rd = null;
        if (hour > 0 && hour <= 5)
            rd = rq.getRequestDispatcher("night.jsp");
        else if (hour > 5 && hour < 12)
            rd = rq.getRequestDispatcher("morning.jsp");
        else if (hour >= 12 && hour <= 17)
            rd = rq.getRequestDispatcher("/Afternoon");
        else
            rd = rq.getRequestDispatcher("evening.jsp");
        rd.forward(rq, rs);
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Jjj:doPost");
        RequestDispatcher rd = null;
        if (hour > 0 && hour <= 5)
            rd = rq.getRequestDispatcher("night.jsp");
        else if (hour > 5 && hour < 12)
            rd = rq.getRequestDispatcher("morning.jsp");
        else if (hour >= 12 && hour <= 17)
            rd = rq.getRequestDispatcher("/Afternoon");
        else
            rd = rq.getRequestDispatcher("evening.jsp");
        rd.forward(rq, rs);
    }

}