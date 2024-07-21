<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

	<head>
<title><fmt:message key="page.title" /></title>
	</head>

	<body>

		<div align="center">
			<h1>
				<fmt:message key="candidacy.welcome" />
			</h1>
			<h2>
				<a href="/${sessionScope.contextPath}/candidaturas/cadastro"> 
					<fmt:message key="candidancy.create" />
				</a> 
				&nbsp;&nbsp;&nbsp; 
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					<fmt:message key="exit.link" />
				</a>
			</h2>
			<br />
			<h3><fmt:message key="candidacy.list" /></h3>
			<br />
		</div>

		<div align="center">
			<table border="1">
				<caption></caption>
				<tr>
					<th><fmt:message key="candidacy.ID" /></th>
					<th><fmt:message key="candidacy.date" /></th>
					<th><fmt:message key="candidacy.status" /></th>
					<th><fmt:message key="candidacy.vacancy.title" /></th>
					<th><fmt:message key="candidacy.profissional.name" /></th>

				</tr>
				<c:forEach var="candidatura" items="${requestScope.listaCandidaturas}">
					<tr>
						<td>${candidatura.id}</td>
						<td>${candidatura.data}</td>
						<td>${candidatura.status}</td>
						<td>${candidatura.vaga.titulo}</td>
						<td>${ccandidatura.profissional.nome}</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</fmt:bundle>

</html>
