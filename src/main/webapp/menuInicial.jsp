<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menu inicial!</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous">
<link rel="stylesheet" href="./folhas_estilo/home.css">
<link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
<style>
  /* Estilos para dispositivos móveis */
 @media (max-width: 768px) {
  .custom-center {
    margin: 0;
    padding: 30px;
  }
  .navbar-toggler {
    margin-left: auto;
  }
  .navbar-brand .col-md-2 {
    text-align: center;
  }
  .card {
    width: 100%;
    height: 100%;
    margin-bottom: 20px; /* Ajuste a margem inferior dos cards */
  }
  .card-title {
    font-size: 16px;
  }
  .card-text {
    font-size: 12px;
  }
  .btn {
    width: 100%;
    font-size: 12px;
    padding: 5px 10px;
  }
  .fs-1 {
    font-size: 24px;
  }
  .fw-semi-bold {
    font-weight: 600;
  }
  .tp {
    margin-top: 5vh;
    margin-bottom: 7vh;
  }
  .tpp {
    margin-top: 100vh;
    margin-bottom: 120vh; /* Ajuste a margem inferior dos cards em relação ao footer */
  }
  
    .logo {
        max-width: 18vh; /* Tamanho máximo para a logo em telas pequenas */
    }
}
 
 
</style>
</head>
<body>

<header class="mx-2 mb-5 p-3">
    <nav class="navbar bg-secondary-subtle fixed-top">
        <div class="container-fluid">
            <div class="d-flex justify-content-between align-items-center">
                <div class="navbar-brand">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="mb-3 mt-3">
                                <!-- Sua imagem -->
                                <a href="home.jsp"> <img src="./imagens/logo.png"
                                    class=" card-img h-100 w-100 mx-3 logo" alt="...">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="position-absolute top-0 end-0 ">
                    <a href="home.jsp">
                        <button class="navbar-toggler mt-3 fw-bold" style="width:100px; height:50px; margin-right:3vh;" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                            SAIR
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </nav>
</header>


<div class="custom-center mb-5 tpp">
    <div class="container text-center">
        <div class="row">
            <h1 class="up mt-5 fw-bold fs-1">Olá ${sessionScope.nomeFuncionario}, </h1>
            <h6 class="fw-semi-bold fs-6" style="margin-bottom: 80px">SEJA BEM-VINDO(A) AO PORTAL <i>ESGKRAFT</i></h6>
            <div class="col-md-6 col-lg-3 tp">
                <div class="card">
                    <img src="./imagens/C.png" class="card-img-top w-25 m-auto" alt="Create img">
                    <div class="card-body">
                        <h5 class="card-title fs-6">Login/Cadastro de cliente e post</h5>
                        <p class="card-text">- Sessão de login para cliente que já tem cadastro;<br>
                        - Sessão de cadastro para cliente que não tem cadastro;<br>
                        - Sessão de cadastro de post.</p>
                        <a href="logarCliente" class="btn btn-outline-white btn-primary btn-hover w-50">Ir</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3 tp">
                <div class="card">
                    <img src="./imagens/R.png" class="card-img-top w-25 m-auto" alt="Read img">
                    <div class="card-body">
                        <h5 class="card-title fs-6">Leitura dos dados com dashboards interativos</h5>
                        <p class="card-text">- Apresentação de dashboard com gráficos sobre determinados parâmetros;<br>
                        - Apresentação de tabelas;</p>
                        <a href="menuLeitura.jsp" class="btn btn-outline-white btn-primary btn-hover w-50">Ir</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3 tp">
                <div class="card">
                    <img src="./imagens/U.png" class="card-img-top w-25 m-auto mt-1" alt="Update img">
                    <div class="card-body">
                        <h5 class="card-title fs-6 mt-3">Atualização de clientes e posts</h5>
                        <p class="card-text">- Atualizar dados de posts através do id do post informado;<br>
                        - Atualizar dados de clientes através do id do cliente.</p>
                        <a href="menuUpdate.jsp" class="btn btn-outline-white btn-primary btn-hover w-50">Ir</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3 tp">
                <div class="card ">
                    <img src="./imagens/d.png" class="card-img-top w-25 m-auto mt-1" alt="Delete img">
                    <div class="card-body">
                        <h5 class="card-title fs-6 mt-3">Deletar clientes e posts pelo id</h5>
                        <p class="card-text"><br>- Excluir posts através do id do post;<br>
                        - Excluir clientes através do id do cliente informado.</p>
                        <a href="menuDeletar.jsp" class=" btn btn-outline-white btn-primary btn-hover w-50">Ir</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<br>
<%@ include file="footer.jsp"%>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
</body>
</html>
