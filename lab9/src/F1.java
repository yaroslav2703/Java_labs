package flt;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class F1 implements Filter {
    public void init(FilterConfig cfg) throws ServletException {
        System.out.println("F1:init");
    }

    public void destroy() {
        System.out.println("F1:destroy");
    }

    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain ch) throws IOException, ServletException {
        System.out.println("F1:doFilter");
        ch.doFilter(rq, rs);
    }

}