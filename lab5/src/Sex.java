package stafftag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;


public class Sex extends TagSupport {

    private Boolean value = false;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String in = "<label>Sex:</label><br/>Male <input name =\"sex\" type = \"radio\" value=\"male\"/>";
            out.print(in);
            in = "<br/>Female <input name =\"sex\" type = \"radio\" value=\"female\"/>";
            out.print(in);
        }
        catch (IOException e) {
            System.out.println("stafftag.Sex: " + e);
        }
        return SKIP_BODY;
    }


}