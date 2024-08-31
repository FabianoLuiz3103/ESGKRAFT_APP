<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menu de Leitura de Dados</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous">
<link rel="stylesheet" href="./folhas_estilo/home.css">
<link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
    /* Estilo para telas pequenas */
    @media (max-width: 768px) {
        .custom-center {
            padding: 30px;
            margin-bottom: 50vh;
            margin-top: 50vh;
        }
        .navbar-toggler {
            margin-left: auto;
        }
        .card {
            width: 100%;
        }
        .card-title {
            font-size: 16px;
        }
        .card-text {
            font-size: 10px;
        }
        .btn {
            width: 100%;
            font-size: 12px;
            padding: 5px 10px;
        }
        .fs-1 {
            font-size: 24px;
        }
        .mt-5 {
            margin-top: 2rem;
        }
        .mx-3 {
            margin-left: 0.5rem;
            margin-right: 0.5rem;
        }
        .fa-home {
            font-size: 16px;
        }
    }
</style>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="custom-center">
    <div class="container text-center">
        <div class="row">
            <h1 class="mt-5 fw-bold fs-1 mb-5">MENU DE LEITURA DE DADOS</h1>
            <div class="col-md-6 col-lg-3">
                <div class="card mb-3">
                    <img src="./imagens/R.png" class="card-img-top w-25 m-auto" alt="Read img">
                    <div class="card-body">
                        <h5 class="card-title fs-6">Tabela clientes</h5>
                        <p class="card-text">- Tabela apresentando clientes<br></p>
                        <a href="tabelaCliente.jsp" class="btn btn-outline-white btn-primary btn-hover w-100">Ir</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <div class="card mb-3">
                    <img src="./imagens/R.png" class="card-img-top w-25 m-auto" alt="Read img">
                    <div class="card-body">
                        <h5 class="card-title fs-6">Tabela posts</h5>
                        <p class="card-text">- Tabela apresentando posts<br></p>
                        <a href="tabelaPosts.jsp" class="btn btn-outline-white btn-primary btn-hover w-100">Ir</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <div class="card mb-3">
                    <img src="./imagens/R.png" class="card-img-top w-25 m-auto" alt="Read img">
                    <div class="card-body">
                        <h5 class="card-title fs-6">Tabela clientes com posts</h5>
                        <p class="card-text">- Tabela de clientes que têm posts<br></p>
                        <a href="tabelaClientePost.jsp" class="btn btn-outline-white btn-primary btn-hover w-100">Ir</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <div class="card mb-3">
                    <img src="./imagens/R.png" class="card-img-top w-25 m-auto" alt="Read img">
                    <div class="card-body">
                        <h5 class="card-title fs-6">Dashboards</h5>
                        <p class="card-text">- Gráficos informativos<br></p>
                        <a href="dashboards.jsp" class="btn btn-outline-white btn-primary btn-hover w-100">Ir</a>
                    </div>
                </div>
            </div>
        </div>
        <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-dark btn-hover mt-5 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
    </div>
</div>
<br>
<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
