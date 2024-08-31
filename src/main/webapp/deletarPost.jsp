<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Deletar post</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" href="./folhas_estilo/home.css">
<link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="custom-center">
		<div
			class="mt-5 container text-center rounded border border-4 border-dark bg-secondary custom-border custom-center h-75">
			<div class="row d-flex justify-content-center w-100">
				<div class="d-flex flex-column align-items-center">
					<h3 class="fw-bold mt-4">DELETAR POST BY ID</h3>
				</div>
				<div class="col-md-6">
					<form id="deleteForm" class="mt-5" action="/SprintFinal/deletarPost" method="post">
    	<div class="mb-3">
        <label for="idPost" class="form-label fs-4 fw-bold">Id do post:</label>
        <input type="text" class="form-control" id="idPost" name="idPost" placeholder="ex: PXXX" maxlength="6" required>
    	</div>
   			 <div>
        <button type="submit" class="btn btn-outline-white btn-primary btn-hover w-50" data-bs-toggle="modal"  onclick="return confirmDelete();">DELETAR</button>
    	</div>
    		 <div class="d-flex flex-column align-items-center">
             
                            <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-primary btn-hover mt-2 mb-3 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
                        </div>
				</form>
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

	<!-- Card de confirmação -->
	<div id="confirmCard" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Confirmação de Exclusão</h5>
					<button type="submit" class="btn-close" data-bs-dismiss="modal"
						aria-label="Fechar"></button>
				</div>
				<div class="modal-body">
					<p>
						Tem certeza de que deseja excluir o Post com ID <span
							id="postIdToDelete"></span>?
					</p>
					<p>
						<strong>Mensagem:</strong> <span id="mensagem"></span>
					</p>
					<p>
						<strong>Tipo ESG:</strong> <span id="tipoESG"></span>
					</p>
					<p>
						<strong>Cliente responsável:</strong> <span id="clienteResponsavel"></span>
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-danger"
						onclick="submitDeleteForm()">Confirmar Exclusão</button>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>

<script>
function confirmDelete() {
    event.preventDefault();
    var idPost = document.getElementById("idPost").value;

    if (!idPost) {
        alert("Informe um ID de post válido.");
        return;
    }
    
    

    const url = "/SprintFinal/deletarPost?idPost=" + idPost;

    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function(data) {
            console.log("Dados recebidos:", data);

            if (data.mensagem && data.tipoESG && data.idResponsavel) {
                // Preencha o modal de confirmação com os dados do cliente
                document.getElementById('postIdToDelete').textContent = idPost;
                document.getElementById('mensagem').textContent = data.mensagem;
                document.getElementById('tipoESG').textContent = data.tipoESG;
                document.getElementById('clienteResponsavel').textContent = data.idResponsavel;
                // Abra o modal de confirmação
                $('#confirmCard').modal('show');
            } else {
                alert('Post não encontrado ou dados incompletos');
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert('O POST NÃO EXISTE!');
            
        }
        
    });
    
}


function submitDeleteForm() {
    document.getElementById('deleteForm').submit();
}
</script>

</body>
</html>
