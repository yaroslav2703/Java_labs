import javax.servlet.*;
import javax.servlet.http.*; // расширение javax.servlet для http
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;



public class Aaa extends HttpServlet implements Servlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputLine;
        PrintWriter pw = resp.getWriter();
        URL obj = new URL("http://localhost:80/lab8/Bbb");
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Header1", "Header1");
        httpURLConnection.setRequestProperty("Header2", "Header2");
        httpURLConnection.setRequestProperty("Header3", "Header3");
        String urlParameters = "Param1=Param1&Param2=Param2&Param3=Param3";

        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(10000);

        DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        pw.println("Response Code: " + httpURLConnection.getResponseCode());
        pw.println();
        pw.println("Response:");

        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

        while ((inputLine = in.readLine()) != null) pw.println(inputLine);

        Map<String, List<String>> headerNames = httpURLConnection.getHeaderFields();

        pw.println();
        pw.println("Headers from Servlet Bbb :");

        for (Map.Entry<String, List<String>> header : headerNames.entrySet()) {
            pw.println(header.getKey() + ": " + header.getValue());
        }

        in.close();
    }

}