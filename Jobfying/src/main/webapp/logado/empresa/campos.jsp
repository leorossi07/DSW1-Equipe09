<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${empresa != null}">
				<fmt:message key="enterprises.update" />
			</c:when>
			<c:otherwise>
				<fmt:message key="enterprises.create" />
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${empresa != null}">
		<input type="hidden" name="id" value="<c:out value='${empresa.id}' />" />
	</c:if>
	<tr>
		<td><label for="cnpj"><fmt:message key="enterprise.cnpj" /></label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="18" required value="<c:out value='${empresa.cnpj}' />" /></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="enterprise.name" /></label></td>
		<td><input type="text" name ="nome" size="45" required value="<c:out value='${empresa.nome}' />" /></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="save.link" />" /></td>
	</tr>

</table>
