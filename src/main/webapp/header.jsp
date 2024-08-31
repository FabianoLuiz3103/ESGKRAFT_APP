<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" href="./folhas_estilo/home.css">
</head>
<body>

<header class="mx-2 mb-5 p-3">
        <nav class="navbar bg-secondary-subtle fixed-top">
            <div class="container-fluid">
                <div class="d-flex justify-content-between">
                    <div class="navbar-brand">
                        <div class="row">
                            <div class="col-md-2">
                                <div class="mb-3 mt-3">
                                    <!-- Sua imagem -->
                                    <a href="home.jsp">
                                    <img src="./imagens/logo.png" class="card-img h-100 w-100 mx-3" alt="...">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="position-absolute top-0 end-0 " style="margin-right: 3vh;">
                    <button class="navbar-toggler mt-3" style="width:100px; height:50px; margin-left:210px" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
                </div>
                <!-- Restante do seu código para a barra de navegação -->
                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">${sessionScope.nomeFuncionario}</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/SprintFinal/menuPrincipal">Menu inicial</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/SprintFinal/logarCliente">Menu login/cadastro cliente/post</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Leitura de dados
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="dashboards.jsp">Dashboards</a></li>
                                    <li><a class="dropdown-item" href="tabelaCliente.jsp">Tabela de clientes</a></li>
                                    <li><a class="dropdown-item" href="tabelaPosts.jsp">Tabela de posts</a></li>
                                    <li><a class="dropdown-item" href="tabelaClientePost.jsp">Tabela de clientes que tem posts</a></li>
                                </ul>
                            </li>
                             <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                   Atualizar dados
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="updateCliente.jsp">Atualizar clientes</a></li>
                                    <li><a class="dropdown-item" href="updatePost.jsp">Atualizar posts</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Deletar de dados
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="deletarCliente.jsp">Deletar clientes</a></li>
                                    <li><a class="dropdown-item" href="deletarPost.jsp">Deletar posts</a></li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="home.jsp">LOG-OUT</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    </header>

</body>
</html>