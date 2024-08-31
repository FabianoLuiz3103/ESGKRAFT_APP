<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login cliente</title>
    <link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        /* Estilos personalizados para dispositivos móveis */
        @media (max-width: 768px) {
            .custom-center {
                padding: 10px;
            }
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
    
    <div class="custom-center">
        <div class="mt-5 container text-center rounded border border-4 border-dark bg-secondary custom-border custom-center h-75">
            <div class="row d-flex justify-content-center w-100">
                <div class="d-flex flex-column align-items-center">
                    <h3 class="fw-bold mt-2">LOGIN DE CLIENTE PARA CADASTRO DE POST</h3>
                </div>
                <div class="col-md-6">
                    <form class="mt-2" action="/SprintFinal/logarCliente" method="post">
                        <div class="mb-3">
                            <label for="idCliente" class="form-label fs-4 fw-bold" id="idCliente">Id do cliente:</label>
                            <input type="text" class="form-control" id="idClienteInput" name="idCliente" placeholder="ex: CXXX" maxlength="6" required>
                        </div>
                        <div>
                            <button type="submit" class="btn btn-outline-white btn-primary btn-hover w-50">ENTRAR</button>
                            <p class="mt-2">O cliente não tem cadastro?</p>
                        </div>
                    </form>
                    <div class="d-flex flex-column align-items-center">
                        <a href="/SprintFinal/novoCliente" class="btn btn-outline-white btn-primary btn-hover w-50">CADASTRAR CLIENTE</a>
                        <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-primary btn-hover mt-2 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
                    <%
                    String mensagemErro = (String) request.getAttribute("mensagemErro");
                    if (mensagemErro != null) {
                    %>
                        <h3 class="text-danger mt-1 fs-6"><%=mensagemErro%></h3>
                    <%
                    }
                    %>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
    $(document).ready(function() {
        // Verifique se há um parâmetro "idCliente" na URL
        const urlParams = new URLSearchParams(window.location.search);
        if (urlParams.has('idCliente')) {
            // Recupere o valor do parâmetro "idCliente"
            const idCliente = urlParams.get('idCliente');
            
            // Preencha automaticamente o campo de entrada com o valor do ID
            document.getElementById("idClienteInput").value = idCliente;
            
            console.log('Valor de idCliente:', idCliente);
        }
    });
    </script>
</body>
</html>
