<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.modelo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="d" %>
<html>
<head>
<title>Lista Contatos</title>
 <style type="text/css" media="all">
      @import url("css/maven-base.css"); @import url("css/maven-theme.css"); @import url("css/site.css"); @import
      url("css/screen.css");
    </style>
    <link rel="stylesheet" href="./css/print.css" type="text/css" media="print" />
</head>
<body>
<c:import url="cabecalho.jsp"/>
<a href="mvc?logica=MostraContatoLogic&id=0">Adiciona</a> <br> 
<br/>
<br/>
<d:table name="contatos"  id="dao1Integer" >
<d:column property="id" title="id" sortable="true"></d:column>
<d:column property="nome" sortable="true"></d:column>
<d:column property="email" autolink="true"></d:column>
<d:column property="endereco"></d:column>
<d:column property="dataNascimento.time"  format="{0,date,dd-MM-yyyy}" title="Data Nascimento"> </d:column>
 <d:column title="Remover"  value="Remover" href="mvc?logica=RemoveContatoLogic&id=${id}" paramId="id" paramProperty="id"> Remover  </d:column>
 <d:column title="Alterar"  value="Alterar"  href="mvc?logica=MostraContatoLogic&id=${id}" paramId="id" paramProperty="id" >Alterar</d:column>
  
</d:table>
<!--   <table border="1">
<tr>
<th> Id </th>
<th> Nome </th>
<th> Email </th>
<th> Endereço </th>
<th> Data Nascimento </th>
</tr>
<c:forEach var="contato" items="${dao.lista}" varStatus="id">
<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
<td>${contato.id}</td>
<td>${contato.nome}</td>
<td>
<c:if test="${not empty contato.email}">
<a href="mailto:${contato.email}">${contato.email}</a>
</c:if>

<c:if test="${empty contato.email}">
Email não informado
</c:if>
</td>
<td>${contato.endereco} </td>
<td>
<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
</td>
</tr>
</c:forEach> 
</table>  -->
<c:import url="rodape.jsp"></c:import>
</body>
</html>