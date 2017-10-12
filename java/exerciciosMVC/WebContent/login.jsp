<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Login Sistema</title>
<style type="text/css">
	ul li {
				list-style-type: none;
		}
		ul li label{
		    width: 50px;
			display: inline-block;
			padding: 5px;
		}
</style>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<form action="Sistema" method="POST">
		<ul>
			<li>
				<label>E-mail</label>
				<input type="text" name="email">
			</li>
			<li>
				<label>Senha</label>
				<input type="password" name="senha">
			</li>
		</ul>
		<input type="hidden" name="logica" value="Login">
		<input type="submit" name="logar" value="Logar">
	</form>
	
	<c:import url="rodape.jsp"></c:import>
</body>
</html>