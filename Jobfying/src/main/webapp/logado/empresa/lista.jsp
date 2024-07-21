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
				<fmt:message key="enterprises.welcome" />
			</h1>
			<h2>
				<a href="/${sessionScope.contextPath}/vagas">
					<fmt:message key="vacancies.entity" />
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
				<a href="/${sessionScope.contextPath}/empresas/cadastro">
					<fmt:message key="enterprises.create" />
				</a>
			</h2>
			<h3><fmt:message key="enterprises.list" /></h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th><fmt:message key="enterprise.ID" /></th>
					<th><fmt:message key="enterprise.cnpj" /></th>
					<th><fmt:message key="enterprise.name" /></th>
					<th><fmt:message key="actions.link" /></th>
				</tr>
				<c:forEach var="empresa" items="${requestScope.listaEmpresas}">
					<tr>
						<td><c:out value="${empresa.id}" /></td>
						<td><c:out value="${empresa.cnpj}" /></td>
						<td><c:out value="${empresa.nome}" /></td>
						<td><a
									href="/${sessionScope.contextPath}/empresas/remocao?id=<c:out value='${empresa.id}' />"
									onclick="return confirm('<fmt:message key="confirm.link" />');">
									<fmt:message key="enterprises.delete" />
							</a>
						</td>
						<td><a
								href="/${sessionScope.contextPath}/empresas/edicao?id=<c:out value='${empresa.id}' /> />">
									<fmt:message key="enterprises.update" />
								</a>
					
					</tr>
				
				
				</c:forEach>
				
			
			</table>
		</div>
	
	</body>

</fmt:bundle>
</html>
