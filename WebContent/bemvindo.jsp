<html>
<body>
<%-- Coment�rio em JSP aqui: na nossa primeira p�gina jsp  --%>
<%
String mensagem = "Bem vindo ao sistema de agenda fj21.";
%>

<% out.println(mensagem); %>
<%
String desenvolvido = "Desenvolvido por Tiago";
%>

<%= desenvolvido %>
<br />

<% System.out.println("Tudo foi executado"); %>

</body>
</html>