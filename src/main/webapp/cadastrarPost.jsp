<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar post</title>
    <link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
    <!-- Adicione o link para o Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    
    <!-- Adicione uma folha de estilo personalizada, se necessário -->
    <style>
        /* Adicione estilos personalizados aqui, se necessário */
        .custom-post {
            min-height: 50vh; /* Ajuste a altura conforme necessário */
        }
        .footer {
            margin-top: 20px; /* Adicione margem superior ao footer */
        }
    </style>
</head>
<body>

    <%@ include file="header.jsp" %>

    <!-- Utilize a classe container do Bootstrap para envolver o conteúdo -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="bg-secondary p-4 rounded border border-4 border-dark custom-post" style="margin-top: 25px;">
                    <div class="text-center">
                        <h3 class="fw-bold mt-4">CADASTRO DE POST</h3>
                    </div>
                    <form class="mt-1" action="/SprintFinal/novoPost" method="post">
                        <!-- Remova o uso do estilo inline e use classes Bootstrap -->
                        <div class="mb-3">
                            <label for="mensagem" class="form-label fw-bold">MENSAGEM:</label>
                            <textarea class="form-control mt-3" name="mensagem" id="mensagem" rows="4" cols="50" maxlength="300" required placeholder="Mensagem presente no post"></textarea>
                        </div>
                        <div class="input-group mb-3">
                            <label class="input-group-text fw-bold" for="tipoESG">TIPO ESG:</label>
                            <select class="form-select" id="tipoESG" name="tipoESG" required>
                                <option selected>ESCOLHA...</option>
                                <option value="E">E</option>
                                <option value="S">S</option>
                                <option value="G">G</option>
                            </select>
                        </div>
                        <div class="d-flex justify-content-evenly">
                            <button type="submit" name="finalizar" class="btn btn-primary btn-hover w-48 mt-2 mb-1 mx-3">SALVAR</button>
                            <button type="reset" class="btn btn-primary btn-hover w-48 mt-2 mb-1 mx-3">LIMPAR</button>
                        </div>
                        <div class="d-flex flex-column align-items-center mt-3">
                            <a href="/SprintFinal/menuPrincipal" class="btn btn-primary btn-hover" style="width: 20vh; font-size: 10px;"><i class="fa fa-home"></i></a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>

    <!-- Adicione o Bootstrap JS no final do corpo para melhor desempenho -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
