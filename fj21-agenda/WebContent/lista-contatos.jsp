
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="cabeçalho.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Exercicio 7.7 E 7.8</title>
	</head>
	<body>
		<!-- cria o DAO -->
		<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"/>
		<table border="1">
			<!-- percorre contato montando as linhas da tabela -->
			<c:forEach var="contato" items="${dao.lista}">
				<tr bgcolor="#S{id.count 'aaee88' : 'f8ffff'}">
					<td>${id.count}</td><td>${contato.nome}</td>
					<td>${contato.nome}</td>
						<c:choose>
							<c:when test="${not empty contato.email }">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>
								E-mail não informado
							</c:otherwise>
						</c:choose>
					<td>${contato.email}</td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}"
							pattern="dd/MM/yyyy" />
			</c:forEach>
		</table>
		<c:import url="rodape.jsp" />
	</body>
</html>