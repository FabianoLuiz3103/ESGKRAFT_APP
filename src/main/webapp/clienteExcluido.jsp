<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.fiap.redeSocial.Cliente" %>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cliente Excluido!</title>
<link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
  /* Estilos para dispositivos móveis */
  @media (max-width: 768px) {
    .container {
      padding: 0;
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

	<%@ include file="header.jsp"%>

	<div class="custom-center">
		<div class="container text-center mt-5 rounded border border-4 border-dark bg-secondary custom-border custom-center h-75">
			<div class="row d-flex justify-content-center">
				<div class="div-container mb-2">
					<img class="img img-top blinking-image mt-5 mb-1"
						src="./imagens/success-removebg-preview.png" alt="">
				</div>
				<%
				Cliente clienteExcluido = (Cliente) request.getAttribute("clienteExcluido");
				Boolean operacaoSucesso = (Boolean) request.getAttribute("operacaoSucesso");
				if (clienteExcluido != null && operacaoSucesso != null && operacaoSucesso) {
				%>
				<div class="alert alert-success">
					<p>
						Cliente
						<%=clienteExcluido.getIdCliente()%>
						foi excluído com sucesso!
					</p>
					<p>
						Nome:
						<%=clienteExcluido.getNome()%></p>
					<p>
						Email:
						<%=clienteExcluido.getEmail()%></p>
					<p>
						Telefone:
						<%=clienteExcluido.getTelefone()%></p>
				</div>
				<%
				}
				%>
				<div class="mb-5 d-flex justify-content-evenly">
					<a href="deletarCliente.jsp" class="btn btn-outline-white btn-primary btn-hover mb-4 mx-3">EXCLUIR MAIS CLIENTE</a>
					<a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-primary btn-hover mb-4 mx-3" style="font-size:12px; width:20vh;"><i class="fa fa-home"></i></a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>
