import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.*;

public class Sss_JSON extends HttpServlet implements Servlet {
	static final long serialVersionUID = 1L;
   	public Sss_JSON() {
		super();
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("Sss_JSON:doPost");
		try {
            Thread.currentThread().sleep(1000);  // 1 sec
         } catch (Exception e) {
             System.out.println(e);
         }
        Integer n = new Integer(rq.getHeader("XRand-N"));
        System.out.println(n);
        XXRand num = new XXRand(n);
        rs.setContentType("text/xml");
        PrintWriter w = rs.getWriter();
        String s ="{\"X\":[" ;
        for (int i = 0; i < 10; i++)
        {
            s += ("{\"rand\":"+ num.Get().toString()+"}"+
                        ((i < 9)?",":" "));
        }
        s+="]}";
        System.out.println(s);
        w.println(s);
	}
}
