<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar post realizado com sucesso! </title>
    <link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

      <%@ include file="header.jsp" %>
<!--  -->
<div class="custom-center">
    <div class="container text-center mt-5 rounded border border-4 border-dark bg-secondary custom-border custom-center h-75">
        <div class="row d-flex justify-content-center w-100">
            <div class="div-container">
                <img class="img img-top blinking-image mt-4" src="./imagens/success-removebg-preview.png" alt="">
            </div>
            <div class="mt-4">
                <h3>CADASTRO REALIZADO COM SUCESSO!</h3>
                <h5>O POST JÁ SE ENCONTRA NA BASE DE DADOS!</h5>
            </div>
            <div class="mt-2">
             <form action="/SprintFinal/successCadastroPost" method="post">
             <button type="submit" name="adicionarMaisPost" value="Adicionar Mais Post" class="btn btn-outline-white btn-primary btn-hover w-50">ADICIONAR MAIS POST</button>
             
             <button name="sair" type="submit" class="btn btn-outline-white btn-primary btn-hover w-50 mt-2">LOGAR OUTRO CLIENTE</button>
             </form>
        <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-primary btn-hover mt-1 mb-5 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
				
				
            </div>
        </div>

    </div>

</div>

 <%@ include file="footer.jsp" %>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>