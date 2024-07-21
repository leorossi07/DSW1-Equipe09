<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table  border="1" style="width: 400; border: 1px solid black">


	<tr>
		<th></th>
		<th> Data </th>
		<th> Status </th>
		<th> Vaga </th>
		<th> Profissional </th>	
	</tr>
	<c:forEach var="candidatura" items="${candidaturas}">
		<tr>
			<td style="width: 10%; text-align: center;"> <input type="radio" id="${candidatura.key}" name="candidatura" value="${candidatura.key}" required></td>
			<td>${candidatura.value.data}</td>
			<td>${candidatura.value.status}</td>
			<td>${candidatura.value.vaga.titulo}</td>
			<td>${candidatura.value.profissional.nome}</td>
		</tr>
	</c:forEach>
</table>

<br/>
<br/>

<tr>
	<td colspan="2" align="center"><input type="submit" value="<fmt:message key="save.link" />" /></td>
</tr>
