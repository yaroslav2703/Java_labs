<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import= "others.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>index</p>

<a href="http://localhost:80/lab13/sss?file=file1.docx">Sss</a>

<%
	String d = (String) getServletContext().getInitParameter("doc-dir");
	Choise ch = new Choise(d, "docx");
	String ll = null; 
	for (int i = 0; i < ch.listxxx.length; i++) {
	   ll = ch.listxxx[i];	
%>
<br />
<a href="http://localhost:80/lab13/sss?file=<%=ll%>"> <%=ll%> </a> 
<%}%>
</body>
</html>






