<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagem de Erro</title>
    </head>
    <body>
        <h1>Campo(s) não preenchido(s)</h1>
        <h2>
            <% out.print(request.getAttribute("mensagem"));%>
        </h2>
        <h3><a href="javascript:history.go(-1);">Voltar</a></h3>
    </body>
</html>
