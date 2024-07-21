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
				<fmt:message key="vacancies.welcome" />
			</h1>
			<h2>
				<a href="/${sessionScope.contextPath}/empresas">
					<fmt:message key="enterprises.entity" />
				</a>
				&nbsp;&nbsp;&nbsp;
				<a href="/${sessionScope.contextPath}/usuarios"> 
					<fmt:message key="users.entity" />
				</a> 
				&nbsp;&nbsp;&nbsp;
			    <a href="${pageContext.request.contextPath}/logout.jsp">
					<fmt:message key="exit.link" />
				</a>
				<br/>
				<br/>
				<a href="/${sessionScope.contextPath}/vagas/cadastro">
					<fmt:message key="vacancies.create" />
				</a>
			</h2>
			<h3><fmt:message key="vacancies.list" /></h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th><fmt:message key="vacancy.ID" /></th>
					<th><fmt:message key="vacancy.title" /></th>
					<th><fmt:message key="vacancy.remuneration" /></th>
					<th><fmt:message key="vacancy.enterprise" /></th>
					<th><fmt:message key="vacancy.data" /></th>
				</tr>
				<c:forEach var="vaga" items="${requestScope.listaVagas}">
					<tr>
						<td>${vaga.id}</td>
						<td>${vaga.titulo}</td>
						<td>${vaga.remuneracao}</td>
						<td>${vaga.empresa.nome}</td>
						<td>${vaga.data}</td>

						<td><a href="/${sessionScope.contextPath}/vagas/edicao?id=${vaga.id}">
								<fmt:message key="vacancies.update" />
						</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/${sessionScope.contextPath}/vagas/remocao?id=${vaga.id}"
							onclick="return confirm('<fmt:message key="confirm.link" />');">
								<fmt:message key="vacancies.delete" />
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</body>
</fmt:bundle>

</html>
