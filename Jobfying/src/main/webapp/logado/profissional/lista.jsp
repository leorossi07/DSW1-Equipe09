<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">
    <head>
        <title><fmt:message key="page.title" /></title>
    </head>
    <body>
        <div align="center">
            <h1><fmt:message key="professionals.welcome" /></h1>
            <h2>
                <a href="/${sessionScope.contextPath}/vagas"><fmt:message key="vacancies.entity" /></a>
                &nbsp;&nbsp;&nbsp;
                <a href="/${sessionScope.contextPath}/usuarios"><fmt:message key="users.entity" /></a>
                &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message key="exit.link" /></a>
                <br/><br/>
                <a href="/${sessionScope.contextPath}/profissionais/cadastro"><fmt:message key="professionals.create" /></a>
            </h2>
            <h3><fmt:message key="professionals.list" /></h3>
            <br/>
        </div>
        <div align="center">
            <table border="1">
                <tr>
                    <th><fmt:message key="professional.ID" /></th>
                    <th><fmt:message key="professional.name" /></th>
                    <th><fmt:message key="professional.cpf" /></th>
                    <th><fmt:message key="actions.link" /></th>
                </tr>
                <c:forEach var="profissional" items="${requestScope.listaProfissionais}">
                    <tr>
                        <td><c:out value="${profissional.id}" /></td>
                        <td><c:out value="${profissional.nome}" /></td>
                        <td><c:out value="${profissional.cpf}" /></td>
                        <td>
                            <a href="/${sessionScope.contextPath}/profissionais/remocao?id=<c:out value='${profissional.id}' />" onclick="return confirm('<fmt:message key="confirm.link" />');">
                                <fmt:message key="professionals.delete" />
                            </a>
                        </td>
                        <td>
                            <a href="/${sessionScope.contextPath}/profissionais/edicao?id=<c:out value='${profissional.id}' />">
                                <fmt:message key="professionals.update" />
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</fmt:bundle>
</html>
