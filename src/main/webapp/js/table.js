
document.addEventListener("DOMContentLoaded", function () {
    const tableBody = document.querySelector("tbody");

    
    $.ajax({
        url: "tableCliente", 
        method: "GET",
        dataType: "json",
        success: function (data) {
          
            tableBody.innerHTML = "";

           
            data.forEach(function (cliente) {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td class="fw-bold" scope="row">${cliente.idCliente}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.idade}</td>
                `;
                tableBody.appendChild(row);

                
                row.addEventListener("click", () => {
     
                    const rowData = row.children;
                    const idCliente = rowData[0].innerHTML;
                    idc = rowData[0].innerHTML;
                    const nomeCliente = rowData[1].innerHTML;
                    const idadeCliente = rowData[2].innerHTML;
                    const emailCliente = cliente.email;
                    const telefoneCliente = cliente.telefone;
                    const dataCadastro = cliente.dataCadastro;

                    customerId.innerHTML = `<strong>Id:</strong> ${idCliente}`;
                    customerNome.innerHTML = `<strong>Nome:</strong> ${nomeCliente}`;
                    customerIdade.innerHTML = `<strong>Idade:</strong> ${idadeCliente}`;
                    customerEmail.innerHTML = `<strong>Email:</strong> ${emailCliente}`;
                    customerTelefone.innerHTML = `<strong>Telefone:</strong> ${telefoneCliente}`;
                   custumerDataCadastro.innerHTML = `<strong>Data de cadastro:</strong> ${dataCadastro}`;
                    
                     document.getElementById("customerInfoCard").classList.add("hidden");
                    document.getElementById("customerImage").style.display = "block";
                    document.getElementById("clienteDetailsCard").classList.remove("hidden");
                });
            });
        },
        error: function (error) {
            console.error("Erro ao buscar dados: " + error);
        }
    });
    
    
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
                        { text: 'Tabela de clientes em PDF', style: 'header' },
                        {
                            table: {
                                body: [
                                    ['Id Cliente', 'Nome', 'Idade'],
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

                pdfMake.createPdf(docDefinition).download('tabelaCliente.pdf');
            });
});


