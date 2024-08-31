document.addEventListener("DOMContentLoaded", function () {
    const customerTable = document.querySelector("#customerTable tbody");
    const postTable = document.querySelector("#postTable tbody");
    let selectedCustomerId = null;

    function loadCustomers() {
        $.ajax({
            url: "tableClientePosts",
            method: "GET",
            dataType: "json",
            success: function (data) {
                customerTable.innerHTML = "";
                postTable.innerHTML = "";

                data.forEach(function (cliente) {
                    const row = document.createElement("tr");
                    row.dataset.customerId = cliente.idCliente;
                    row.innerHTML = `
                        <td class="fw-bold" scope="row">${cliente.idCliente}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.idade}</td>
                    `;
                    customerTable.appendChild(row);
                    row.addEventListener("click", () => {
                        const rowData = row.children;
                        const idCliente = rowData[0].innerHTML;
                        selectedCustomerId = idCliente;
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
                document.getElementById("postTableContainer").classList.remove("hidden");
            },
            
            error: function (error) {
                console.error("Erro ao buscar dados dos clientes: " + error);
            }
        });
    }

    function loadPosts(selectedCustomerId) {
        $.ajax({
            url: `retornaPosts?idCliente=${selectedCustomerId}`, // ID do cliente
            method: "GET",
            dataType: "json",
            success: function (data) {
                postTable.innerHTML = "";

                data.forEach(function (post) {
                    const row = document.createElement("tr");
                    const backgroundColorClass = getBackgroundColorClass(post.tipoESG); // Obtenha a classe de fundo com base no tipoESG
                    row.innerHTML = `
                        <td class="fw-bold" scope="row">${post.idPost}</td>
                        <td>${post.mensagem}</td>
                        <td>${post.tipoESG}</td>
                    `;
                    row.classList.add(backgroundColorClass); // Adicione a classe de fundo à linha
                    postTable.appendChild(row);

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

                        // Remova todas as classes de fundo existentes do elemento com o ID "corpoCard"
                        document.getElementById("corpoCard").classList.remove('bg-success-subtle', 'bg-warning-subtle', 'bg-primary-subtle');

                        // Adicione a nova classe de fundo com base no tipoESG
                        document.getElementById("corpoCard").classList.add(getBackgroundColor(tipoESG));

                        document.getElementById("customerInfoCard").classList.add("hidden");
                        document.getElementById("postDetailsCard").classList.remove("hidden");
                    });
                });
            },
            error: function (error) {
                console.error("Erro ao buscar dados dos posts: " + error);
            }
        });
    }

    // Função para obter a classe de fundo com base no tipo de post
    function getBackgroundColorClass(tipoESG) {
        switch (tipoESG) {
            case 'E':
                return 'table-success'; // Fundo verde
            case 'S':
                return 'table-warning'; // Fundo amarelo
            case 'G':
                return 'table-primary'; // Fundo azul
            default:
                return ''; // Nenhuma classe de fundo
        }
    }

    // Função para obter a classe de fundo para o card com base no tipo de post
    function getBackgroundColor(tipoESG) {
        switch (tipoESG) {
            case 'E':
                return 'bg-success-subtle'; // Fundo verde
            case 'S':
                return 'bg-warning-subtle'; // Fundo amarelo
            case 'G':
                return 'bg-primary-subtle'; // Fundo azul
            default:
                return ''; // Nenhuma classe de fundo
        }
    }

    customerTable.addEventListener("click", function (event) {
        const row = event.target.closest("tr");
        if (!row) return;

        const customerId = row.dataset.customerId;
        if (!customerId) return;

        document.getElementById("customerInfoCard").classList.add("hidden");
        document.getElementById("customerImage").style.display = "block";
        document.getElementById("clienteDetailsCard").classList.remove("hidden");

        loadPosts(customerId);
    });

    // Event listener para o botão de download de PDF
    document.getElementById('download-pdf').addEventListener('click', function () {
        if (!selectedCustomerId) {
            alert("Selecione um cliente antes de gerar o PDF.");
            return;
        }

        const customerRow = document.querySelector(`tr[data-customer-id="${selectedCustomerId}"]`);
        const customerData = [
            customerRow.querySelector("td:nth-child(1)").textContent,
            customerRow.querySelector("td:nth-child(2)").textContent,
            customerRow.querySelector("td:nth-child(3)").textContent
        ];

        const postRows = Array.from(postTable.children);
        const postData = postRows.map((row) => [
            row.querySelector("td:nth-child(1)").textContent,
            row.querySelector("td:nth-child(2)").textContent,
            row.querySelector("td:nth-child(3)").textContent
        ]);

        const docDefinition = {
            content: [
                { text: 'Cliente e seus Posts em PDF', style: 'header' },
                { text: 'Dados do Cliente:', style: 'subheader' },
                {
                    table: {
                        widths: ['*', '*', '*'],
                        body: [customerData]
                    }
                },
                { text: 'Posts do Cliente:', style: 'subheader' },
                {
                    table: {
                        headerRows: 1,
                        widths: ['*', '*', '*'],
                        body: [ ['ID', 'Mensagem', 'Tipo ESG'], ...postData ]
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

        pdfMake.createPdf(docDefinition).download(`cliente_${selectedCustomerId}_posts.pdf`);
    });

    // Inicialização - carregar os clientes iniciais
    loadCustomers();
    
    
    
});

