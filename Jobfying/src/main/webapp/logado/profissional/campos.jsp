<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table border="1">
    <caption>
        <c:choose>
            <c:when test="${profissional != null}">
                <fmt:message key="professionals.update" />
            </c:when>
            <c:otherwise>
                <fmt:message key="professionals.create" />
            </c:otherwise>
        </c:choose>
    </caption>
    <c:if test="${profissional != null}">
        <input type="hidden" name="id" value="<c:out value='${profissional.id}' />" />
    </c:if>
    <tr>
        <td><label for="nome"><fmt:message key="professional.name" /></label></td>
        <td><input type="text" id="nome" name="nome" size="45" required value="<c:out value='${profissional.nome}' />" /></td>
    </tr>
    <tr>
        <td><label for="cpf"><fmt:message key="professional.cpf" /></label></td>
        <td><input type="text" id="cpf" name="cpf" size="18" required value="<c:out value='${profissional.cpf}' />" /></td>
    </tr>
    <tr>
        <td><label for="telefone"><fmt:message key="professional.phone" /></label></td>
        <td><input type="text" id="telefone" name="telefone" size="20" required value="<c:out value='${profissional.telefone}' />" /></td>
    </tr>
    <tr>
        <td><label for="sexo"><fmt:message key="professional.gender" /></label></td>
        <td><input type="text" id="sexo" name="sexo" size="10" required value="<c:out value='${profissional.sexo}' />" /></td>
    </tr>
    <tr>
        <td><label for="dataNascimento"><fmt:message key="professional.birthDate" /></label></td>
        <td><input type="text" id="dataNascimento" name="dataNascimento" size="10" required value="<c:out value='${profissional.dataNascimento}' />" /></td>
    </tr>
    <tr>
        <td><label for="usuario"><fmt:message key="professional.user" /></label></td>
        <td><input type="text" id="usuario" name="usuario" size="20" required value="<c:out value='${profissional.usuario.login}' />" /></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="<fmt:message key='save.link' />" /></td>
    </tr>
</table>
