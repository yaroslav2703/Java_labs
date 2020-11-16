import java.io.IOException; // исключения ввода/вывода
import javax.servlet.*; // интерфейсы и классы общего типа
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.*;

public class Sss_XML extends HttpServlet implements Servlet {
	static final long serialVersionUID = 1L;
   	public Sss_XML() {
		super();
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException {
		System.out.println("Sss_Rand:doPost");
		try {
            Thread.currentThread().sleep(5000);  // 5 sec
         } catch (Exception e) {
             System.out.println(e);
         }
		Integer n = new Integer(rq.getHeader("XRand-N"));
		System.out.println(n);
		XXRand num = new XXRand(n);
		rs.setContentType("text/xml");
		PrintWriter w = rs.getWriter();
		String s =
                 "<?xml version=\"1.0\"  encoding = \"utf-8\" ?><rand>" ;
		for (int i = 0; i < 10; i++)
		{
			s += "<num>"+num.Get().toString()+"</num>";
		}
		s += "</rand>";
		w.println(s);
	}
}
