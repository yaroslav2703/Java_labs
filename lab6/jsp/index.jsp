<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>lab6</title>
</head>
<body>
<h4>Запрос URLn</h4>
<form action="/lab6/Urln" method="GET">
    <input type="text" name="urln" placeholder="URLn">
    <button type="submit">click</button>
</form>
<hr/>
<h4>GET</h4>
<form action="/lab6/Ccc" method="get">
    <input type="text" name="value1" placeholder="Value1"/><br/>
    <input type="text" name="value2" placeholder="Value2"/><br/>
    <input type="text" name="value3" placeholder="Value3"/><br/>
    New <input type="radio" name="CBean" value="new" label="New" title=""/><br/>
    Old <input type="radio" name="CBean" value="old" label="Old" title=""/><br/>
    <button type="submit">Click</button>
</form>
</body>
</html>