<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${vaga !=null}">
				<fmt:message key="vacancies.update" />
			</c:when>
			<c:otherwise>
				<fmt:message key="vacancies.create" />
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${vaga != null}">
		<input type="hidden" name="id" value="${vaga.id}" />
	</c:if>
	<tr>
		<td><label for="titulo"> <fmt:message key="vacancy.title" />
		</label></td>
		<td><input type="text" id="titulo" name="titulo" size="45"
			required value="${vaga.titulo}" /></td>
	</tr>
	<tr>
		<td><label for="remuneracao"> <fmt:message key="vacancy.remuneration" />
		</label></td>
		<td><input type="number" id="remuneracao" name="remuneracao" size="5" required
			value="${vaga.remuneracao}" /></td>
	</tr>
	<tr>
		<td><label for="empresa"> <fmt:message
					key="vacancy.enterprise" />
		</label></td>
		<td><select name="empresa">
				<c:forEach items="${empresa}" var="empresa">
					<option value="${empresa.key}"
						${vaga.empresa.nome==empresa.value ? 'selected' : '' }>
						${empresa.value}</option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td><label for="data"> <fmt:message key="vacancy.data" />
		</label></td>
		<td><input type="text" id="data" name="data" size="45" required
			value="${vaga.data}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="save.link" />" /></td>
	</tr>
</table>
