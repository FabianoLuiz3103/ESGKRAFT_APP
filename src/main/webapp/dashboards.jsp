<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="icon" href="./imagens/vaiii.png" type="image/x-icon">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
    <!-- Adicione o link para o Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    
    <!-- Adicione uma folha de estilo personalizada, se necessário -->
    <style>
        /* Adicione estilos personalizados aqui, se necessário */
        .custom-center {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 70vh;
            margin-top: 100px;
        }
        .card {
            border: none;
        }
        .grafico-container {
            margin-top: 20px; /* Ajuste a margem superior conforme necessário */
        }
        .grafico {
            max-width: 100%; /* Certifique-se de que o gráfico não ultrapasse o contêiner */
        }
        
        /* Estilos para dispositivos móveis (celulares) */
        @media (max-width: 767px) {
            .grafico-container {
                margin-top: 10px; /* Reduza a margem superior para telas menores */
            }
            .grafico {
                max-width: 100%;
                height: auto; /* Ajuste a altura automaticamente para telas menores */
            }
        }
        
        /* Estilos para telas maiores (computadores) */
        @media (min-width: 768px) {
            .grafico-container {
                margin-top: 10px; /* Ajuste a margem superior para telas maiores */
            }
            .grafico {
                max-width: 80%; /* Defina um tamanho máximo para telas maiores */
                max-height: 50vh; /* Defina uma altura máxima para telas maiores */
            }
        }
    </style>
</head>
<body>

<%@ include file="header.jsp" %>

<main class="d-flex flex-wrap justify-content-center">
    <!-- Coluna grande para computadores e coluna de tamanho completo para dispositivos móveis -->
    <div class="card p-3 container mt-3 col-lg-6 col-12" style="border:none">
        <h3 class="text-center">Idade dos clientes</h3>
        <h6 class="text-center">Quantidade de clientes em cada faixa de idade.</h6>
        <div class="grafico-container">
            <canvas id="graficoIdades" class="grafico"></canvas>
        </div>
    </div>
    <!-- Coluna grande para computadores e coluna de tamanho completo para dispositivos móveis -->
    <div class="card p-3 container mt-3 col-lg-6 col-12" style="border:none">
        <h3 class="text-center">Tipos ESG</h3>
        <h6 class="text-center">Quantidade de posts em cada tipo/letra da sigla.</h6>
        <div class="grafico-container">
            <canvas id="graficoESG" class="grafico"></canvas>
        </div>
    </div>
</main>
<div class="d-flex flex-column align-items-center mt-3">
    <a href="/SprintFinal/menuPrincipal" class="btn btn-outline-white btn-dark btn-hover mt-4 mb-5 mx-3" style="width: 30vh; font-size:10px;"><i class="fa fa-home"></i></a>
</div>

<%@ include file="footer.jsp" %>

<!-- Adicione o Bootstrap JS no final do corpo para melhor desempenho -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src="./js/dash.js"></script>
</body>
</html>
