<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Funcionário</title>
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
   
   <header class="mx-2 mb-5 p-3">
        <nav class="navbar bg-secondary-subtle fixed-top">
            <div class="container-fluid">
                <div class="d-flex justify-content-between">
                    <div class="navbar-brand">
                        <div class="row">
                            <div class="col-md-2">
                                <div class="mb-3 mt-3">
                                    <!-- Sua imagem -->
                                    <a href="home.jsp">
                                    <img src="./imagens/logo.png" class="card-img h-100 w-100 mx-3" alt="...">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
            </div>
        </nav>
    </header>
    
    <div class="custom-center" style="margin-top:30vh; margin-bottom: 13vh">
        <div class="mt-5 container text-center rounded border border-4 border-dark bg-secondary custom-border custom-center h-75">
            <div class="row d-flex justify-content-center w-100">
                <div class="d-flex flex-column align-items-center">
                    <h3 class="fw-bold mt-4">LOGIN DE FUNCIONÁRIO</h3>
                </div>
                <div class="col-md-6">
                    <form class="mt-2" action="/SprintFinal/logarFuncionario" method="post">
                        <div class="mb-3">
                            <label for="emailFuncionario" class="form-label fs-4 fw-bold" id="idCliente">Email insituicional:</label>
                            <input type="text" class="form-control" id="email" name="email" placeholder="ex: user@example.com" maxlength="50" required>
                        </div>
                        <div>
                            <button type="submit" class="btn btn-outline-white btn-primary btn-hover w-50">ENTRAR</button>
                         
                        </div>
                    </form>
                    <div class="d-flex flex-column align-items-center">
                        <a href="home.jsp" class="btn btn-outline-white btn-primary btn-hover w-50 mt-3 mb-1">SAIR</a>
                        
                    </div>

                    <%
                    String mensagemErro = (String) request.getAttribute("mensagemErro");
                    if (mensagemErro != null) {
                    %>
                    <div>
                        <h3 class="text-danger mt-1 fs-6"><%=mensagemErro%></h3>
                    </div>
                    <%
                    }
                    %>
                </div>
            </div>
        </div>
    </div>
    <br><br><br>
    <%@ include file="footer.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</body>
</html>
</html>