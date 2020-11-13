import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import business.Product;
import business.ProductDB;

@WebServlet("/procedure")
public class ProcedureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        try{
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception ex)
        {
            System.out.println(ex);
        }

        String respData = "id\t name\t price\n";

        Product log = ProductDB.ExecuteProcedure(id);
        respData += String.format("%s\t %s\t %s\n", log.getId(), log.getName(), log.getPrice());
        resp.getWriter().print(respData);
    }
}
