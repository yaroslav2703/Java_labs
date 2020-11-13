package lst;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;


public class L1 implements ServletContextListener{
   public void contextInitialized(ServletContextEvent sce) {
       ServletContext ss = sce.getServletContext();
       System.out.println("L1:contextInitialized");
       System.out.println("L1:serverInfo="+ss.getServerInfo());
   }

   public void contextDestroyed(ServletContextEvent sce) {
       ServletContext ss = sce.getServletContext();
       System.out.println("L1:contextDestroyed");
   }
}