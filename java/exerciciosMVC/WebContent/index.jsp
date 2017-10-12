<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
		<a href="<c:url value="login.jsp"/>">LOGIN</a>
		<a href='Sistema?logica=ExibirFormAdicionarContato'>Adicionar Contato</a>
		<a href='Sistema?logica=ListarContatos'>Listar Contatos</a>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>