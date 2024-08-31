document.addEventListener("DOMContentLoaded", function() {
    function atualizarGrafico() {
        fetch('filter')
        .then(response => response.json())
        .then(data => {
            var idades = data;
            function calcularFrequencias(idades) {
                var frequencias = [0, 0, 0]; 
                idades.forEach(function(idade) {
                    if (idade >= 18 && idade <= 30) {
                        frequencias[0]++;
                    } else if (idade >= 31 && idade <= 45) {
                        frequencias[1]++;
                    } else {
                        frequencias[2]++;
                    }
                });

                return frequencias;
            }
            var labels = ["18-30", "31-45", "46+"];
            var cores = ["#FF6384", "#36A2EB", "#FFCE56"];
            var ctx = document.getElementById("graficoIdades").getContext("2d");
            var frequencias = calcularFrequencias(idades);

            var myPieChart = new Chart(ctx, {
                type: "pie",
                data: {
                    labels: labels,
                    datasets: [{
                        data: frequencias,
                        backgroundColor: cores
                    }]
                },
                options: {
                    responsive: true
                }
            });
        })
        .catch(error => {
            console.error('Erro ao buscar dados JSON:', error);
        });
    }
    atualizarGrafico();
});

document.addEventListener("DOMContentLoaded", function() {
    function atualizarGraficoDois() {
        fetch('filterDois')
        .then(response => response.json())
        .then(data => {
            var dados = data;
            var labels = ["E", "S", "G"];
            var cores = ["#FF6384", "#36A2EB", "#FFCE56"];
            var ctx = document.getElementById("graficoESG").getContext("2d");

            var myBarChart = new Chart(ctx, {
                type: "bar",
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Quantidade de Tipos',
                        data: dados,
                        backgroundColor: cores
                        
                    }]
                    
                },
                options: {
                    responsive: true,
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        })
        .catch(error => {
            console.error('Erro ao buscar dados JSON para o gráfico dois:', error);
        });
    }
    atualizarGraficoDois();
});

