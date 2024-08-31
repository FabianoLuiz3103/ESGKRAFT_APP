document.addEventListener("DOMContentLoaded", function () {
    const tableBody = document.querySelector("tbody");
   
    $.ajax({
        url: "tablePost", 
        method: "GET",
        dataType: "json",
        success: function (data) {
            tableBody.innerHTML = "";

            data.forEach(function (post) {
                const row = document.createElement("tr");
                const backgroundColorClass = getBackgroundColorClass(post.tipoESG);
                row.innerHTML = `
                    <td class="fw-bold" scope="row">${post.idPost}</td>
                    <td>${post.mensagem}</td>
                    <td>${post.tipoESG}</td>
                `;
                row.classList.add(backgroundColorClass); // Adiciona a classe de fundo à linha
                tableBody.appendChild(row);

                row.addEventListener("click", () => {
                    const rowData = row.children;
                    const idPost = rowData[0].textContent;
                    const mensagem = rowData[1].textContent;
                    const tipoESG = rowData[2].textContent;
                    const data = post.dataPostagem;
                    const responsavel = post.idCliente;
                    const selecao = post.idSelecao;

                    customerIdPost.innerHTML = `<strong>Id:</strong> ${idPost}`;
                    customerMensagem.innerHTML = `<strong>Mensagem:</strong> ${mensagem}`;
                    customerTipo.innerHTML = `<strong>Tipo ESG:</strong> ${tipoESG}`;
                    customerData.innerHTML = `<strong>Data de postagem:</strong> ${data}`;
                    customerResponsavel.innerHTML = `<strong>Id do responsavel pela postagem:</strong> ${responsavel}`;
                    customerSelecao.innerHTML = `<strong>Selecao em que foi salvo no banco:</strong> ${selecao}`;

                     document.getElementById("corpoCard").classList.remove('bg-success-subtle', 'bg-warning-subtle', 'bg-primary-subtle');

                    document.getElementById("corpoCard").classList.add(getBackgroundColor(tipoESG));

                    document.getElementById("customerInfoCard").classList.add("hidden");
                    document.getElementById("postDetailsCard").classList.remove("hidden");
                });
            });
        },
        error: function (error) {
            console.error("Erro ao buscar dados: " + error);
        }
    });

    function getBackgroundColorClass(tipoESG) {
        switch (tipoESG) {
            case 'E':
                return 'table-success'; 
            case 'S':
                return 'table-warning'; 
            case 'G':
                return 'table-primary';
            default:
                return ''; 
        }
    }
    
    
     function getBackgroundColor(tipoESG) {
        switch (tipoESG) {
            case 'E':
                return 'bg-success-subtle'; 
            case 'S':
                return 'bg-warning-subtle'; 
            case 'G':
                return 'bg-primary-subtle'; 
            default:
                return '';
        }
    }
    
    document.getElementById('download-pdf').addEventListener('click', function () {
                var tableData = [];

                var rows = document.querySelectorAll("table tbody tr");
                rows.forEach(function (row) {
                    var rowData = [];
                    var cells = row.querySelectorAll("td");
                    cells.forEach(function (cell) {
                        rowData.push(cell.textContent);
                    });
                    tableData.push(rowData);
                });

                var docDefinition = {
                    content: [
                        { text: 'Tabela de post em PDF', style: 'header' },
                        {
                            table: {
                                body: [
                                    ['Id Post', 'Mensagem', 'Tipo ESG'],
                                    ...tableData
                                ]
                            }
                        }
                    ],
                    styles: {
                        header: {
                            fontSize: 18,
                            bold: true
                        }
                    }
                };

                pdfMake.createPdf(docDefinition).download('tabelaPost.pdf');
            });
});
