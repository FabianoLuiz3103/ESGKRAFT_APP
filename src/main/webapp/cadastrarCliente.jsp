<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastrar cliente</title>
<link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="custom-center">
		<div
			class="container text-center mt-5 rounded border border-4 border-dark bg-secondary custom-border custom-center"
			style="height: 70vh">
			<div class="row d-flex justify-content-center w-100">
				<div class="d-flex flex-column align-items-center">
					<h3 class="fw-bold mt-4">CADASTRO DE CLIENTE</h3>
					
				</div>
				<div class="col-md-6">
					<form class="mt-3" action="/SprintFinal/novoCliente" method="post">
						<div class="mb-3">
							<div class="d-flex">
								<label for="nome" class="form-label m-auto p-2 fw-bold">NOME:</label>
								<input type="text" class="form-control w-75" id="nome"
									name="nome" maxlength="50" placeholder="Nome completo" required>
							</div>
						</div>
						<div class="mb-3">
							<div class="d-flex">
								<label for="idade" class="form-label m-auto p-2 fw-bold">IDADE:</label>
								<input type="text" class="form-control w-75" id="idade"
									name="idade" maxlength="2" placeholder="ex: XX (Maior que 18)"
									required>
							</div>
							<%
							String mensagemErroIdade = (String) request.getAttribute("mensagemErroIdade");
							if (mensagemErroIdade != null) {
							%>
							<p class="mx-5 text-danger mt-1 fw-bold" style="font-size: 10px;"><%=mensagemErroIdade%></p>
							<%
							}
							%>
						</div>
						<div class="mb-3">
							<div class="d-flex">
								<label for="email" class="form-label m-auto p-2 fw-bold">EMAIL:</label>
								<input type="email" class="form-control w-75" id="email"
									name="email" aria-describedby="emailHelp" maxlength="50"
									placeholder="ex: email@example.com" required>
							</div>
							<%
							String mensagemErroEmail = (String) request.getAttribute("mensagemErroEmail");
							if (mensagemErroEmail != null) {
							%>
							<p class="text-danger mt-1 fw-bold" style="font-size: 10px;"><%=mensagemErroEmail%></p>
							<%
							}
							%>
						</div>
						<div class="mb-3">
							<div class="d-flex">
								<label for="telefone" class="form-label m-auto p-2 fw-bold">TELEFONE:</label>
								<input type="text" class="form-control w-75" id="telefone"
									name="telefone" maxlength="15" placeholder="ex: (xx)01234-4567"
									required>
							</div>
							<%
							String mensagemErroTelefone = (String) request.getAttribute("mensagemErroTelefone");
							if (mensagemErroTelefone != null) {
							%>
							<p class="mx-5 text-danger mt-1 fw-bold" style="font-size: 10px;"><%=mensagemErroTelefone%></p>
							<%
							}
							%>
						</div>
						<div class="d-flex">
							<button type="submit"
								class="btn btn-outline-white btn-primary btn-hover w-50 mt-1 mb-1 mx-5" data-bs-toggle="modal" data-bs-target="#successModal" onclick="return cadastroValid();">CADASTRAR</button>
							<button type="reset"
								class="btn btn-outline-white btn-primary btn-hover w-50 mt-1 mb-1 mx-3">LIMPAR</button>
						</div>
						 <div class="d-flex flex-column align-items-center">
             
                            <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-primary btn-hover mt-2 mb-3 mx-3" style="width: 20vh; font-size:10px;"><i class="fa fa-home"></i></a>
                        </div>
					</form>

				</div>

			</div>

		</div>
	</div>

	<br>
<%@ include file="footer.jsp" %>


 
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
		


</body>
</html>