<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menu Update</title>
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
            margin: 0 auto;
            padding: 20px;
            margin-bottom: 20vh;
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
          .tpp {
    margin-top: 20vh;
   
  }
    }
</style>
</head>
<body>
<%@ include file="header.jsp"%>
<div style="display: flex; justify-content: center;">
    <div class="custom-center tpp">
        <div class="container text-center">
            <h1 class="fw-bold fs-1 mb-5" style="margin-top:10vh">MENU DE ATUALIZAÇÃO DE DADOS</h1>
            <div class="row">
                <div class="col-md-6 col-lg-6">
                    <div class="card mt-3">
                        <img src="./imagens/U.png" class="card-img-top w-25 m-auto"
                            alt="Update img">
                        <div class="card-body">
                            <h5 class="card-title fs-6 fw-bold">Alterar cliente por id</h5>
                            <p class="card-text">Alterar dados de clientes através do id do cliente.<br></p>
                            <a href="updateCliente.jsp"
                                class="btn btn-outline-white btn-primary btn-hover w-100">Ir</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6">
                    <div class="card mt-3">
                        <img src="./imagens/U.png" class="card-img-top w-25 m-auto"
                            alt="Update img">
                        <div class="card-body">
                            <h5 class="card-title fs-6 fw-bold">Alterar post por id</h5>
                            <p class="card-text">Alterar dados de posts através do id do post.<br></p>
                            <a href="updatePost.jsp"
                                class="btn btn-outline-white btn-primary btn-hover w-100">Ir</a>
                        </div>
                    </div>
                </div>
            </div>
            <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-dark btn-hover mb-5 mt-4 mx-3" style="width: 20vh; font-size:10px; margin-bottom:15vh "><i class="fa fa-home"></i></a>
        </div>
    </div>
</div>
<br>
<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
