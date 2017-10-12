<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style>
		.imgLogo{
			background-color: black;
	    	width: 100%;
	    }
	    .usuario{
		    color: #FFF;
	    	float: right;
	    }
	</style>
</head>
<body>
	<div class="imgLogo">
		<div class="usuario">
			<c:choose>
				<c:when test="${empty usuario}">
					<a href="<c:url value="login.jsp"/>">LOGIN</a>
				</c:when>
				<c:otherwise>
					<p>${usuario} <a href="Sistema?logica=Logoff">LOGOFF</a></p>
				</c:otherwise>
			</c:choose>
		</div>
		<img alt="Logo" src="<c:url value="/imagens/logotipo.jpg"/>">
	</div>
</body>
</html>