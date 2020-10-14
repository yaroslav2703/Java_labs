import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.PrintWriter;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class Sss extends HttpServlet implements Servlet {

    public void init(ServletConfig sc) throws ServletException {
        super.init();
    }

    public void destroy() {
        super.destroy();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {

        String task = rq.getParameter("task");


        if (rq.getMethod().equalsIgnoreCase("POST")){
            if (task.equalsIgnoreCase("2")) {
                System.out.println("Sss:POST in service");
                        RequestDispatcher rd = null;
                rd = rq.getRequestDispatcher("/Ggg");
                rd.forward(rq, rs);
            }
        }
        else if (rq.getMethod().equalsIgnoreCase("GET")) {
            if (task.equalsIgnoreCase("1")) {
                String firstname = rq.getParameter("firstname");
                String lastname = rq.getParameter("lastname");
                System.out.println("Sss:doGet:firstname=" + firstname);
                System.out.println("Sss:doGet:lastname=" + lastname);
                RequestDispatcher rd = null;
                String parmstr = "firstname=" + firstname + "&"
                        + "lastname=" + lastname;
                rd = rq.getRequestDispatcher("/Ggg?"+parmstr);
                rd.forward(rq, rs);
            }
            else if (task.equalsIgnoreCase("3")) {
                System.out.println("index->Sss->redirect");
                RequestDispatcher rd = null;
                rd = rq.getRequestDispatcher("/redirect.html");
                rd.forward(rq, rs);
            }
            else if (task.equalsIgnoreCase("4")) {
                System.out.println("Sss:doGet:task4");
                RequestDispatcher rd = null;
                rd = rq.getRequestDispatcher("/Ggg?task=4");
                rd.forward(rq, rs);
            }
            else if (task.equalsIgnoreCase("5")) {
                System.out.println("Sss:doGet:task5");
                PrintWriter pw = rs.getWriter();
                pw.println("<html><body>"
                        +"Sss, task5"
                        +"</body></html>");
                pw.close();
                RequestDispatcher rd = null;
                rd = rq.getRequestDispatcher("/Ggg?task=5");
                rd.forward(rq, rs);
            }
            else if (task.equalsIgnoreCase("6")){
                System.out.println("Sss:doGet:task6");
                rs.sendRedirect("Ggg?task=6");
            }
            else if (task.equalsIgnoreCase("7")){
                System.out.println("Sss:doGet:task7");
                HttpClient hc = new HttpClient();
                GetMethod gm = new GetMethod("http://localhost:80/lab3/Ggg?task=7&firstname=Yaroslav&lastname=Pitsukha");

                hc.executeMethod(gm);
                PrintWriter pw = rs.getWriter();
                pw.println(gm.getResponseBodyAsString());
                pw.flush();
            }
        }


    }
}