import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ggg extends HttpServlet implements Servlet {

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String task = rq.getParameter("task");
        if (task.equalsIgnoreCase("4")) {
            System.out.println("Ggg:doGet:task4");
            System.out.println("index->Sss->redirect");
            RequestDispatcher rd = null;
            rd = rq.getRequestDispatcher("/redirect.html");
            rd.forward(rq, rs);
        }
        else if (task.equalsIgnoreCase("5")) {
            System.out.println("Ggg:doGet:task5");
            PrintWriter pw = rs.getWriter();
            pw.println("<html><body>"
                    +"Ggg, task5"
                    +"</body></html>");
            pw.close();
        }
        else if (task.equalsIgnoreCase("6")){
            System.out.println("Ggg:doGet:task6");
            PrintWriter pw = rs.getWriter();
            pw.println("<html><body>"
                    +"Ggg, task6"
                    +"</body></html>");
            pw.close();
        }
        else if (task.equalsIgnoreCase("7")){
            System.out.println("Ggg:doGet:task7");
            String parm1 = rq.getParameter("firstname");
            String parm2 = rq.getParameter("lastname");
            PrintWriter pw = rs.getWriter();
            pw.println("firstname: " + parm1 + ", lastname: " + parm2);
        }
        else {
            String parm1 = rq.getParameter("firstname");
            String parm2 = rq.getParameter("lastname");
            System.out.println("Ggg:doGet:firstname=" + parm1);
            System.out.println("Ggg:doGet:lastname=" + parm2);
            rs.setContentType("text/html");
            PrintWriter pw = rs.getWriter();
            pw.println("<html><body>"
                    +"Hello from Servlet"
                    +"<br>Ggg:doGet: firstname=" + parm1
                    +"<br>Ggg:doGet: lastname=" + parm2
                    +"</body></html>");
            pw.close();
        }
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Ggg:doPost");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body>"
                +"Hello from Ggg"
                +"<br>index->Sss->Ggg (POST)"
                +"</body></html>");
        pw.close();
    }

}