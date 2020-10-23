package stafftag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;


public class Surname extends TagSupport {

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
            String in = "<label>Surname</label>"
                    + "<input name =\"surname\" type = \"text\" width = \"150\" maxlength= \"14\" placeholder = \"Surname\" ";
            out.print(in + (this.value.equals("") ? " " : "value =\"" + this.value + "\" />"));
        } catch (IOException e) {
            System.out.println("stafftag.Surname: " + e);
        }
        return SKIP_BODY;
    }

}