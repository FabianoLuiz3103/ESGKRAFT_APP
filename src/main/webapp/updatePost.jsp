<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edição de Post</title>
<link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

    <!-- Cabeçalho -->
    <%@ include file="header.jsp" %>

    <div class="custom-center">
        <div class="mt-5 container text-center rounded border border-4 border-dark bg-secondary custom-border custom-center h-75">
            <div class="row d-flex justify-content-center w-100">
                <div class="d-flex flex-column align-items-center">
					<h3 class="fw-bold mt-4">EDIÇÃO DE DADOS DO POST</h3>
					
				</div>
                <div class="col-md-6">
                    <!-- Formulário de Login -->
                    <form id="loginForm" class="mt-5" action="/SprintFinal/atualizarPost" method="post">
                        <div class="mb-3">
                            <label for="idPost" class="form-label fs-4 fw-bold">Id do post:</label>
                            <input type="text" class="form-control" id="idPost" name="idPost" placeholder="ex: PXXX" maxlength="6" required>
                        </div>
                        <div class="d-flex flex-column align-items-center">
                            <button type="button" class="btn btn-outline-white btn-primary btn-hover w-50" onclick="updatePost();">EDITAR</button>
                            <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-primary btn-hover mt-3 mb-5 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
                        </div>
                    </form>

                    <!-- Dados do Cliente (Inicialmente Ocultos) -->
                    <div class="alert alert-success" id="dadosPost" style="display: none;">
                        <h4 class="mt-4">Dados do Post:</h4>
                        <p><strong>Mensagem:</strong> <span id="mensagemPost">Mensagem do post</span></p>
                        <p><strong>Tipo ESG:</strong> <span id="tipoESGPost">Tipo do post</span></p>
                        <p><strong>Id do responsável:</strong> <span id="idResponsavelPost">Id do responsável</span></p>
             

                        <!-- Botão para Editar Dados -->
                        <button type="button" class="btn btn-outline-white btn-primary btn-hover" data-bs-toggle="modal" data-bs-target="#postModal">
                            Editar Dados
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal de Edição de Dados do Cliente -->
    <div class="modal fade" id="postModal" tabindex="-1" aria-labelledby="postModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="postModalLabel">Editar Dados do Post</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fechar"></button>
                </div>
                <div class="modal-body">
                    <!-- Formulário de Edição de Dados -->
                    <form id="editarClienteForm" action="/SprintFinal/validarUpdatePost" method="post">
                        <div class="mb-3">
                            <label for="mensagemPostEdit" class="form-label">Mensagem:</label>
                            <textarea class="form-control mt-3" name="mensagemPost" id="mensagemPostEdit" rows="4" cols="50" maxlength="300" required placeholder="Mensagem presente no post"></textarea>
                        </div>
                        <div class="input-group mb-3">
							<label class="input-group-text fw-bold" for="tipoESG">TIPO ESG:</label>
							<select class="form-select" id="tipoESGEdit" name="tipoESG">
								<option selected>ESCOLHA...</option>
								<option value="E">E</option>
								<option value="S">S</option>
								<option value="G">G</option>
							</select>
						</div>
                       
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                            <button type="submit" class="btn btn-primary" onclick="return updateValid();">Salvar Alterações</button>                
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Rodapé -->
    <%@ include file="footer.jsp" %>
    
    

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>

    <script>
	var mensagem;
    var tipoESG;
    var idResponsavel;
   
	
    function updatePost() {
        // Remova qualquer mensagem de erro anterior
       

        // Captura o valor do campo "idCliente"
        var idPost = document.getElementById("idPost").value.toUpperCase();

        // Certifique-se de que o campo não esteja vazio
        if (!idPost) {
            return true; // Permite o envio do formulário
        }

        const url = "/SprintFinal/atualizarPost?idPost=" + idPost;

        $.ajax({
            type: 'GET',
            url: url,
            dataType: 'json',
            success: function(data) {
                console.log("Dados recebidos:", data);

                if (data.idPost === idPost) {
                	
                	 mensagem = data.mensagem;
                     tipoESG = data.tipoESG;
                     idResponsavel = data.idResponsavel;
                    
                	
                    document.getElementById("mensagemPost").textContent = data.mensagem;
                    document.getElementById("tipoESGPost").textContent = data.tipoESG;
                    document.getElementById("idResponsavelPost").textContent = data.idResponsavel;
                   

                    document.getElementById("mensagemPostEdit").value = data.mensagem;
                    document.getElementById("tipoESGEdit").value = data.tipoESG;
                    

                    document.getElementById("dadosPost").style.display = "block";
                    document.getElementById("loginForm").style.display = "none";
                    
                 // Armazena os valores em localStorage
                    localStorage.setItem('mensagem', mensagem);
                    localStorage.setItem('tipoESG', tipoESG);
                    localStorage.setItem('idResponsavel', idResponsavel);
                } else {
                    // Exibir mensagens de erro abaixo dos campos inválidos no modal
           
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('O POST NÃO EXISTE!');
            }
        });
    }
    
    function updateValid() {
      
    	 var idPost = document.getElementById("idPost").value.toUpperCase();
    	    var tipoESG = document.getElementById("tipoESGEdit").value; // Obtém o valor selecionado

    	    if (!idPost) {
    	        return true;
    	    }

    	    const url = "/SprintFinal/validarUpdatePost?idPost=" + idPost + "&tipoESG=" + tipoESG; // Inclui o valor selecionado na URL

        $.ajax({
            type: 'GET',
            url: url,
            dataType: 'json',
            success: function(data) {
                console.log("Dados recebidos:", data);

            },
            error: function(jqXHR, textStatus, errorThrown) {
                $('#postModal').modal('show');
            }
        });
    }
    
    </script>
</body>
</html>
