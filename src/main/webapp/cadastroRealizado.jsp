<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.fiap.redeSocial.Cliente" %>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Cliente realizado com sucesso! </title>
    <link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
</head>
<body>

    <%@ include file="header.jsp" %>

<div class="custom-center">
		<div
			class="container text-center mt-5 rounded border border-4 border-dark bg-secondary custom-border custom-center h-75">
			<div class="row d-flex justify-content-center w-100">
				<div class="div-container">
					<img class="img img-top blinking-image mt-5"
						src="./imagens/success-removebg-preview.png" alt="">
				</div>
					<%
					String idGerado = (String)request.getAttribute("idGerado");
					Cliente cliente = (Cliente) request.getAttribute("clienteCadastrado");
					Boolean operacaoSucesso = (Boolean) request.getAttribute("operacaoSucesso");
					if (cliente != null && operacaoSucesso != null && operacaoSucesso) {
					%>
					<div class="alert alert-success mt-1" style="height: 38vh;">
					    <p>
						     <span class="fw-bold">Cliente:</span><br>
							<span class="fw-bold">Id do clienre:</span> <%=idGerado%></p>
						<p>
						<p>
							<span class="fw-bold">Nome:</span> <%=cliente.getNome()%></p>
							
						<p>
							<span class="fw-bold">Email:</span> <%=cliente.getEmail()%></p>
							
						<p>
							<span class="fw-bold">Telefone:</span> <%=cliente.getTelefone()%></p>
							
						<p class="fw-bold text-success">CADASTRADO COM SUCESSO!!
							</p>
					</div>
					<div  class="d-flex justify-content-evenly" style="margin-bottom: 15vh;">
					     
					     	<a href="/SprintFinal/menuPrincipal"><button name="irMenu" type="button"
							class="btn btn-outline-white btn-primary btn-hover w-100">IR PARA O MENU</button></a>
							
						<a href="logarCliente?idCliente=<%=idGerado%>"><button name="irLogin" type="button"
							class="btn btn-outline-white btn-primary btn-hover w-100">IR PARA LOGIN</button></a>
		
				</div>
					<%
					}
					%>
				
			</div>

		</div>

	</div>

  <%@ include file="footer.jsp" %>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>