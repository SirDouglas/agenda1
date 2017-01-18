<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.modelo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="d" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
<head>
<title>Lista Contatos</title>
 <style type="text/css" media="all">
      @import url("css/maven-base.css"); @import url("css/maven-theme.css"); @import url("css/site.css"); @import
      url("css/screen.css");
    </style>
    <link rel="stylesheet" href="./css/print.css" type="text/css" media="print" />
        <link href="css/jquery-ui.css" rel="stylesheet" />
    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp"/> <br/>
<form action="mvc?logica=AlteraContatoLogic" method="post">
<input type="hidden" id="id" name="id" value="${contato.id}">
<label>Nome</label> <input type="text" name="nome" value="${contato.nome}" />  <br/>
<label>Endereço</label> <input type="text" name="endereco" value="${contato.endereco}" /> <br/>
<label>Email</label> <input type="text" name="email" value="${contato.email}"/> <br/>
<label>Data</label>  <fmt:formatDate  value="${contato.dataNascimento.time}" var="dataFormatada" /> <caelum:campoData id="dataNascimento" value="${dataFormatada}" />   <br/>
 <!--  <input type="hidden" name="logica"   value="AlteraContatoLogic" />   -->
 <br/>
<input type="submit" value="Gravar">
</form>
<c:import url="rodape.jsp"></c:import>
</body>
</html>