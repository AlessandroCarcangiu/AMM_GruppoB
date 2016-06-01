<%-- 
    Document   : listaAlunniJson
    Created on : 1-giu-2016, 11.45.48
    Author     : Alessandro
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="alunno" items="${listaAlunni}">
        <json:object>
            <json:property name="nome" value="${alunno.nome}"/>
            <json:property name="cognome" value="${alunno.cognome}"/>
            <json:property name="id" value="${alunno.id}"/>
        </json:object>
    </c:forEach>
</json:array>