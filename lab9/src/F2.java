package flt;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class F2 implements Filter {
    public void init(FilterConfig cfg) throws ServletException {
        System.out.println("F2:init");
    }

    public void destroy() {
        System.out.println("F2:destroy");
    }

    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain ch) throws IOException, ServletException {
        String param1 = rq.getParameter("value1"),
                param2 = rq.getParameter("value2"),
                param3 = rq.getParameter("value3");
        if (param1.equalsIgnoreCase("1") && param2.equalsIgnoreCase("2") && param3.equalsIgnoreCase("3")) {
            System.out.println("F2:doFilter BLOCK");
            rq.getRequestDispatcher("/index.jsp").forward(rq, rs);
        }else{
            System.out.println("F2:doFilter");
            ch.doFilter(rq, rs);
        }

    }

}