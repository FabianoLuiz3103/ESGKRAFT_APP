
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tabela Clientes e posts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        /* Estilos para dispositivos móveis */
        @media (max-width: 768px) {
            .btn-group {
                flex-direction: column;
            }
            .btn {
                width: 100%;
                margin: 5px 0;
            }
            .mt-5 {
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
    

 
    
    <div class="container d-flex">
    <div class="row w-100">
    <div class="col-md-10">
     <h3 class="mt-5">TABELA DE CLIENTES QUE TEM POSTS CADASTRADOS</h3>
    </div>
    <div class="col-md-2 mt-5">
          <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-dark btn-hover mb-1 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
                   
    </div>
    </div>
    </div>
    <main class="container mt-5">
        <div class="row">

            <div class="col-md-4 me-md-4 mt-3 ms-3" style="width: 50vh;">
            
                 <div id="customerInfoCard" class="card bg-secondary-subtle">
                    <div class="text-center mt-3">
                        <p class="fw-bold blinking-text">Clique em uma linha da tabela de clientes para ver os detalhes.</p>
                    </div>
                </div>
                
            
                <div id="clienteDetailsCard" class="card hidden">
                    <div class="text-center mt-3">
                        <img id="customerImage" src="./imagens/userSemFoto.png" alt="Usuário sem foto" class="w-50 h-auto rounded-circle m-auto" style="display: none;">
                    </div>
                    <div class="card-body">
                        <h5 class="card-title ">Informações do Cliente</h5>
                        <p id="customerId" class="card-text"></p>
                        <p id="customerNome" class="card-text"></p>
                        <p id="customerIdade" class="card-text"></p>
                        <p id="customerEmail" class="card-text"></p>
                        <p id="customerTelefone" class="card-text"></p>
                        <p id="custumerDataCadastro" class="card-text"></p>
                    </div>
                </div>
                
            </div>
            
            <div class="col-md-4 col-lg-4 ms-md-5 mt-3 ms-3" style="width: 50vh;">
                
                 <div id="customerInfoCard" class="card bg-secondary-subtle">
                    <div class="text-center mt-3">
                        <p class="fw-bold blinking-text">Clique em uma linha da tabela para ver os detalhes do post.</p>
    
                    </div>
                </div>

                
                <div id="postDetailsCard" class="card hidden">
                    <div class="card-body" id="corpoCard">
                        <h5 class="card-title mt-3">Informações do Post</h5>
                        <p id="customerIdPost" class="card-text"></p>
                        <p id="customerMensagem" class="card-text"></p>
                        <p id="customerTipo" class="card-text"></p>
                        <p id="customerData" class="card-text"></p>
                        <p id="customerResponsavel" class="card-text"></p>
                        <p id="customerSelecao" class="card-text"></p>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4 me-md-4 mb-5">
            <h3 class="mb-4 mt-5 ms-5">TABELA DE CLIENTES</h3>
                <div class="table-container ms-3">

                    <table id="customerTable" class="table table-hover table-striped-columns">
                        <thead class="text-center">
                            <tr>
                                <th scope="col">Id Cliente</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Idade</th>
                            </tr>
                        </thead>
                        <tbody class="text-center">
                        </tbody>
                    </table>
                    
                    <h3 class="mb-4 mt-5 ms-4">TABELA DE POSTS</h3>
                    <table id="postTable" class="table table-hover table-striped-columns hidden">
                        <thead class="text-center">
                            <tr>
                                <th scope="col" style="width:12vh">Id Post</th>
                                <th scope="col">Mensagem</th>
                                <th scope="col" style="width:15vh">Tipo ESG</th>
                            </tr>
                        </thead>
                        <tbody class="text-center">
                        </tbody>
                    </table>

                </div>
                
            </div>
        </div>
    </main>
     <div class="mb-5 d-flex justify-content-center">
    <button class="mb-5 btn btn-outline-white btn-dark btn-hover" id="download-pdf">Baixar PDF</button>
    
    </div>
    
    <%@ include file="footer.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.70/pdfmake.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.70/vfs_fonts.js"></script>
    <script src="./js/tableClientePosts.js"></script>
</body>
</html>
