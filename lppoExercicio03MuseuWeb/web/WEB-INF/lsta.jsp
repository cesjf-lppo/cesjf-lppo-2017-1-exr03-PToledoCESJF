<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Visitantes</title>
    </head>
    <body>
        <h1>Lista de Visitantes!</h1>
        <a href="novo.html">Novo Visitante...</a>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Idade</th>
                <th>Entrad</th>
                <th>Saida</th>
            </tr>
            <c:forEach var="visitantes" items="lstVisitantes">
                <tr>
                    <td>${visitante.id}</td>
                    <td>${visitante.nome}</td>
                    <td>${visitante.idade}</td>
                    <td>${visitante.entrada}</td>
                    <td>${visitante.saida}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
