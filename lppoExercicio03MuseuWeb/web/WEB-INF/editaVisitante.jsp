<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Visitante</title>
    </head>
    <body>
        <h1>Edita Visitante!</h1>
                <form action="edita.html" method="POST">
                    <p><input type="hidden" name="txtId" value="${edtVisitante.id}"/>id:${edtVisitante.id}</p>
                    <p><label>Nome:</label><input type="text" name="txtNome" size="40" value="${edtVisitante.nome}" /></p>
                    <p><label>Idade:</label><input type="text" name="txtIdade" size="40" value="${edtVisitante.idade}" /></p>
                    <p><label>Entrada:</label><input type="text" name="txtEntrada" size="40" value="${edtVisitante.entrada}" /></p>
                    <p><label>Saida:</label><input type="text" name="txtSaida" size="40" value="${edtVisitante.saida}" /></p>
                <input type="submit" value="Salvar" />
        </form>
    </body>
</html>
