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
                <th>Entrada</th>
                <th>Saida</th>
            </tr>
            <c:forEach var="visitantes" items="${lstVisitantes}">
                <tr>
                    <td><a href="edita.html?id=${visitantes.id}">${visitantes.id}</td>
                    <td>${visitantes.nome}</td>
                    <td>${visitantes.idade}</td>
                    <td>${visitantes.entrada}</td>
                    <td>${visitantes.saida}</td>
                    <td><a href="saida.html?id=${visitantes.id}">Sair</a></td>
                    <td><a href="excluir.html?id=${visitantes.id}">X</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
