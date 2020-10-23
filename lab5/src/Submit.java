package stafftag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;


public class Submit extends TagSupport {

    public String value = "";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String in = "<input type = \"submit\" value = \"OK\" />";
            out.print(in);
            in = "<br><input type = \"button\" value = \"Cancel\" />";
            out.print(in);
        }
        catch (IOException e) {
            System.out.println("stafftag.Submit: " + e);
        }
        return SKIP_BODY;
    }

}