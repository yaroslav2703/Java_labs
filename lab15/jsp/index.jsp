<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
    <title>Lab15 mail</title>
    </head>
    <body>
    <form action="GoMail" method="post">
    <p>Receiver:<input type="text" name="receiver"></p>
    <p>Message: <input type="text" name="message"></p>
    <p><input type="submit"></p>
    </form>
    <a href="GoReader">Read message from Inbox</a>
    </body>
    </html>