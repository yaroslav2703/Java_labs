<%@page %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="jspclass.* "%>
<!-- .......................................... -->
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=ISO-8859-1">
    <title>LAB4 PITSUKHA Y.</title>
    <%! String name = null;
        Regimex r = new Regimex();
        Integer n = r.GetHOUR();
        protected String Salutation(Integer h) {
            String rc = "Good ";
            if ((h > 0) && (h <= 5))
                rc += "night";
            else if ((h > 5) && (h <= 12))
                rc += "morning";
            else if ((h > 12) && (h <= 17))
                rc += "afternoon";
            else
                rc += "evening";
            return rc;
        }%>
</head>
<body>
<!-- .......................................... -->
    <%=Salutation(n)%>
<!-- .......................................... -->
    <hr/>
    <%!
        Calendar calendar = Calendar.getInstance();
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    %>
    <table id="tbl" class="table"></table>
    <form action="Jjj" method="POST">
        <input type="submit" name="press" content="press(POST)">
    </form>
    <script>
        function createTable() {
            <%
              StringBuilder htmlValue = new StringBuilder();
              String wDay = "";
              htmlValue
                  .append("<tr>")
                  .append("<td>").append("DAY OF WEEK").append("</td>")
                  .append("<td>").append("DATE").append("</td>")
                  .append("</tr>");
              for (int i = 0; i < 7; i++) {
                int day = 24*60*60*1000*i;
                switch (weekDay) {
                    case 1: wDay = "7.sunday"; break;
                    case 2: wDay = "1.monday"; break;
                    case 3: wDay = "2.tuesday"; break;
                    case 4: wDay = "3.wednesday"; break;
                    case 5: wDay = "4.thursday"; break;
                    case 6: wDay = "5.friday"; break;
                    case 7: wDay = "6.saturday"; break;
                }
                htmlValue
                  .append("<tr class='table-row' >")
                  .append("<td class='table-cell' >").append(wDay).append("</td>")
                  .append("<td class='table-cell' >").append(dateFormat.format(new Date(calendar.getTimeInMillis() + day))).append("</td>")
                  .append("</tr>");
                weekDay = (weekDay % 7) + 1;
              }
            %>
            document.getElementById("tbl").innerHTML = "<%= htmlValue %>";
        }
        createTable();
    </script>
    <hr/>
    <%--<%@ include file="afternoon.jsp" %>--%>
    <jsp:include page="afternoon.jsp"></jsp:include>
    <%--<jsp:forward page="afternoon.jsp"></jsp:forward>--%>
    <hr>
    <a href="/lab4/Afternoon">Afternoon servlet</a>
    <hr>
</body>
</html>
