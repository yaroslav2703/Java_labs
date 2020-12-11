<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript">
        var ws = null;

        function connect() {
            ws = new WebSocket("ws://localhost:80/lab16/websock");

            ws.onmessage = function (event) {
                document.getElementById('outdiv').innerHTML = event.data;
            };
        }

        function disconnect(){
            ws.close();
        }
        </script>
</head>
<body>
    <button onclick="connect()">START</button>
    <button onclick="disconnect();">STOP</button>
    <div id="outdiv"></div>
</body>
</html>