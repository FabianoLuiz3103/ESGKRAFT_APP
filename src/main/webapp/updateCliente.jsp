<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edi��o de Cliente</title>
<link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

    <!-- Cabe�alho -->
    <%@ include file="header.jsp" %>

    <div class="custom-center">
        <div class="mt-2 container text-center rounded border border-4 border-dark bg-secondary custom-border custom-center" style="height: 68vh">
            <div class="row d-flex justify-content-center w-100">
                <div class="d-flex flex-column align-items-center">
					<h3 class="fw-bold mt-3">EDI��O DE DADOS DO CLIENTE</h3>
					
				</div>
                <div class="col-md-6">
                    <!-- Formul�rio de Login -->
                    <form id="loginForm" class="mt-5" action="/SprintFinal/atualizarCliente" method="post">
                        <div class="mb-3">
                            <label for="idCliente" class="form-label fs-4 fw-bold">Id do cliente:</label>
                            <input type="text" class="form-control" id="idCliente" name="idCliente" placeholder="ex: CXXX" maxlength="6" required>
                        </div>
                        <div class="d-flex flex-column align-items-center">
                            <button type="button" class="btn btn-outline-white btn-primary btn-hover w-50" onclick="updateCliente();">EDITAR</button>
                            <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-primary btn-hover mt-2 mb-3 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
                        </div>
                    </form>

                    <!-- Dados do Cliente (Inicialmente Ocultos) -->
                    <div class="alert alert-success" id="dadosCliente" style="display: none; height: 40vh">
                        <h4 class="mt-4">Dados do Cliente:</h4>
                        <p><strong>Nome:</strong> <span id="nomeCliente">Nome do Cliente</span></p>
                        <p><strong>Idade:</strong> <span id="idadeCliente">Idade do Cliente</span></p>
                        <p><strong>Email:</strong> <span id="emailCliente">cliente@example.com</span></p>
                        <p><strong>Telefone:</strong> <span id="telefoneCliente">Telefone do Cliente</span></p>

                        <!-- Bot�o para Editar Dados -->
                        <button type="button" class="btn btn-outline-white btn-primary btn-hover mb-5 mt-2" data-bs-toggle="modal" data-bs-target="#clienteModal">
                            Editar Dados
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>margin

    <!-- Modal de Edi��o de Dados do Cliente -->
    <div class="modal fade" id="clienteModal" tabindex="-1" aria-labelledby="clienteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="clienteModalLabel">Editar Dados do Cliente</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fechar"></button>
                </div>
                <div class="modal-body">
                    <!-- Formul�rio de Edi��o de Dados -->
                    <form id="editarClienteForm" action="/SprintFinal/validarUpdate" method="post">
                        <div class="mb-3">
                            <label for="nomeClienteEdit" class="form-label">Nome:</label>
                            <input type="text" class="form-control" id="nomeClienteEdit" name="nomeCliente" maxlength="50" required>
                        </div>
                        <div class="mb-3">
    <label for="idadeClienteEdit" class="form-label">Idade:</label>
    <input type="text" class="form-control" id="idadeClienteEdit" name="idadeCliente" maxlength="50" required>
    <p id="mensagemErroIdade" class="text-danger mt-1 fw-bold" style="font-size: 10px;"></p>
</div>
<div class="mb-3">
    <label for="emailClienteEdit" class="form-label">Email:</label>
    <input type="email" class="form-control" id="emailClienteEdit" name="emailCliente" maxlength="50" required>
    <p id="mensagemErroEmail" class="text-danger mt-1 fw-bold" style="font-size: 10px;"></p>
</div>
<div class="mb-3">
    <label for="telefoneClienteEdit" class="form-label">Telefone:</label>
    <input type="tel" class="form-control" id="telefoneClienteEdit" name="telefoneCliente" maxlength="15" required>
    <p id="mensagemErroTelefone" class="text-danger mt-1 fw-bold" style="font-size: 10px;"></p>
</div>
                       
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                            <button type="submit" class="btn btn-primary" onclick="return updateValid();">Salvar Altera��es</button>                
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Rodap� -->
    <%@ include file="footer.jsp" %>
    
    

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>

    <script>
	var nome;
    var idade;
    var email;
    var telefone;
	
    function updateCliente() {
       
        var idCliente = document.getElementById("idCliente").value.toUpperCase();

      
        if (!idCliente) {
            return true;
        }

        const url = "/SprintFinal/atualizarCliente?idCliente=" + idCliente;

        $.ajax({
            type: 'GET',
            url: url,
            dataType: 'json',
            success: function(data) {
                console.log("Dados recebidos:", data);

                if (data.idCliente === idCliente) {
                	
                	 nome = data.nome;
                     idade = data.idade;
                     email = data.email;
                     telefone = data.telefone;
                	
                    document.getElementById("nomeCliente").textContent = data.nome;
                    document.getElementById("idadeCliente").textContent = data.idade;
                    document.getElementById("emailCliente").textContent = data.email;
                    document.getElementById("telefoneCliente").textContent = data.telefone;

                    document.getElementById("nomeClienteEdit").value = data.nome;
                    document.getElementById("idadeClienteEdit").value = data.idade;
                    document.getElementById("emailClienteEdit").value = data.email;
                    document.getElementById("telefoneClienteEdit").value = data.telefone;

                    document.getElementById("dadosCliente").style.display = "block";
                    document.getElementById("loginForm").style.display = "none";
                    
                 
                    localStorage.setItem('nome', nome);
                    localStorage.setItem('idade', idade);
                    localStorage.setItem('email', email);
                    localStorage.setItem('telefone', telefone);
                } else {
                    
           
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('O CLIENTE N�O EXISTE!');
            }
        });
       
    }
    
    function updateValid() {
        document.getElementById("mensagemErroIdade").innerHTML = "";
        document.getElementById("mensagemErroEmail").innerHTML = "";
        document.getElementById("mensagemErroTelefone").innerHTML = "";

        
        var idCliente = document.getElementById("idCliente").value.toUpperCase();

        
        if (!idCliente) {
            return true; 
        }

        const url = "/SprintFinal/validarUpdate?idCliente=" + idCliente;

        $.ajax({
            type: 'GET',
            url: url,
            dataType: 'json',
            success: function(data) {
                console.log("Dados recebidos:", data);

            },
            error: function(jqXHR, textStatus, errorThrown) {
                $('#clienteModal').modal('show');
            }
        });
    }

    
    document.addEventListener("DOMContentLoaded", function() {
    	const urlParams = new URLSearchParams(window.location.search);
        if (urlParams.has('error')) {
            console.log('Erro detectado na URL. Tentando abrir o modal.');
            
            var nome = localStorage.getItem('nome');
            var idade = localStorage.getItem('idade');
            var email = localStorage.getItem('email');
            var telefone = localStorage.getItem('telefone');
            
            document.getElementById("nomeClienteEdit").value = nome;
            document.getElementById("idadeClienteEdit").value = idade;
            document.getElementById("emailClienteEdit").value = email;
            document.getElementById("telefoneClienteEdit").value = telefone;
            
            if(urlParams.has('errorIdade')){
            	document.getElementById("mensagemErroIdade").textContent = "IDADE INV�LIDA, O CLIENTE DEVE SER MAIOR DE 18 ANOS!";
            	  document.getElementById("idadeClienteEdit").value = "";
            }
            if(urlParams.has('errorEmail')){
            	document.getElementById("mensagemErroEmail").textContent = "EMAIL INV�LIDO, O EMAIL J� EST� EM USO POR OUTRO USU�RIO! ";
            	 document.getElementById("emailClienteEdit").value = "";
            }
            if(urlParams.has('errorTelefone')){
            	document.getElementById("mensagemErroTelefone").textContent = "TELEFONE INV�LIDO, O TELEFONE J� EST� EM USO POR OUTRO USU�RIO!";
            	document.getElementById("telefoneClienteEdit").value = "";
            }
            
            $('#clienteModal').modal('show');
        } else {
            console.log('Nenhum erro na URL.');
        }
    });


    </script>
</body>
</html>
    