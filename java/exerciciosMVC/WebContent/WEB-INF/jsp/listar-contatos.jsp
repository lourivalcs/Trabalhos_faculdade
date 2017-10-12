<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem</title>
</head>
<body>
	<c:import url="/cabecalho.jsp"></c:import>
		<a href='Sistema?logica=ExibirFormAdicionarContato'>Adicionar Contato</a>
		<table border="1">
			<thead>
				<tr>
					<td>Matricula</td>
					<td>Nome</td>
					<td>RG</td>
					<td>E-mail</td>
					<td>Endereco</td>
					<td>Data Nascimento</td>
					<td colspan="2">Ação</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="contato" items="${contatos}" varStatus="id">
			    	<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
			    		<td>${contato.matricula}</td>
			    		<td>${contato.nome}</td>
			      		<td>${contato.rg}</td>
			      		<td>
				      		<c:choose>
								<c:when test="${not empty contato.email}">
									<a href="mailto:${contato.email}">${contato.email}</a>
								</c:when>
								<c:otherwise>E-mail não informado</c:otherwise>
							</c:choose>
						</td>
			      		<td>${contato.endereco}</td>
			      		<td><fmt:formatDate value="${contato.dataNascimento}"/></td>
			      		<td><a href="Sistema?logica=AlterarContato&id=${contato.matricula}">Alterar</a></td>
			      		<td><a href="Sistema?logica=RemoverContato&id=${contato.matricula}">Remover</a></td>
			    	</tr>
		  		</c:forEach>
			</tbody>
		</table>
	<c:import url="/rodape.jsp"></c:import>
</body>
</html>