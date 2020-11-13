package lst;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


public class L2 implements HttpSessionAttributeListener{
   public void attributeAdded(HttpSessionBindingEvent sbe) {
      System.out.println("L2:attributeAdded:AtributeName= "
              +sbe.getName());
      System.out.println("L2:attributeAdded:AtributeValue "
              +sbe.getValue());
  }

  public void attributeRemoved(HttpSessionBindingEvent sbe) {
      System.out.println("L2:attributeRemoved:AtributeName= "
              +sbe.getName());
      System.out.println("L2:attributeRemoved:AtributeValue "
              +sbe.getValue());
  }

  public void attributeReplaced(HttpSessionBindingEvent sbe) {
      System.out.println("L2:attributeReplaced:AtributeName="
              +sbe.getName());
      System.out.println("L2:attributeReplaced:AtributeOldValue "
              +sbe.getValue());
  }
}