<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*,br.com.caelum.jdbc.modelo.*,br.com.caelum.jdbc.dao.*"         %>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<body>
<table>
<%
 ContatoDao dao  = new ContatoDao();
  List<Contato> contatos     = dao.getLista();
  for (Contato contato : contatos) {
%>
<tr>
<td>Número </td>
<td>Nome </td>
<td>Endereço </td>
<td>Email </td>
<td>Data </td>
</tr>
<tr>
<td> <%=contato.getId()%> </td>
<td> <%=contato.getNome() %> </td>
<td> <%=contato.getEndereco() %> </td>
<td> <%=contato.getEmail() %> </td>
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");%>
<td> <%=sdf.format(contato.getDataNascimento().getTime()) %> </td>
</tr>
<%}%>





</table>
</body>
</html>
