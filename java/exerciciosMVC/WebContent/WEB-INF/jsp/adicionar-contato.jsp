<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags" %>
<link href=<c:url value="scripts/datepicker/jquery-ui.css" /> rel="stylesheet"/>
<script type="text/javascript" src=<c:url value="scripts/datepicker/external/jquery/jquery.js" /> ></script>
<script type="text/javascript" src=<c:url value="scripts/datepicker/jquery-ui.js" /> ></script>

<title>Adicionar Contato</title>
	<style type="text/css">
		ul li {
				list-style-type: none;
		}
		ul li label{
		    width: 150px;
			display: inline-block;
			padding: 5px;
		}
	</style>
</head>
<body>
	<c:import url="/cabecalho.jsp"></c:import>
	<form action="Sistema" method="POST">
		<ul>
			<li>
				<label>Nome</label>
				<input type="text" name="nome"
					<c:if test='${not empty contato.matricula}'>
						value = '${contato.nome}'
					</c:if>
				>
			</li>
			<li>
				<label>RG</label>
				<input type="text" name="rg"
					<c:if test='${not empty contato.matricula}'>
						value = '${contato.rg}'
					</c:if>
				>
			</li>
			<li>
				<label>Endereço</label>
				<input type="text" name="endereco"
					<c:if test='${not empty contato.matricula}'>
						value = '${contato.endereco}'
					</c:if>
				>
			</li>
			<li>
				<label>Email</label>
				<input type="text" name="email"
					<c:if test='${not empty contato.matricula}'>
						value = '${contato.email}'
					</c:if>
				>
			</li>
			<li>
				<label>Data Nascimento</label>
				<c:if test='${not empty contato.matricula}'>
					<fmt:formatDate var = "dataNasc" value="${contato.dataNascimento}"/>
				</c:if>
				<customTags:tagData id="dataNascimento" value="${dataNasc}"/>
			</li>
		</ul>
		<c:if test='${not empty contato.matricula}'>
			<input type="hidden" value="${ contato.matricula }" name="id">			
		</c:if>
		<input type="hidden" value="AdicionarContato" name="logica">
		<input type="submit" value="Gravar">
	</form>
	<c:import url="/rodape.jsp"></c:import>
</body>
</html>