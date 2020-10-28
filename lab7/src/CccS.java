import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.*;
import pac.CBean;


public class CccS extends HttpServlet implements Servlet {

    public CBean cBean = null;

    @Override
    public void init() throws ServletException {
        cBean = new CBean();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("CBean").equals("new")) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("atrCBean", cBean);
            System.out.println("new: " + req.getAttribute("atrCBean"));

            String param1 = req.getParameter("value1"),
                    param2 = req.getParameter("value2"),
                    param3 = req.getParameter("value3");


            if (param1 != null && param2 != null && param3 != null) {
                cBean.setValue1(param1);
                cBean.setValue2(param2);
                cBean.setValue3(param3);

                req.getRequestDispatcher("/CccS.jsp").forward(req, resp);
            }
        }
        else if (req.getParameter("CBean").equals("old")){
            HttpSession httpSession = req.getSession();
            System.out.println("old: " + httpSession.getAttribute("atrCBean"));
            req.getRequestDispatcher("/CccS.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}