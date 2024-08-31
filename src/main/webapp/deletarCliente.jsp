<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Deletar cliente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
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
				<h3 class="fw-bold mt-4">DELETAR CLIENTE BY ID</h3>
			</div>
			<div class="col-md-6">
				<form id="deleteForm" class="mt-5" action="/SprintFinal/deletarCliente" method="post">
					<div class="mb-3">
						<label for="idCliente" class="form-label fs-4 fw-bold">Id do cliente:</label>
						<input type="text" class="form-control" id="idCliente" name="idCliente" placeholder="ex: CXXX" maxlength="6" required>
					</div>
					<div>
						<button type="submit" class="btn btn-outline-white btn-primary btn-hover mt-3 w-100" data-bs-toggle="modal" onclick="confirmDelete(); return false">DELETAR</button>
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
					Tem certeza de que deseja excluir o cliente com ID <span
						id="clienteIdToDelete"></span>?
				</p>
				<p>
					<strong>Nome:</strong> <span id="clienteNome"></span>
				</p>
				<p>
					<strong>Email:</strong> <span id="clienteEmail"></span>
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

    // Captura o valor do campo "idCliente"
    var idCliente = document.getElementById("idCliente").value;

    // Certifique-se de que o campo não esteja vazio
    if (!idCliente) {
        alert("Informe um ID de cliente válido.");
        return;
    }

    const url = "/SprintFinal/deletarCliente?idCliente=" + idCliente;

    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function(data) {
            console.log("Dados recebidos:", data);

            if (data.nome && data.email) {
                // Preencha o modal de confirmação com os dados do cliente
                document.getElementById('clienteIdToDelete').textContent = idCliente;
                document.getElementById('clienteNome').textContent = data.nome;
                document.getElementById('clienteEmail').textContent = data.email;
                // Abra o modal de confirmação
                $('#confirmCard').modal('show');
            } else {
                alert('Cliente não encontrado ou dados incompletos');
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert('O CLIENTE NÃO EXISTE!');
        }
    });
}

function submitDeleteForm() {
    document.getElementById('deleteForm').submit();
}
</script>

</body>
</html>
