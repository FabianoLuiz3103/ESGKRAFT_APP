<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menu delete</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous">
<link rel="stylesheet" href="./folhas_estilo/home.css">
<link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
  /* Estilos para dispositivos móveis */
  @media (max-width: 768px) {
    .custom-center {
      margin: 0;
      padding: 30px;

    }
    .card {
      width: 100%;
    
      
    }
    .card-title {
      font-size: 16px;
    }
    .card-text {
      font-size: 12px;
    }
    .btn {
      width: 100%;
    }
    .tl {
      margin-top: 40vh;
    }
    .mn {
      text-align: center; /* Centralize o botão de home */
      margin-bottom: 10vh;
    }
    .mn .btn {
      width: auto; /* Remova a largura fixa do botão */
      font-size: 12px; /* Ajuste o tamanho do texto do botão */
      padding: 5px 10px; /* Ajuste o espaço ao redor do botão */
     
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
            <div class="tl container text-center mt-5">
                <h1 class=" mt-5 fw-bold fs-1 mb-5">MENU DE EXCLUSÃO DE DADOS</h1>
                <div class="row">
                    <div class="col-md-6 col-lg-6">
                        <div class="card mt-3 mx-auto">
                            <img src="./imagens/d.png" class="card-img-top w-25 m-auto mt-1"
                                alt="Create img">
                            <div class="card-body">
                                <h5 class="card-title fs-6 fw-bold">Deletar cliente por id</h5>
                                <p class="card-text">
                                    Excluir clientes através do id do cliente informado.<br>
                                </p>
                                <a href="deletarCliente.jsp"
                                    class="btn btn-outline-white btn-primary btn-hover w-50">Ir</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-6">
                        <div class="card mt-3 mx-auto">
                            <img src="./imagens/d.png" class="card-img-top w-25 m-auto mt-1"
                                alt="Delete img">
                            <div class="card-body">
                                <h5 class="card-title fs-6 fw-bold">Deletar post por id</h5>
                                <p class="card-text">
                                    Excluir posts através do id do post.<br>
                                </p>
                                <a href="deletarPost.jsp"
                                    class="btn btn-outline-white btn-primary btn-hover w-50">Ir</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mn">
                <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-dark btn-hover mb-5 mt-3 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
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
