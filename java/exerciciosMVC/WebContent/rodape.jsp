<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="data" class="java.util.Date"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style>
		.rodape{
	   	 	position: absolute;
	   		bottom: 0;
	   	}
	</style>
</head>
<body>
	<div class="rodape">
		<p>Copyright &copy; <fmt:formatDate pattern="YYYY" value="${data}"/> </p>
	</div>	
</body>
</html>