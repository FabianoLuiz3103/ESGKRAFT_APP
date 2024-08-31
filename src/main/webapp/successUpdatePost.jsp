<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atualização post success!</title>
    <link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        /* Estilos para dispositivos móveis */
        @media (max-width: 768px) {
            .container {
                padding: 0;
            }
            .btn-group {
                flex-direction: column;
                align-items: center;
            }
            .btn {
                width: 100%;
                margin: 5px 0;
            }
            .mt-4 {
                margin-top: 1rem;
            }
            .mb-5 {
                margin-bottom: 1rem;
            }
            .img-top {
                max-width: 100%;
                height: auto;
            }
        }
    </style>
</head>
<body>

<%@ include file="header.jsp" %>

<div class="custom-center">
    <div class="container-fluid text-center mt-5 rounded border border-4 border-dark bg-secondary custom-border custom-center h-75">
        <div class="row d-flex justify-content-center">
            <div class="div-container">
                <img class="img img-top blinking-image mt-4" src="./imagens/success-removebg-preview.png" alt="">
            </div>
            <div class="mt-4">
                <h3>ATUALIZAÇÃO DE POST REALIZADA COM SUCESSO!</h3>
            </div>
            <div class="btn-group mt-5 d-flex flex-column align-items-center">
                <div class="col-md-6 col-lg-6 mb-3">
                    <a href="/SprintFinal/updatePost.jsp"><button type="submit" name="atualizarMaisCliente" value="atualizarMaisCliente" class="btn btn-outline-white btn-primary btn-hover w-100">FAZER MAIS UPDATE DE POST</button></a>
                </div>
                <div class="col-md-6 col-lg-6 mb-3">
                    <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-primary btn-hover" style="font-size:14px; width:20vh"><i class="fa fa-home"></i></a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
