import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "ReadEmailServlet", urlPatterns = "/GoReader")
public class ReadEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        try {
            Session session = Session.getDefaultInstance(new Properties());
            Store store = session.getStore("imaps");
            store.connect(getServletContext().getInitParameter("mailHostInbox"),
                    Integer.parseInt(getServletContext().getInitParameter("mailPortInbox")),
                    getServletContext().getInitParameter("mailUsername"),
                    getServletContext().getInitParameter("mailPassword"));
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            response.setContentType("text/html;charset=utf-8");
            printWriter.println("Messages count: " + messages.length);
            printWriter.println("<table border=\"1\">");
            for (Message message : messages) {
                printWriter.println("<tr>");
                printWriter.println("<td>SendDate: " + message.getSentDate() + "</td>");
                printWriter.println("<td>Subject: " + message.getSubject() + "</td>");
                printWriter.println("<td>Content: " + message.getContent() + "</td>");
            }
            printWriter.println("</table>");
            printWriter.flush();
        } catch (Exception exept) {
            printWriter.println("Error" + exept.getMessage());

        }
    }
}